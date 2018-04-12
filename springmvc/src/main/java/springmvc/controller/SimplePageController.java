package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Article;
import springmvc.service.ArticleService;

@Controller
public class SimplePageController {

	@Autowired
	ArticleService service;

	@RequestMapping(value = "/ckedit")
	public ModelAndView getArticle(ModelAndView mav) {
		mav.setViewName("ckedit.html");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/getArticle", method = RequestMethod.POST)
	public String getArticle(@RequestBody Article article) {

		System.out.println("getArticle");
		System.out.println(article.toString());
		String bodytext = article.getBody();
		if (null == bodytext || bodytext == "") {
			bodytext = "没有接收到信息";
		}
		return bodytext;
	}

	@RequestMapping(value = "/register")
	public ModelAndView register(ModelAndView mav) {

		String viewname = "register.html";

		mav.setViewName(viewname);
		return mav;

	}

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

}
