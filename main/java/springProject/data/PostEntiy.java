package springProject.data;

import java.util.Date;

public class PostEntiy {

	private String title;
	private String author;
	private UserEntity user;
	private Date creationTime;
	private String content;
	
	public PostEntiy() {
	}

	public PostEntiy(String title, String author, UserEntity user, Date creationTime, String content) {
		this.title = title;
		this.author = author;
		this.user = user;
		this.creationTime = creationTime;
		this.content = content;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostEntiy [title=" + title + ", author=" + author + ", user=" + user + ", creationTime=" + creationTime
				+ ", content=" + content + "]";
	}
	
	
	
	
}
