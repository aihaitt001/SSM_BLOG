package springmvc.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springmvc.dao.RedisDao;
import springmvc.model.Article;
import springmvc.model.User;
import springmvc.service.ArticleService;
import springmvc.service.UserService;
import springmvc.util.TimeUtil;

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
		user.setAdmin(2);
		user.setEmail("1061295856@qq.com");
		user.setPassword("test");
		user.setUsername("test");
		userservice.add(user);
		logger.info("==================添加默认用户《用户名：test;密码：test》=======================");
		logger.info("==================清空MySQL 数据库的article表=======================");
		articleservice.flushDB();

		Article article = new Article();
		article.setAuthor("test");
		article.setBody("请使用测试账户登陆系统，账号：test,密码：test");
		article.setTitle("Hello World!");
		article.setTags("test");
		article.setCreatetime(TimeUtil.now());
		articleservice.add(article);
		logger.info("==================添加默认文章=======================");
	}

}