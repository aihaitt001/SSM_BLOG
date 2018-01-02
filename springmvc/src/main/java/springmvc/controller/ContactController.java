package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.model.Report;
import springmvc.util.EmailUtilImpl;

@Controller
public class ContactController {

	@Autowired
	EmailUtilImpl sender;

	@ResponseBody
	@RequestMapping("/report")
	public String report(@RequestBody Report report) {
		String msg = "成功";
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("1061295856@qq.com");// 收件人邮箱地址
		mail.setFrom("1061295856@qq.com");// 收件人
		mail.setSubject("From lifeforfun");// 主题
		mail.setText(String.valueOf(report));// 正文
		try {

			sender.send(mail);
		} catch (Exception e) {
			msg = "邮件发送失败！";
		}

		return msg;
	}
}
