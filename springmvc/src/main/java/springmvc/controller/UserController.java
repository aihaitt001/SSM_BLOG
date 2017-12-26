package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Article;
import springmvc.model.User;
import springmvc.service.ArticleService;

@Controller
public class UserController {
	@Autowired
	ArticleService service;

	@RequestMapping("/user")
	public ModelAndView user(ModelAndView mav, HttpSession session) {
		List<Article> articles;
		User user = new User();
		articles = service.list();
		if (articles == null) {

		} else {

			String sessionname = "游客";

			if (session.getAttribute("user_session") != null) {
				user = (User) session.getAttribute("user_session");
				sessionname = user.getUsername();
				// System.out.println(user);
			}

			user.setUsername(sessionname);

			mav.addObject("user", user);

			mav.addObject("articles", articles);
			mav.setViewName("/user.html");
		}
		return mav;

	}
}
