package springmvc.model;

import java.sql.Timestamp;

public class Article {
	private Integer articleId;
	private String title;
	private String tags;
	private String body;
	private String author;
	private Timestamp createtime;

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTags() {
		return tags;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	@Override
	public String toString() {
		return "{Article: [ArticleId=" + articleId + ",title=" + title + ",author=" + author + ",tags=" + tags
				+ ",body=" + body + ",createtime=" + createtime + "]}";
	}
}
