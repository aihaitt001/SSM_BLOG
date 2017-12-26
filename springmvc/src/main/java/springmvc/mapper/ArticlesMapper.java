package springmvc.mapper;

import java.util.List;

import springmvc.model.Article;

public interface ArticlesMapper {

	public int add(Article article);

	public void delete(Integer articleId);

	public List<Article> list();

	public Article getByArticleId(Integer articleId);

	public void update(Article article);
}
