package springmvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository("redisDao")
public class RedisDaoImp implements RedisDao {

	Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	private JedisPool jedisPool;

	// private Jedis jedis = jedisPool.getResource();
	// 采用这种写法，会在spring加载RedisDao时，JedisPOOL还没有加载，导致JedisPool为null,从而发生nullofexception
	/*
	 * 清楚当前数据库中的数据 flushAll()清空所有数据库的所有数据
	 * 
	 * @return 清除结果
	 */
	@Override
	public String ping() {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			jedis.ping();
			result = "true";
		} catch (Exception e) {
			logger.error("ping jedis error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String flushDB() {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			jedis.flushDB();
			result = "true";
		} catch (Exception e) {
			logger.error("flushDB error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	/*
	 * 获得key对应的对象
	 * 
	 * @return 不成功，为null
	 */

	@Override
	public String get(String key) {

		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			result = jedis.get(key);
		} catch (Exception e) {
			logger.error("jedis get(key) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	/*
	 * 设置key对应的字符串
	 * 
	 * @return 如果成功：返回true
	 */
	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			jedis.set(key, value);
			result = "true";
		} catch (Exception e) {
			logger.error("jedis set(key,value) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			result = jedis.hget(hkey, key);

		} catch (Exception e) {
			logger.error("jedis hget(hkey,key) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;

	}

	@Override
	public String hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			jedis.hset(hkey, key, value);
			result = "true";
		} catch (Exception e) {
			logger.error("jedis hset(hkey,key,value) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public Map<String, String> hgetAll(String hkey) {
		Jedis jedis = jedisPool.getResource();
		Map<String, String> result = null;
		try {
			result = jedis.hgetAll(hkey);

		} catch (Exception e) {
			logger.error("jedis hget(hkey,key) error" + e);

		} finally {
			jedis.close();
		}
		return result;

	}

	@Override
	public String hmset(String hkey, Map<String, String> map) {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			jedis.hmset(hkey, map);
			result = "true";
		} catch (Exception e) {
			logger.error("jedis hset(hkey,key,value) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String lpush(String key, String val) {

		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			jedis.lpush(key, val);
			result = "true";
		} catch (Exception e) {
			logger.error("jedis hset(hkey,key,value) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String rpop(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			result = jedis.rpop(key);

		} catch (Exception e) {
			logger.error("jedis rpop(key) error" + e);
			result = e.toString();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public List<String> lrange(String key, int start, int end) {
		Jedis jedis = jedisPool.getResource();
		List<String> result = null;
		try {
			result = jedis.lrange(key, start, end);

		} catch (Exception e) {
			logger.error("jedis lrange(key,start,end) error" + e);

		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public Long llen(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = null;
		try {
			result = jedis.llen(key);

		} catch (Exception e) {
			logger.error("jedis lrange(key,start,end) error" + e);

		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();
		boolean result = false;
		try {
			result = jedis.exists(key);

		} catch (Exception e) {
			logger.error("jedis exists(key) error" + e);

		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public String lpush(String key, List<String> list) {
		Jedis jedis = jedisPool.getResource();
		String result = "false";
		try {
			for (String id : list) {
				jedisPool.getResource().lpush(key, id);
			}
			result = "true";

		} catch (Exception e) {
			logger.error("jedis lpush(list) error" + e);

		} finally {
			jedis.close();
		}
		return result;

	}

}
