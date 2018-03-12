package springmvc.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springmvc.dao.RedisDao;
import springmvc.model.User;
import springmvc.service.ArticleService;
import springmvc.service.UserService;

@Component
public class InitDB implements InitializingBean {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	RedisDao redisDao;
	@Autowired
	UserService userservice;
	@Autowired
	ArticleService articleservice;

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		// 清空redis 01 数据库
		String result = redisDao.flushDB();
		System.out.println("");
		logger.info("==================清空redis 01 数据库=======================");
		logger.info("==================结果：" + result + "=======================");
		userservice.flushUsers();
		logger.info("==================清空MySQL 数据库的users表=======================");
		User user = new User();
		user.setAdmin(1);
		user.setEmail("1061295856@qq.com");
		user.setPassword("admin");
		user.setUsername("admin");
		userservice.add(user);
		logger.info("==================添加默认用户《用户名：admin;密码：admin》=======================");

	}

}