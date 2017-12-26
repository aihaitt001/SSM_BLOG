package springmvc.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userservice;

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
			session.setAttribute("user_session", user);
			mav.setViewName("redirect:listArtcles");
		}

		return mav;

	}

	@RequestMapping("/login")

	public ModelAndView login(String flag, String username, String password, ModelAndView mav, HttpSession session) {
		if (flag == null) {
			flag = "1";
		}
		if (flag.equals("1")) {
			System.out.println("login 1");
			mav.setViewName("/login.html");
		} else if (flag.equals("2")) {

			User getuser = userservice.checkUsername(username);
			System.out.println(getuser);
			String getpassword = "";

			if (getuser == null) {

				System.out.println("用户名不正确");
				// mav.setViewName("redirect:/error");
				mav.addObject("message", "用户名不正确");
				mav.setViewName("/login.html");
			} else {
				getpassword = getuser.getpassword();
				if (getpassword.equals(password)) {
					System.out.println("登陆成功");
					// mav.addObject("username", getuser.getUsername());
					session.setAttribute("user_session", getuser);

					if (getuser.getAdmin() == 1) {
						// mav.addObject("admin", "管理员");
						mav.setViewName("redirect:/admin");
					} else {
						// mav.addObject("admin", "普通用户");
						mav.setViewName("redirect:/articles");
					}

				} else {
					System.out.println("密码不正确");
					mav.addObject("message", "密码不正确");
					mav.setViewName("/login.html");
				}
			}
		} else {
			System.out.println("flag is " + flag);
		}

		return mav;

	}
}
