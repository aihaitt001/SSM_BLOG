package springmvc.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Artcle;
import springmvc.model.User;
import springmvc.service.ArtcleService;

/*
 * 1. 尝试采用REST风格。
 * */
@Controller
@RequestMapping("/artcles")
public class ArtcleController {

	@Autowired
	ArtcleService service;

	/*
	 * 列出所有的文章
	 */
	@RequestMapping(method = RequestMethod.GET)
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
			mav.setViewName("/listArtcles.html");
		}
		return mav;
	}

	/*
	 * 获得artcleId相应的文章
	 */
	@RequestMapping(value = "/{artcleId}", method = RequestMethod.GET)
	public ModelAndView getArtcleByArtcleId(@PathVariable Integer artcleId, ModelAndView mav, HttpSession session) {
		System.out.println("getArtcleByArtcleId");

		String sessionname = "游客";
		User user = new User();
		user.setUsername("游客");
		if (session.getAttribute("user_session") != null) {
			user = (User) session.getAttribute("user_session");
			sessionname = user.getUsername();
			System.out.println(user);
		}
		Artcle artcle = service.getByArtcleId(artcleId);
		System.out.println(artcle);
		mav.addObject("artcle", artcle);
		mav.addObject("user", user);
		mav.setViewName("artcle.html");
		return mav;

	}

	/*
	 * 新增文章
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addArtcle(String flag, @ModelAttribute Artcle artcle, ModelAndView mav,
			HttpServletRequest request) {
		System.out.println("addArtcle");
		System.out.println(flag);
		if (flag.equals("2")) {
			System.out.println("flag=" + flag);
			Date date = new Date();
			Timestamp createtime = new Timestamp(date.getTime());
			artcle.setCreatetime(createtime);
			User user = (User) request.getSession().getAttribute("user_session");
			artcle.setAuthor(user.getUsername());
			System.out.println(artcle);
			service.add(artcle);
			mav.addObject("user", user);
			mav.setViewName("listArtcles.html");
		} else {
			mav.setViewName("addArtcle.html");
		}

		return mav;

	}

	/*
	 * 文章修改
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public String updateArtcleByArtcleId(@RequestBody Artcle artcle) {
		System.out.println("updateArtcle:" + artcle);
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		artcle.setCreatetime(createtime);
		service.update(artcle);
		return "update success";
	}

	/*
	 * 删除文章
	 */
	@ResponseBody
	@RequestMapping(value = "/{artcleid}", method = RequestMethod.DELETE)
	public String deleteArtcleByArtcleId(@PathVariable Integer artcleid) throws IOException {
		System.out.println("deleteArtcleByArtcleId:" + artcleid);
		service.delete(artcleid);
		return "delete success";

	}
}
