package springmvc.test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("localhost");
		try {
			System.out.println(jedis.ping());

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			jedis.close();
		}

	}

}
