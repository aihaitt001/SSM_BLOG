package springmvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmvc.model.User;
import springmvc.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath*:/applicationContext.xml"})
public class UsersServiceTest {
    @Autowired
    UserService  service;
	@Test
	public void list(){
		 System.out.println(service.list());
		
	}
	@Test
	public void Delete() {
		service.Delete("董经博");
	}
	@Test
	public void Add() {
		User user = new User();
		
		user.setAdmin(1);
		user.setEmail("106129@qq.com");
		user.setPassword("ovo");
		user.setUsername("董静波");
		service.Add(user);
		
	}
	@Test
	public void Update() {
		int id = service.getByUsername("董静波").getId();
		System.out.println(id);
		service.Update(id, "董经博");
	}
	@Test
	public void getByUsername() {
		
		System.out.println(service.getByUsername("董经博")); 
		
	}
	
	
	

}
