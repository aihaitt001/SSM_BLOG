package springmvc.aop;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginLogger {

	static Logger logger = LogManager.getLogger("LoginLogger.class");

	@Pointcut("execution(** springmvc.controller.LoginController.login(..))")
	public void userlogin() {
	}

	@Around("userlogin()")
	public void watchUserLogin(ProceedingJoinPoint jp) {
		try {

			logger.trace("entry"); // 等同于logger.entry();但此方法在新版本好像已经废弃

			logger.error("Did it again!");

			logger.info("这是info级信息");

			logger.debug("这是debug级信息");

			logger.warn("这是warn级信息");

			logger.fatal("严重错误");

			// jp.proceed(result);
			jp.proceed();

			logger.info("performance end");
		} catch (Throwable e) {

			logger.info("throw a ex:" + e);
		}
	}
}
