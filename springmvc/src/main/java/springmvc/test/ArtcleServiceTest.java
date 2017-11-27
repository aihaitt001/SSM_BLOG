package springmvc.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmvc.model.Artcle;
import springmvc.service.ArtcleService;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class ArtcleServiceTest {
	@Autowired
	ArtcleService service;

	@Test
	public void list() {
		System.out.println(service.list());

	}

	@Test
	public void Add() {
		Artcle artcle = new Artcle();
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		artcle.setArtcleId(100);
		artcle.setAuthor("djb");
		artcle.setBody("this sis a test001");
		artcle.setTags("test,artcle,djb");
		artcle.setTitle("test001");
		artcle.setCreateTime(createtime);

	}

	@Test
	public void Update() {
		Artcle artcle = new Artcle();
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		artcle.setArtcleId(100);
		artcle.setAuthor("djb");
		artcle.setBody("this sis a test002");
		artcle.setTags("test002,artcle,djb");
		artcle.setTitle("test002");
		artcle.setCreateTime(createtime);
		service.update(artcle);
	}

	@Test
	public void getByArtcleId() {

		System.out.println(service.getByArtcleId(100));

	}

	@Test
	public void Delete() {
		service.delete(100);
	}

}
