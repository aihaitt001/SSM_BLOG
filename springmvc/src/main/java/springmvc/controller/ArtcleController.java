package springmvc.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Artcle;
import springmvc.model.User;
import springmvc.service.ArtcleService;

/*
 * 1. 尝试采用REST风格。
 * 
 * 
 * 
 * */
@Controller
@RequestMapping("/artcles")
public class ArtcleController {

	@Autowired
	ArtcleService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listArtcles(ModelAndView mav) {
		System.out.println("listArtcles");
		List<Artcle> artcles;
		artcles = service.list();
		if (artcles == null) {

		} else {
			for (Artcle artcle : artcles) {
				System.out.println(artcle.getCreateTime());
			}
			mav.addObject("artcles", artcles);
			mav.setViewName("/listArtcles.html");
		}
		return mav;
	}

	@RequestMapping(value = "/{artcleId}", method = RequestMethod.GET)
	public ModelAndView getArtcleByArtcleId(ModelAndView mav) {
		System.out.println("getArtcleByArtcleId");
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addArtcle(String flag, @ModelAttribute Artcle artcle, ModelAndView mav,
			HttpServletRequest request) {
		System.out.println("addArtcle");
		System.out.println(flag);
		if (flag.equals("2")) {
			System.out.println("flag=" + flag);
			Date date = new Date();
			Timestamp createtime = new Timestamp(date.getTime());
			artcle.setCreateTime(createtime);
			User user = (User) request.getSession().getAttribute("user_session");
			artcle.setAuthor(user.getUsername());
			System.out.println(artcle);
			service.add(artcle);
			mav.setViewName("listArtcles.html");
		} else {
			mav.setViewName("addArtcle.html");
		}

		return mav;

	}

	@RequestMapping(value = "/{artcleId}", method = RequestMethod.PUT)
	public ModelAndView updateArtcleByArtcleId(String flag, @ModelAttribute Artcle artcle, ModelAndView mav) {
		System.out.println("updateArtcleByArtcleId");
		return mav;

	}

	@RequestMapping(value = "/{artcleId}", method = RequestMethod.DELETE)
	public ModelAndView deleteArtcleByArtcleId(String flag, ModelAndView mav) {
		System.out.println("deleteArtcleByArtcleId");
		return mav;

	}
}
