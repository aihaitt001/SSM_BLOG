package springmvc.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmvc.model.Article;
import springmvc.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class ArticleServiceTest {
	@Autowired
	ArticleService service;

	@Test
	public void list() {
		System.out.println(service.list());

	}

	@Test
	public void Add() {
		Article article = new Article();
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		article.setArticleId(100);
		article.setAuthor("djb");
		article.setBody("this sis a test001");
		article.setTags("test,article,djb");
		article.setTitle("test001");
		article.setCreatetime(createtime);

	}

	@Test
	public void Update() {
		Article article = new Article();
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		article.setArticleId(100);
		article.setAuthor("djb");
		article.setBody("this sis a test002");
		article.setTags("test002,article,djb");
		article.setTitle("test002");
		article.setCreatetime(createtime);
		service.update(article);
	}

	@Test
	public void getByArticleId() {

		System.out.println(service.getByArticleId(100));

	}

	// @Test
	// public void Delete() {
	// service.delete(100);
	// }

}
