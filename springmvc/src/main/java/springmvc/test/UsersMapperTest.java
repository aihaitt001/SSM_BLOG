package springmvc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmvc.mapper.UsersMapper;
import springmvc.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml"})

public class UsersMapperTest {
	  @Autowired
	    private UsersMapper UsersMapper;
	

	@Test
	public void testAdd() {
		System.out.println("testadd");
		 User User = new User();
	        User.setUsername("new User");	   
	        User.setPassword("123456");
	        UsersMapper.add(User);
	}

	@Test
	public void testDelete() {
		System.out.println("testadelete");
		String username ="董经博 ";
	     UsersMapper.delete(username);
	}

	@Test
	public void testList() {
		System.out.println("testlIST");
		// System.out.println(UsersMapper);
	        List<User> cs=UsersMapper.list();
	        for (User c : cs) {
	            System.out.println(c.getUsername());
	        }
	}

	@Test
	public void testGetByUsername() {
		String str = "djb";
		User user = new User();
		user = UsersMapper.getByUsername(str);
		 System.out.println("testGetByUserame");
		
	}

	@Test
	public void testUpdate() {
		
		UsersMapper.update(1,"董经博");
	}

}
