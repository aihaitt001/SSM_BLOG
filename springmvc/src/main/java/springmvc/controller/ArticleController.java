package springmvc.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import springmvc.model.Article;
import springmvc.model.Message;
import springmvc.model.User;
import springmvc.service.ArticleService;

/*
 * 用户对文章进行管理的请求处理。
 * 
 * */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	ArticleService service;

	/*
	 * 新增文章
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String addarticle(@RequestBody Article article, HttpServletRequest request) throws Exception {
		System.out.println("addarticle");

		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		article.setCreatetime(createtime);
		User user = (User) request.getSession().getAttribute("currentUser");
		article.setAuthor(user.getUsername());
		System.out.println(article);
		service.add(article);
		Message result = new Message();
		result.setCurrentuser(user.getUsername());
		result.setResult("新增成功！" + user.getUsername());
		ObjectMapper map = new ObjectMapper();
		String message = map.writeValueAsString(result);
		return message;

	}

	/*
	 * 文章修改
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public String updatearticleByarticleId(@RequestBody Article article) {
		System.out.println("updatearticle:" + article);
		String result = "修改成功";
		try {
			Date date = new Date();
			Timestamp createtime = new Timestamp(date.getTime());
			article.setCreatetime(createtime);
			service.update(article);
		} catch (Exception e) {
			result = "修改失败" + e.toString();
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
					return "删除 失败";
				}

			}

			// System.out.println(list.get(i).getClass().getName());
		}

		return "删除成功";

	}
}
