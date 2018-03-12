package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

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

	Logger logger = LogManager.getLogger(this.getClass().getName());

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

	@RequestMapping("/normaluser")
	public ModelAndView normalUser(ModelAndView mav, @RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "1") int pageSize) {
		System.out.println("normaluser");
		List<Article> articles = new ArrayList<Article>();
		User user = new User();

		String sessionname = "游客";
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated() && !currentUser.isRemembered()) {
			mav.setViewName("redirect:/login");

			return mav;
		}
		user.setUsername((String) currentUser.getPrincipal());
		// shiro
		// remember并不能把session也一起记住，要想实现，得手动配置过滤器什么的，从shiro的sessionmanage中找到还没被销毁的sessionId(???)。
		// user = (User)currentUser.getSession().getAttribute("currentUser");
		if (null != user) {
			sessionname = user.getUsername();
			logger.info("normaluser:" + user);
			// articles = articleservice.listByAuthor(user.getUsername());
			articles = articleservice.listArticleByPage(user.getUsername(), pageNum, pageSize);

		}

		if (null == articles) {
			Article article = new Article();
			article.setBody("您还没有发表过文章！");
			article.setTitle("文章列表是空的！");
			articles.add(article);

		}

		mav.addObject("user", user);
		mav.addObject("pageInfo", new PageInfo<Article>(articles));
		mav.addObject("articles", articles);
		mav.setViewName("/user.html");

		return mav;

	}

}
