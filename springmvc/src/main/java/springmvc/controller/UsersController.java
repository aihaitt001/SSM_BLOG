package springmvc.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller

public class UsersController {
	@Autowired
	UserService userservice;

	@RequestMapping("/error")
	public ModelAndView error(ModelAndView mav) {
		mav.setViewName("error.jsp");
		return mav;

	}

	@RequestMapping("/success")
	public ModelAndView success(ModelAndView mav) {
		mav.setViewName("success.jsp");
		return mav;

	}

	@RequestMapping("/listUsers")
	public ModelAndView listUsers() {
		System.out.println("listUsers");
		ModelAndView mav = new ModelAndView();
		List<User> users = userservice.list();
		// 放入转发参数
		mav.addObject("users", users);

		mav.setViewName("listUsers.jsp");
		return mav;
	}

	/**
	 * 利用form提交请求。 flag 判定是否添加。1：进入 新增页面。2：新增操作，进入列表页面。
	 * 
	 **/
	@RequestMapping("/addUser")
	public ModelAndView addUser(String flag, @ModelAttribute User user, ModelAndView mav) {
		if (flag != null) {
			if (flag.equals("1")) {
				mav.setViewName("addUser.jsp");
			} else {
				System.out.println(user);
				Date date = new Date();

				Timestamp createtime = new Timestamp(date.getTime());
				System.out.println(createtime);
				user.setCreatetime(createtime);

				System.out.println(user);
				userservice.add(user);

				mav.setViewName("redirect:listUsers");
			}
		} else {
			System.out.println("flag =null");
		}
		return mav;
	}

	@RequestMapping(value = "/User/{artcleId}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(String ids, ModelAndView mv) {
		String[] idlist = ids.split(",");
		for (String id : idlist) {
			userservice.delete(Integer.valueOf(id));
		}
		mv.setViewName("redirect:/listUsers");
		return mv;
	}

	/**
	 * flag为判定是进入更新页面（1）。还是提交更新页面（2）。
	 **/
	@RequestMapping(value = "/User/updateUser")
	public ModelAndView updateUser(String flag, @ModelAttribute User user, ModelAndView mv) {
		if (flag != null) {
			if (flag.equals("1")) {
				System.out.println("更新前：" + user);
				System.out.println("更新前id：" + user.getId());
				// 根据id查询用户
				User target = userservice.getById(user.getId());
				// 设置Model数据
				mv.addObject("user", target);
				// 返回修改员工页面
				mv.setViewName("/updateUser.jsp");
			} else if (flag.equals("2")) {
				// 执行修改操作
				System.out.println("更新后id：" + user.getId());
				System.out.println("更新后：" + user);
				userservice.update(user);

				// 设置客户端跳转到查询请求
				mv.setViewName("redirect:/listUsers");

			}
		} else {
			System.out.println("flag =null");
			mv.setViewName("/updateUser.jsp");
		}

		return mv;

	}
}
