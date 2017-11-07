package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller

public class UserController {
	@Autowired
	UserService userservice;

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute User user, ModelAndView mav, HttpSession session) {

		System.out.println(user);
		String username = user.getUsername();
		session.setAttribute("username", username);
		String password = userservice.checkUsername(username);
		System.out.println(password);
		if (password == null) {
			System.out.println("用户名不正确");
			mav.setViewName("redirect:/error");
		} else {
			if (password.equals(user.getpassword())) {
				System.out.println("登陆成功");
				mav.setViewName("redirect:/list");
			} else {
				System.out.println("密码不正确");
				mav.setViewName("redirect:/error");
			}
		}

		return mav;

	}

	// public void login(@RequestBody User user, HttpServletResponse response)
	// throws JsonGenerationException, JsonMappingException, IOException {
	//
	// ObjectMapper mapper = new ObjectMapper();
	// String result = "登陆成功";
	// response.setContentType("text/html;charset=UTF-8");
	//
	// String username = user.getUsername();
	// String password = userservice.checkUsername(username);
	// System.out.println(password);
	// if (password == null) {
	// System.out.println("用户名不正确");
	// result = "用户名不正确";
	// response.getWriter().println(mapper.writeValueAsString(result));
	//
	// } else {
	// if (password.equals(user.getpassword())) {
	//
	// // 将result对象转换成json写出到客户端
	// response.getWriter().println(mapper.writeValueAsString(result));
	//
	// } else {
	// result = "密码不正确";
	// response.getWriter().println(mapper.writeValueAsString(result));
	// }
	// }
	//
	// }
	@RequestMapping("/error")
	public ModelAndView error(ModelAndView mav) {
		mav.setViewName("error");
		return mav;

	}

	@RequestMapping("/success")
	public ModelAndView success(ModelAndView mav) {
		mav.setViewName("success");
		return mav;

	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userservice.list();
		// 放入转发参数
		mav.addObject("users", users);

		mav.setViewName("list");
		return mav;
	}

	/**
	 * 利用form提交请求。 flag 判定是否添加。1：进入 新增页面。2：新增操作，进入列表页面。
	 * 
	 **/
	@RequestMapping("/add")
	public ModelAndView add(String flag, @ModelAttribute User user, ModelAndView mav) {
		if (flag != null) {
			if (flag.equals("1")) {
				mav.setViewName("add");
			} else {
				System.out.println(user);
				userservice.add(user);
				mav.setViewName("redirect:list");
			}
		} else {
			System.out.println("flag =null");
		}
		return mav;
	}

	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(String ids, ModelAndView mv) {
		String[] idlist = ids.split(",");
		for (String id : idlist) {
			userservice.delete(Integer.valueOf(id));
		}
		mv.setViewName("redirect:/list");
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
				mv.setViewName("/update");
			} else if (flag.equals("2")) {
				// 执行修改操作
				System.out.println("更新后id：" + user.getId());
				System.out.println("更新后：" + user);
				userservice.update(user);

				// 设置客户端跳转到查询请求
				mv.setViewName("redirect:/list");

			}
		} else {
			System.out.println("flag =null");
		}

		return mv;

	}
}
