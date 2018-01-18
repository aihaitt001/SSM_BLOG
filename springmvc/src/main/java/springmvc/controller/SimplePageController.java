package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.service.ArticleService;

@Controller
public class SimplePageController {

	@Autowired
	ArticleService service;

	@RequestMapping(value = "/footer")
	public ModelAndView footer(ModelAndView mav) {
		mav.setViewName("footer.html");
		return mav;
	}

	@RequestMapping(value = "/nav")
	public ModelAndView nav(ModelAndView mav) {
		mav.setViewName("nav.html");
		return mav;
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact.html";
	}

	// /*
	// * 列出所有的文章
	// */
	// @RequestMapping(value = "/main", method = RequestMethod.GET)
	// public ModelAndView listArtcles(ModelAndView mav, HttpSession session) {
	// System.out.println("listArtcles");
	// List<Article> articles;
	// User user = new User();
	// articles = service.list();
	// if (articles == null) {
	//
	// } else {
	//
	// String sessionname = "游客";
	// user.setUsername("游客");
	// if (session.getAttribute("user_session") != null) {
	// user = (User) session.getAttribute("user_session");
	// sessionname = user.getUsername();
	// // System.out.println(user);
	// }
	//
	// mav.addObject("user", user);
	//
	// for (Article article : articles) {
	// System.out.println(article);
	// }
	// mav.addObject("articles", articles);
	// mav.setViewName("/main.html");
	// }
	// return mav;
	// }

	@RequestMapping("/left")
	public String left() {
		return "left.jsp";
	}

	@RequestMapping("/right")
	public String right() {
		return "right.jsp";
	}
}
