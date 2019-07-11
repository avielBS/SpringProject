package springProject.layout;

import java.util.Date;

import springProject.data.UserEntity;


public class UserBoundry {

	private String name;
	private String username;
	private String password;
	private String email;
	private String avatar;
	
	public UserBoundry() {
	}

	public UserBoundry(String name, String username, String password, String email, String avatar) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
	}

	public UserBoundry(UserEntity entity) {
		this.username = entity.getUsername();
		this.avatar = entity.getAvatar();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.name = entity.getName();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "UserBoundry [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", avatar=" + avatar + "]";
	}
	
	public UserEntity convertToEntity() {
		UserEntity entity = new UserEntity();
		
		entity.setAvatar(this.avatar);
		entity.setavailableFrom(new Date());
		entity.setEmail(this.email);
		entity.setName(this.name);
		entity.setPassword(this.password);
		entity.setUsername(this.username);
		
		return entity;
	}
	
	
}
