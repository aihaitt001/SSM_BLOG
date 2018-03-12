package springmvc.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;

public class ToUtil {

	/*
	 * 对象转化成JSON格式字符串
	 * 
	 */
	public static String objectToJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}

	/*
	 * JSON字符串转成对象
	 */
	public static Object JSONStringToObject(String str) {
		return JSON.parse(str);

	}

	/*
	 * 
	 * javabean对象和map的相互转换，利用org.apache.commons.beanutils
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null) {
			return null;
		}

		Object obj = beanClass.newInstance();

		BeanUtils.populate(obj, map);

		return obj;
	}

	public static Map<?, ?> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}

		return new BeanMap(obj);
	}

}
