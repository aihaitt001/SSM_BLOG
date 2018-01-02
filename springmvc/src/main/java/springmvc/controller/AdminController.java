package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService service;

	@RequestMapping("/admin")
	public ModelAndView admin(ModelAndView mav, HttpSession session) {
		List<User> users;
		User user = new User();

		String sessionname = "游客";

		if (session.getAttribute("user_session") != null) {
			user = (User) session.getAttribute("user_session");
			sessionname = user.getUsername();
			// System.out.println(user);
		}

		users = service.list();

		user.setUsername(sessionname);

		mav.addObject("user", user);

		if (users == null) {
			mav.setViewName("/login.html");
		} else {

			mav.addObject("users", users);
			mav.setViewName("/admin.html");
		}

		return mav;

	}
}
