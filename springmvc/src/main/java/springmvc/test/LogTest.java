package springmvc.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {

	static Logger logger = LogManager.getLogger(LogTest.class.getName());

	public static boolean hello() {
		logger.trace("entry"); // 等同于logger.entry();但此方法在新版本好像已经废弃

		logger.error("Did it again!");

		logger.info("这是info级信息");

		logger.debug("这是debug级信息");

		logger.warn("这是warn级信息");

		logger.fatal("严重错误");

		logger.trace("exit");

		return false;
	}

	public static void main(String[] args) {

		logger.trace("开始主程序");

		for (int i = 0; i < 10; i++) {
			logger.info("当前i:" + i);
			if (!hello()) {
				logger.error("hello");
			}
		}

		logger.trace("退出程序");
	}

}
