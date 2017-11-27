package springmvc.model;

import java.sql.Timestamp;

public class Artcle {
	private Integer artcleId;
	private String title;
	private String tags;
	private String body;
	private String author;
	private Timestamp createtime;

	public void setArtcleId(Integer artcleId) {
		this.artcleId = artcleId;
	}

	public Integer getArtcleId() {
		return artcleId;
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

	public void setCreateTime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getCreateTime() {
		return createtime;
	}
}
