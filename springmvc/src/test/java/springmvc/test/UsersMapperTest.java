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
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })

public class UsersMapperTest {
	@Autowired
	private UsersMapper UsersMapper;

	@Test
	public void testAdd() {
		System.out.println("testadd");
		User User = new User();
		User.setAdmin(1);
		User.setUsername("new User");
		User.setPassword("123456");
		UsersMapper.add(User);
	}

	@Test
	public void testDelete() {
		System.out.println("testadelete");
		Integer id = 1;
		UsersMapper.delete(id);
	}

	@Test
	public void testList() {
		System.out.println("testLIST");
		// System.out.println(UsersMapper);
		List<User> cs = UsersMapper.list();
		for (User c : cs) {
			System.out.println(c.getUsername());
		}
	}

	@Test
	public void testGetByUsername() {
		Integer id = 20;
		User user = new User();
		user = UsersMapper.getById(id);
		System.out.println(user);
		System.out.println("testGetByUserame");

	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setUsername("aab");
		user.setAdmin(1);
		user.setEmail("aab@qq.com");
		user.setPassword("aab");
		UsersMapper.update(user);
	}

}
