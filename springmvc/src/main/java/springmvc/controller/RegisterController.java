package springmvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class RegisterController {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	UserService service;

	@ResponseBody
	@RequestMapping(value = "/register/checkUsername", method = RequestMethod.POST)
	public String checkUsername(@RequestBody User user) {
		String message = "yes";
		logger.info(user.toString());
		if (null != service.checkUsername(user.getUsername())
				&& user.getUsername().equals(service.checkUsername(user.getUsername()).getUsername())) {
			logger.info("checkUsername" + service.checkUsername(user.getUsername()));
			message = "no";
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "/register/addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody User user, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset:UTF-8");

		logger.info("addUser:" + user.toString());
		String message = "注册成功！";
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();

		if (null != service.checkUsername(username)) {
			message = "用户名" + username + "重复";
			// logger.error(message);

			return message;
		} else {
			// logger.info("register 2");

			user.setAdmin(2);
			user.setEmail(email);
			user.setPassword(password);
			user.setUsername(username);
			logger.info("新增用户" + user.getUsername());
			try {
				service.add(user);

			} catch (Exception e) {
				message = "注册时发生错误：" + e.toString();
			} finally {
				logger.error(message);

			}

		}

		return message;

	}

}
