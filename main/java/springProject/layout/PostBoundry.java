package springProject.layout;

import java.util.Date;

import springProject.data.PostEntiy;

public class PostBoundry {

	private String title;
	private String author;
	private String userId;
	private String content;
	private Long id;

	public PostBoundry() {
	}

	public PostBoundry(String title, String author, String userId, String content) {
		this.title = title;
		this.author = author;
		this.userId = userId;
		this.content = content;
		this.id = null;
	}

	public PostBoundry(PostEntiy postEntiy) {
		this.title = postEntiy.getTitle();
		this.author = postEntiy.getAuthor();
		this.userId = postEntiy.getUserId();
		this.content = postEntiy.getContent();
		this.id = postEntiy.getKey();
	}

	public PostEntiy convertToEntity() {
		PostEntiy entity = new PostEntiy();

		entity.setAuthor(this.author);
		entity.setCreationTime(new Date());
		entity.setContent(this.content);
		entity.setTitle(this.title);
		entity.setUserId(this.userId);
		entity.setKey(this.id);

		return entity;
	}

	public String getTitle() {
		return title;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUserId() {
		return userId;
	}

	public void setUser(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostEntiy [title=" + title + ", author=" + author + ", user=" + userId + ", content=" + content + "]";
	}

}
