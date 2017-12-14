package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller

@RequestMapping("/User")
public class UserController {
	@Autowired
	UserService userservice;

	@RequestMapping("value = \"/{artcleId}\", method = RequestMethod.DELETE")
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
	@RequestMapping("/updateUser")
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
