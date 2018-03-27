package springmvc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginLogger {

	Logger logger = LogManager.getLogger("root");

	@Pointcut("execution(** springmvc.controller.LoginController.login(..))")
	public void userlogin() {
	}

	@Around("userlogin()")
	public void watchUserLogin(ProceedingJoinPoint jp) {
		System.out.println("login logger start");
		try {

			logger.info("login start");

			jp.proceed();

			logger.info("login end");
		} catch (Throwable e) {

			logger.info("throw a ex:" + e);
		}
	}
}
