package springProject.layout;


import java.util.Date;

import springProject.data.PostEntiy;
import springProject.data.UserEntity;

public class PostBoundry {

	private String title;
	private String author;
	private UserBoundry user;
	private String content;
	private Long id;
	
	public PostBoundry() {
	}

	public PostBoundry(String title, String author, UserBoundry user, String content) {
		this.title = title;
		this.author = author;
		this.user = user;
		this.content = content;
		this.id=null;
	}
	
	public PostBoundry(PostEntiy postEntiy) {
		this.title = postEntiy.getTitle();
		this.author = postEntiy.getAuthor();
		this.user = new UserBoundry(postEntiy.getUser());
		this.content = postEntiy.getContent();
		this.id = postEntiy.getKey();
	}
	
	public PostEntiy convertToEntity() {
		PostEntiy entity = new PostEntiy();
		
		entity.setAuthor(this.author);
		entity.setCreationTime(new Date());
		entity.setContent(this.content);
		entity.setTitle(this.title);
		entity.setUser(this.user.convertToEntity());
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

	public UserBoundry getUser() {
		return user;
	}

	public void setUser(UserBoundry user) {
		this.user = user;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostEntiy [title=" + title + ", author=" + author + ", user=" + user + 
				 ", content=" + content + "]";
	}
	
}
