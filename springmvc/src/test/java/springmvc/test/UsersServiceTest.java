package springmvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmvc.model.User;
import springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class UsersServiceTest {
	@Autowired
	UserService service;

	@Test
	public void Add() {
		User user = new User();

		user.setAdmin(1);
		user.setEmail("106129@qq.com");
		user.setPassword("123456");
		user.setUsername("djb");
		service.add(user);

	}

}
