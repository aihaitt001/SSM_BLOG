package springmvc.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmvc.dao.RedisDao;
import springmvc.model.User;
import springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class RedisTest {
	@Autowired
	RedisDao redisdao;
	@Autowired
	UserService service;

	@Test
	public void testRedisdao() {
		try {
			System.out.println(redisdao.ping());
			List<User> list = service.list();

			for (User user : list) {
				HashMap<String, String> map = new HashMap<String, String>(10);
				map.put("username", user.getUsername());
			}
			System.out.println(redisdao.set("website", "www.lifeforfun.cn"));
			System.out.println(redisdao.get("website"));

		} catch (Exception e) {
			System.out.println(e);
		}

		// System.out.println(redisdao.hmset("users_map", map));

	}

}
