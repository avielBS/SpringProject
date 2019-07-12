package springProject.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "POSTS")
public class PostEntiy implements SpringDataUtil<Long> {

	private String title;
	private String author;
	private String userId;
	private Date creationTime;
	private String content;
	private Long id;

	public PostEntiy() {
	}

	public PostEntiy(String title, String author, String userId, Date creationTime, String content) {
		this.title = title;
		this.author = author;
		this.userId = userId;
		this.creationTime = creationTime;
		this.content = content;
	}

	@Override
	@Id
	@Column(name = "ID")
	public Long getKey() {
		return this.id;
	}

	@Override
	public void setKey(Long key) {
		this.id = key;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
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
		return "PostEntiy [title=" + title + ", author=" + author + ", userId=" + userId + ", creationTime="
				+ creationTime + ", content=" + content + "]";
	}

}
