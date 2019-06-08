package springProject.layout;


import java.util.Date;

import springProject.data.PostEntiy;
import springProject.data.UserEntity;

public class PostBoundry {

	private String title;
	private String author;
	private UserEntity user;
	private String content;
	
	public PostBoundry() {
	}

	public PostBoundry(String title, String author, UserEntity user, String content) {
		this.title = title;
		this.author = author;
		this.user = user;
		this.content = content;
	}
	
	public PostBoundry(PostEntiy postEntiy) {
		this.title = postEntiy.getTitle();
		this.author = postEntiy.getAuthor();
		this.user = postEntiy.getUser();
		this.content = postEntiy.getContent();
	}
	
	public PostEntiy convertToEntity() {
		PostEntiy entity = new PostEntiy();
		
		entity.setAuthor(this.author);
		entity.setCreationTime(new Date());
		entity.setContent(this.content);
		entity.setTitle(this.title);
		entity.setUser(this.user);
		
		return entity;
	}

	public String getTitle() {
		return title;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
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
