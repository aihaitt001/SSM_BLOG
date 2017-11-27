package springmvc.log;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoginLogger {

	static Logger logger = LogManager.getLogger("loginlog");

	@Pointcut("execution(** springmvc.controller.LoginController.login(..))")
	public void userlogin() {
	}

	@Around("userlogin()")
	public void watchUserLogin(ProceedingJoinPoint jp) {
		try {
			logger.info("start watch");
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			// jp.proceed(result);
			jp.proceed();
			System.out.println("prprpr");
			logger.info("performance end");
		} catch (Throwable e) {
			System.out.println("throw a ex::" + e);
			logger.info("throw a ex:" + e);
		}
	}
}
