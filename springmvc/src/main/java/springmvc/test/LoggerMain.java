package springmvc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springmvc.controller.LoginController;

public class LoggerMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Knight knight = (Knight)context.getBean("knight");
		LoginController con = context.getBean(LoginController.class);
		con.login("aa", null, 1);

	}
}
