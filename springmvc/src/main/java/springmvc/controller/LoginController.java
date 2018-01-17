package springmvc.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userservice;

	@ResponseBody
	@RequestMapping("/check_loginning")
	public String check_loginning(HttpServletRequest request, HttpSession session) {

		Subject currentUser = SecurityUtils.getSubject();
		ObjectMapper mapper = new ObjectMapper();
		String message = "";
		if (currentUser.getSession().getAttribute("currentUser") != null) {
			User user = ((User) currentUser.getSession().getAttribute("currentUser"));
			try {
				message = mapper.writeValueAsString(user);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				System.out.println("user转换json失败" + e);
				return message;
			}
			System.out.println(message + "已登录 ");
		} else {

			System.out.println(message + "未登录 ");
		}
		return message;
	}

	// @ResponseBody
	// @RequestMapping("/log_out")
	// public String log_out(HttpServletRequest request, HttpServletResponse
	// response) {
	// String result = "注销成功";
	// try {
	// request.getSession().invalidate();
	// response.sendRedirect("/springmvc/articles");
	// } catch (Exception e) {
	// System.out.println(e);
	// result = "注销失败";
	// } finally {
	// System.out.println(result);
	//
	// }
	// return result;
	// }

	@RequestMapping("/register")
	public ModelAndView register(String flag, @ModelAttribute User user, ModelAndView mav, HttpSession session) {
		if (flag == null) {
			flag = "1";
		}

		if (flag.equals("1")) {
			mav.setViewName("register.jsp");
			System.out.println("register  1");
		} else {
			System.out.println("register  2");

			Date date = new Date();

			Timestamp createtime = new Timestamp(date.getTime());
			System.out.println(createtime);
			user.setCreatetime(createtime);

			System.out.println(user);
			userservice.add(user);
			session.setAttribute("currentUser", user);
			mav.setViewName("redirect:articles");
		}

		return mav;

	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, String flag, String username, String password,
			ModelAndView mav) {
		String result = "/login.html";
		if (flag == null) {
			flag = "1";
		}
		if (flag.equals("1")) {
			System.out.println("login 1");

		} else if (flag.equals("2")) {
			if (null != username && null != password) {
				System.out.println("success");
			} else {
				System.out.println("error" + username);
				return mav;
			}
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			System.out.println("为了验证登录用户而封装的token为" + token);
			// 获取当前的Subject
			Subject currentUser = SecurityUtils.getSubject();

			try {
				// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
				// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
				// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
				System.out.println("对用户[" + username + "]进行登录验证..验证开始");
				currentUser.login(token);
				System.out.println("对用户[" + username + "]进行登录验证..验证通过");

			} catch (UnknownAccountException uae) {
				System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
				mav.addObject("message", "未知账户");
			} catch (IncorrectCredentialsException ice) {
				System.out.println("对用户[" + username + "]进行登录验证..验证未通过,密码错误");
				mav.addObject("message", "密码不正确");
			} catch (LockedAccountException lae) {
				System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
				mav.addObject("message", "账户已锁定");
			} catch (ExcessiveAttemptsException eae) {
				System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
				mav.addObject("message", "用户名或密码错误次数过多");
			} catch (AuthenticationException ae) {
				// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
				System.out.println("对用户[" + username + password + "]进行登录验证..验证未通过,堆栈轨迹如下");
				ae.printStackTrace();
				mav.addObject("message", "用户名或密码不正确");
			}
			// 验证是否登录成功
			if (currentUser.isAuthenticated()) {
				System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
			} else {
				token.clear();
			}
			User user = ((User) currentUser.getSession().getAttribute("currentUser"));
			System.out.println(user);
			if (user.getAdmin() == 1) {
				result = "redirect:/admin";
			} else if (user.getAdmin() == 2) {
				result = "redirect:/normaluser";
			} else {
				result = "/login.html";
			}

		}

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

		}
		mav.setViewName("redirect:/login");
		return mav;

	}
}
