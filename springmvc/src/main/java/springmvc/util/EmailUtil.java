package springmvc.util;

import javax.mail.MessagingException;

public interface EmailUtil {
	/**
	 * 发送简单邮件
	 * 
	 * @param simpleEmail
	 *            简单邮件详情
	 * @throws MessagingException
	 */
	void sendEmail(SimpleEmail simpleEmail) throws MessagingException;

}
