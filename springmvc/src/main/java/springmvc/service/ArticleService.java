package springmvc.service;

import java.util.List;

import springmvc.model.Article;

public interface ArticleService {
	public int add(Article article);

	public void delete(Integer articleId);

	public List<Article> list();

	public Article getByArticleId(Integer articleId);

	public void update(Article article);
}
