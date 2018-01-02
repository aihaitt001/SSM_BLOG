package springmvc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginLoggerMethod {
	static Logger logger = LogManager.getLogger("LoginLoggerMethod.class.getName()");

	public void beforeLogin() {
		System.out.println("login...");
		logger.info("login...");
	}

	public void afterLogin() {
		logger.info("login  success");
	}

	public void afterReturn() {
		logger.info("login return");
	}

	public void afterThrow() {
		logger.info("login wrong");
	}
}
