package springmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class LoginController {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	UserService userservice;

	String flagtest = "1";

	/**
	 * 
	 * @return message:["":未登录||user{id,username,password,salt,admin}:已登录]
	 */
	@ResponseBody
	@RequestMapping("/check_loginning")
	public String check_loginning() {
		// logger.info("check_loginning");
		Subject currentUser = SecurityUtils.getSubject();
		ObjectMapper mapper = new ObjectMapper();
		String message = "";
		if (!currentUser.isAuthenticated() && !currentUser.isRemembered()) {
			return message;
		} else {
			User user = (userservice.checkUsername((String) currentUser.getPrincipal()));

			try {
				message = mapper.writeValueAsString(user);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				logger.error("user转换json失败" + e);
				// return message;
			}
			// logger.info(message + "已登录 ");
		}
		return message;
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(String flag, String username, String password, ModelAndView mav) {
		String result = "/login.html";
		String message = "点击按钮登陆";
		if (flag == null) {
			flag = "1";
			message = "";
		}
		if (flagtest.equals(flag)) {

		} else if (flag.equals("2")) {
			if (null != username && null != password) {
				// logger.info("输入正常");
			} else {
				logger.info("用户名或密码没有输入");
				message = "用户名或密码没有输入";
				mav.addObject("message", message);
				return mav;
			}
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			// logger.info("为了验证登录用户而封装的token为" + token);
			// 获取当前的Subject
			Subject currentUser = SecurityUtils.getSubject();

			try {
				// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
				// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
				// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
				logger.info("对用户[" + username + "]进行登录验证..验证开始");
				currentUser.login(token);
				logger.info("对用户[" + username + "]验证通过");

			} catch (UnknownAccountException uae) {
				logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
				message = "未知账户";
			} catch (IncorrectCredentialsException ice) {
				logger.info("对用户[" + username + "]进行登录验证..验证未通过,密码错误");
				message = "密码不正确";
			} catch (LockedAccountException lae) {
				logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
				message = "账户已锁定";

			} catch (ExcessiveAttemptsException eae) {
				logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
				message = "用户名或密码错误次数过多";

			} catch (AuthenticationException ae) {
				// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
				logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
				ae.printStackTrace();
				message = "未通过";
			}
			// 验证是否登录成功
			if (currentUser.isAuthenticated()) {
				// logger.info("登陆成功");
				// logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
				User user = ((User) currentUser.getSession().getAttribute("currentUser"));

				if (user.getAdmin() == 1) {
					result = "redirect:/admin";
				} else if (user.getAdmin() == 2) {
					result = "redirect:/normaluser";
				} else {
					result = "/login.html";
				}
			} else {
				token.clear();
			}

		}
		mav.addObject("message", message);
		mav.setViewName(result);
		return mav;
	}

	/**
	 * 用户登出
	 */

	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView mav) {
		String result = "注销成功";
		try {
			SecurityUtils.getSubject().logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			result = "注销失败";
		} finally {
			System.out.println(result);
			logger.info(result);
		}
		mav.setViewName("redirect:/login");
		return mav;

	}

	@RequestMapping("/kickout")
	public ModelAndView kuckout(ModelAndView mav) {

		mav.setViewName("kickout.html");
		return mav;

	}
}
