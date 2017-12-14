package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Artcle;
import springmvc.model.User;
import springmvc.service.ArtcleService;

@Controller
public class SimplePageController {

	@Autowired
	ArtcleService service;

	/*
	 * 列出所有的文章
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView listArtcles(ModelAndView mav, HttpSession session) {
		System.out.println("listArtcles");
		List<Artcle> artcles;
		User user = new User();
		artcles = service.list();
		if (artcles == null) {

		} else {

			String sessionname = "游客";
			user.setUsername("游客");
			if (session.getAttribute("user_session") != null) {
				user = (User) session.getAttribute("user_session");
				sessionname = user.getUsername();
				// System.out.println(user);
			}

			mav.addObject("user", user);

			for (Artcle artcle : artcles) {
				System.out.println(artcle);
			}
			mav.addObject("artcles", artcles);
			mav.setViewName("/main.html");
		}
		return mav;
	}

	@RequestMapping("/contract")
	public String contract() {
		return "contract.html";
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
