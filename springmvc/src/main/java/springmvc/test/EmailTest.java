package springmvc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;

import springmvc.util.EmailUtilImpl;

public class EmailTest {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmailUtilImpl sender = ac.getBean(EmailUtilImpl.class);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("1061295856@qq.com");// 收件人邮箱地址
		mail.setFrom("1061295856@qq.com");// 收件人
		mail.setSubject("From lifeforfun");// 主题
		mail.setText("hello! ");// 正文
		sender.send(mail);
	}
}
