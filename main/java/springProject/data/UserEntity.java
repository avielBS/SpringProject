package springProject.data;

import java.util.Date;


public class UserEntity {

	private String name;
	private Date date;
	private String username;
	private String password;
	private String email;
	private String avatar;
	
	public UserEntity() {
	}
	
	public UserEntity(String name, Date date, String username, String password, String email, String avatar) {
		super();
		this.name = name;
		this.date = date;
		this.username = username;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", date=" + date + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", avatar=" + avatar + "]";
	}
	
	
}
