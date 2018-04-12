package springmvc.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl {
	@Autowired
	private JavaMailSender mailSender;

	public void send(SimpleMailMessage mail) {
		mailSender.send(mail);
	}

}
