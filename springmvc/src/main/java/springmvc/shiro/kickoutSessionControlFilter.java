package springmvc.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;

public class kickoutSessionControlFilter extends AccessControlFilter {
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// // TODO Auto-generated method stub
		// Subject subject = getSubject(request, response);
		//
		// if (!subject.isAuthenticated() && !subject.isRemembered()) {
		// // 如果没有登陆，进行后面的流程
		// return true;
		// }
		// Session session = subject.getSession();
		// String username = (String) subject.getPrincipal();
		// Serializable sessionId = session.getId();
		// session.getAttribute("currentUser");
		return true;
	}

}
