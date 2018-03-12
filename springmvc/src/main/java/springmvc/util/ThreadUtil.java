package springmvc.util;

public class ThreadUtil {
	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
			System.out.println("程序暂停" + time + "秒。。。");
		} catch (Exception e) {
			System.out.println("异常" + e);
		}
	}

}
