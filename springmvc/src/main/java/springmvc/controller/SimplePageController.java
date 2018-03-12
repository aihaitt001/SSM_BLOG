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

	@RequestMapping("/left")
	public String left() {
		return "left.jsp";
	}

	@RequestMapping("/right")
	public String right() {
		return "right.jsp";
	}
}
