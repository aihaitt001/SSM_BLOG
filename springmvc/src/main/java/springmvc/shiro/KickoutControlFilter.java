package springmvc.shiro;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.dao.RedisDao;

public class KickoutControlFilter extends AccessControlFilter {

	Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	RedisDao redisDao;
	@Autowired
	private SessionManager sessionManager;

	// isAccessAllowed：表示是否允许访问.返回false会代表不允许，转到onAccessDenied().
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object arg2) throws Exception {

		return false;
	}

	// onAccessDenied：表示当访问拒绝时是否已经处理了.如果返回 true 表示需要继续处理；如果返回 false
	// 表示该拦截器实例已经处理了，将直接返回即可。
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// logger.info("onAccessDenied");
		// TODO Auto-generated method stub
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated() && !subject.isRemembered()) {

			return true;
		}

		Session session = subject.getSession();
		String username = (String) subject.getPrincipal();
		Serializable sessionId = session.getId();
		logger.info("当前sessionId：：" + sessionId);
		// TODO 同步控制
		List<String> list = redisDao.lrange(username, 0, -1);
		if (list == null) {
			// logger.info(username + "为空，添加一个");
			list = new LinkedList<String>();
			// list.add((String)sessionId);
		}
		logger.info("list:" + list);
		// 如果队列里没有此sessionId，且用户没有被踢出；放入队列
		if (!list.contains(sessionId) && session.getAttribute("kickout") == null) {
			list.add((String) sessionId);

			redisDao.lpush(username, (String) sessionId);
			// logger.info(sessionId + "放入队列。缓存");
		}

		// 如果队列里的sessionId数超出最大会话数，开始踢人
		while (list.size() > 1) {
			Serializable kickoutSessionId = null;

			kickoutSessionId = list.get(0);
			list.remove(0);
			redisDao.rpop(username);
			try {
				Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
				if (kickoutSession != null) {
					// 设置会话的kickout属性表示踢出了
					kickoutSession.setAttribute("kickout", true);
					// logger.info("获得kickoutid " + kickoutSessionId + "设置kickout为true");
				}
			} catch (Exception e) {// ignore exception
			}
		}
		// logger.info("当前" + sessionId + "kickout=" + session.getAttribute("kickout"));
		// 如果被踢出了，直接退出，重定向到踢出后的地址
		if (null != session.getAttribute("kickout")) {
			// 会话被踢出了
			// logger.info(session.getId() + "logout");
			try {
				subject.logout();
				// redirectToLogin(request, response);
				// HttpServletRequest httprequest = WebUtils.toHttp(request);
				HttpServletResponse httpresponse = WebUtils.toHttp(response);
				httpresponse.sendRedirect("/kickout");
			} catch (Exception e) {
				logger.error("并发控制踢出前者时发生错误：" + e);
			}
			return false;

		}

		return true;

	}

}
