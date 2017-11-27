package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Artcle;
import springmvc.service.ArtcleService;

@Controller
public class ArtcleController {

	@Autowired
	ArtcleService service;

	@RequestMapping("/listArtcles")
	public ModelAndView listArtcles(ModelAndView mav) {
		System.out.println("listArtcles");
		List<Artcle> artcles;
		artcles = service.list();
		if (artcles == null) {

		} else {
			for (Artcle artcle : artcles) {
				System.out.println(artcle);
			}
			mav.setViewName("/listArtcles.html");
		}
		return mav;
	}
}
