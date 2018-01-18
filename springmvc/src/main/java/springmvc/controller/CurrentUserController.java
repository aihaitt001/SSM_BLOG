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
import springmvc.service.UserService;

/*
 * 用户对个人主页请求的处理
 * 
 * */
@Controller
public class CurrentUserController {

	@Autowired
	UserService userservice;
	@Autowired
	ArticleService articleservice;

	@RequestMapping("/admin")
	public ModelAndView admin(ModelAndView mav, HttpSession session) {
		List<User> users;
		User user = new User();

		String sessionname = "游客";

		if (session.getAttribute("currentUser") != null) {
			user = (User) session.getAttribute("currentUser");
			sessionname = user.getUsername();
			// System.out.println(user);
		}

		users = userservice.list();

		user.setUsername(sessionname);

		mav.addObject("user", user);

		mav.addObject("users", users);
		mav.setViewName("/admin.html");

		return mav;

	}

	@SuppressWarnings("null")
	@RequestMapping("/normaluser")
	public ModelAndView normalUser(ModelAndView mav, HttpSession session) {
		System.out.println("normaluser");
		List<Article> articles;
		User user = new User();

		String sessionname = "游客";

		if (session.getAttribute("currentUser") != null) {
			user = (User) session.getAttribute("currentUser");
			sessionname = user.getUsername();
			// System.out.println(user);
		}

		articles = articleservice.listByAuthor(user.getUsername());

		user.setUsername(sessionname);

		mav.addObject("user", user);

		if (null == articles) {
			Article article = new Article();
			article.setBody("您还没有发表过文章！");
			article.setTitle("文章列表是空的！");
			articles.add(article);

		}

		mav.addObject("articles", articles);
		mav.setViewName("/user.html");

		return mav;

	}

}
