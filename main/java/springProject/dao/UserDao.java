package springProject.dao;

import java.util.List;
import java.util.Optional;

import springProject.data.UserEntity;

public interface UserDao {

	public UserEntity create(UserEntity user);

	public Optional<UserEntity> readById(String email);

	public List<UserEntity> readAll();

	public void update(UserEntity update , String email);

	public void deleteAll();

	
}
