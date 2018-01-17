package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Article;
import springmvc.model.User;
import springmvc.service.ArticleService;

/*
 * 对获得文章的请求处理。
 * 
 * 
 * 1. 尝试采用REST风格。
 * */
@Controller
@RequestMapping("/articles")
public class ArticlesController {

	@Autowired
	ArticleService service;

	/*
	 * 列出所有的文章
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarticles(ModelAndView mav, HttpSession session) {
		System.out.println("listarticles");
		List<Article> articles;
		User user = new User();
		articles = service.list();
		if (articles == null) {

		} else {

			user.setUsername("游客");
			if (session.getAttribute("user_session") != null) {
				user = (User) session.getAttribute("user_session");
			}

			mav.addObject("user", user);

			// for (Article article : articles) {
			// //System.out.println(article);
			// }
			mav.addObject("articles", articles);
			mav.setViewName("/articles.html");
		}
		return mav;
	}

	/*
	 * 获得articleId相应的文章
	 */
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
	public ModelAndView getarticleByarticleId(@PathVariable Integer articleId, ModelAndView mav, HttpSession session) {
		System.out.println("getarticleByarticleId");

		User user = new User();
		if (null != session.getAttribute("user_session")) {
			user = (User) session.getAttribute("user_session");
			// System.out.println(user);
		}
		Article article = service.getByArticleId(articleId);
		// System.out.println(article);
		mav.addObject("article", article);
		mav.addObject("user", user);
		mav.setViewName("article.html");
		return mav;

	}

}
