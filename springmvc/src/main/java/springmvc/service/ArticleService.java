package springmvc.service;

import java.util.List;

import springmvc.model.Article;

public interface ArticleService {
	public int add(Article article);

	public Integer flushDB();

	public void delete(Integer articleId);

	public List<Article> list();

	public List<Article> listByAuthor(String author);

	public Article getByArticleId(Integer articleId);

	public void update(Article article);

	public List<Article> listArticleByPage(String username, int pagenum, int pagesize);
}
