package springmvc.test;

import java.util.Set;

import redis.clients.jedis.Jedis;
import springmvc.util.StringUtil;
import springmvc.util.ThreadUtil;

public class JedisTest {
	public void testKey(Jedis jedis) throws InterruptedException {
		final String key = "username";
		StringUtil.p("清空数据" + jedis.flushDB());
		StringUtil.p("判断键username是否存在" + jedis.exists("username"));
		StringUtil.p("新增键值对<‘username’，‘djb’>" + jedis.set("username", "djb"));
		StringUtil.p("查看键对应的类型" + jedis.type(key));
		StringUtil.p("查看键username对应的值" + jedis.get("username"));
		StringUtil.p("删除键username" + jedis.del("username"));
		Set<String> keys = jedis.keys("*");
		StringUtil.p("新增键值对<‘username’，‘djb’>" + jedis.set("username", "djb"));
		StringUtil.p("查看所有键" + keys);
		StringUtil.p("查看\"username\"的生存时间" + jedis.ttl("username"));
		StringUtil.p("设置键的生存时间为5，结果：" + jedis.expire(key, 5));
		// Thread.sleep(2000);
		ThreadUtil.sleep(2);
		StringUtil.p("查看\"username\"的生存时间" + jedis.ttl("username"));
		StringUtil.p("判断键username是否存在：" + jedis.exists(key));

	}

	public void testList(Jedis jedis) {
		String key = "operation";
		jedis.flushDB();
		System.out.println("=========添加List========");
		jedis.lpush("operation", "lpush", "lrange", "lrem");
		jedis.lpush("operation", "itrim");
		System.out.println("===========list内容=============");
		System.out.println(jedis.lrange("operation", 0, -1));

		System.out.println("===========list内容从第一个到第三个=============");
		System.out.println(jedis.lrange("operation", 0, 3));
		System.out.println("========删除指定元素=======");
		jedis.lrem(key, 1, "lpush");
		System.out.println(jedis.lrange("operation", 0, -1));

		System.out.println("");
		System.out.println("");
		System.out.println("");

	}

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		JedisTest test = new JedisTest();
		try {
			System.out.println(jedis.ping());
			test.testKey(jedis);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			jedis.close();
		}
	}

}
