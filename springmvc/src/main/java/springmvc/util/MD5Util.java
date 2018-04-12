package springmvc.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import springmvc.model.User;

public class MD5Util {

	private static String algorithmName = "MD5"; // 加密方式

	private static int hashIterations = 1024; // 加密次数

	public static User EncryptUser(User user) {

		// 随机盐对象
		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		// 根据用户名以及随机生成的盐来拼接成密码盐
		String salt = user.getUsername() + secureRandomNumberGenerator.nextBytes().toHex();

		// 获取加密后的密码
		String passWord = new SimpleHash(algorithmName, user.getPassword(), salt, hashIterations).toHex();

		user.setSalt(salt); // 设置密码盐

		user.setPassword(passWord); // 设置加密过后的密码

		return user;
	}

}
