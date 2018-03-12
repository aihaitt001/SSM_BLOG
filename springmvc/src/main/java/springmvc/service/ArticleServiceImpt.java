package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import springmvc.mapper.ArticlesMapper;
import springmvc.model.Article;

@Service
public class ArticleServiceImpt implements ArticleService {

	@Autowired
	ArticlesMapper articlemapper;

	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		return articlemapper.add(article);
	}

	@Override
	public void delete(Integer articleId) {
		// TODO Auto-generated method stub
		articlemapper.delete(articleId);
	}

	@Override
	public List<Article> list() {
		// TODO Auto-generated method stub
		System.out.println(articlemapper);
		return articlemapper.list();
	}

	@Override
	public Article getByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articlemapper.getByArticleId(articleId);
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articlemapper.update(article);
	}

	@Override
	public List<Article> listByAuthor(String author) {
		// TODO Auto-generated method stub
		return articlemapper.listByAuthor(author);
	}

	@Override
	public List<Article> listArticleByPage(String username, int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		// 分页查询
		PageHelper.startPage(pagenum, pagesize);
		return articlemapper.listByAuthor(username);
	}

	@Override
	public Integer flushDB() {
		return articlemapper.flushDB();

	}

}
