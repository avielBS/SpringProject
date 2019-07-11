package springProject.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USERS")
public class UserEntity {

	private String name;
	private Date availableFrom;
	private String username;
	private String password;
	private String email;
	private String avatar;
	private String id;
	
	public UserEntity() {
	}
	
	public UserEntity(String name, Date date, String username, String password, String email, String avatar) {
		super();
		this.name = name;
		this.availableFrom = date;
		this.username = username;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.id=null;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getavailableFrom() {
		return availableFrom;
	}
	public void setavailableFrom(Date date) {
		this.availableFrom = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Id
	@Column(name="ID")
	public String getId() {
		return this.email;
	}
	public void setId(String email) {
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", date=" + availableFrom + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", avatar=" + avatar + "]";
	}
	
	
}
