package springmvc.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import springmvc.model.Article;
import springmvc.model.MyMessage;
import springmvc.service.ArticleService;

/*
 * 用户对文章进行管理的请求处理。
 * 
 * */
@Controller
@RequestMapping("/article")
public class ArticleController {

	Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	ArticleService service;

	/*
	 * 新增文章
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String addarticle(@RequestBody Article article) throws Exception {
		System.out.println("addarticle");
		String message = "success";
		try {
			Date date = new Date();
			Timestamp createtime = new Timestamp(date.getTime());
			article.setCreatetime(createtime);
			String username = (String) SecurityUtils.getSubject().getPrincipal();
			// User user = (User) request.getSession().getAttribute("currentUser");
			article.setAuthor(username);
			System.out.println(article);
			service.add(article);
			MyMessage result = new MyMessage();
			result.setCurrentuser(username);
			result.setResult("success！" + username);
			ObjectMapper map = new ObjectMapper();
			message = map.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务器问题：" + e.toString());
			message = "服务器问题：" + e.toString();
		}

		return message;

	}

	/*
	 * 文章修改
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public String updatearticleByarticleId(@RequestBody Article article) {
		System.out.println("updatearticle:" + article);
		String result = "success!";
		try {
			if (article.getAuthor() == null || article.getAuthor() == "") {
				String username = (String) SecurityUtils.getSubject().getPrincipal();

				article.setAuthor(username);
			}
			Date date = new Date();
			Timestamp createtime = new Timestamp(date.getTime());
			article.setCreatetime(createtime);
			service.update(article);
		} catch (Exception e) {
			logger.error("服务器问题：" + e.toString());
			result = "error" + e.toString();
		}

		return result;
	}

	/*
	 * 删除文章
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE)
	public String deletearticleByarticleId(@RequestBody String articleids) throws IOException {
		//
		// String[] idlist = ids.split(",");
		// for (String id : idlist) {
		// service.delete(Integer.valueOf(id));
		// System.out.println("deletearticleByarticleId:" + id);
		// }
		ObjectMapper mapper = new ObjectMapper(); // 转换器

		Map m = mapper.readValue(articleids, Map.class);
		ArrayList<Object> list = new ArrayList<Object>();
		for (Object obj : m.keySet()) {
			System.out.println("key为：" + obj + "值为：" + m.get(obj).getClass().getName());
			list = (ArrayList<Object>) m.get(obj);

		}
		for (int i = 0; i < list.size(); i++) {

			LinkedHashMap hashmap = (LinkedHashMap) list.get(i);
			for (Object obj : hashmap.keySet()) {
				System.out.println(obj + " = " + hashmap.get(obj));

				try {
					service.delete(Integer.valueOf((String) hashmap.get(obj)));
				} catch (Exception e) {
					return "error:" + e.toString();
				}

			}

			// System.out.println(list.get(i).getClass().getName());
		}

		return "success!";

	}
}
