package springmvc.dao;

import java.util.List;
import java.util.Map;

public interface RedisDao {

	String get(String key);

	String set(String key, String value);

	String hget(String hkey, String key);

	String hset(String hkey, String key, String value);

	Map<String, String> hgetAll(String hkey);

	String hmset(String key, Map<String, String> map);

	String flushDB();

	String lpush(String key, String user);

	String ping();

	String rpop(String key);

	List<String> lrange(String key, int start, int end);

	Long llen(String key);

	boolean exists(String key);

	String lpush(String key, List<String> list);

}
