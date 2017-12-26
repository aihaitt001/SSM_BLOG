package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.ArticlesMapper;
import springmvc.model.Article;

@Service
public class ArticleServiceImpt implements ArticleService {

	@Autowired
	ArticlesMapper articlemapper;

	public int add(Article article) {
		// TODO Auto-generated method stub
		return articlemapper.add(article);
	}

	public void delete(Integer articleId) {
		// TODO Auto-generated method stub
		articlemapper.delete(articleId);
	}

	public List<Article> list() {
		// TODO Auto-generated method stub
		return articlemapper.list();
	}

	public Article getByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articlemapper.getByArticleId(articleId);
	}

	public void update(Article article) {
		// TODO Auto-generated method stub
		articlemapper.update(article);
	}

}
