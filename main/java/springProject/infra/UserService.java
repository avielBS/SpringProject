package springProject.infra;


import java.util.List;
import java.util.Optional;

import springProject.data.PostEntiy;
import springProject.data.UserEntity;
import springProject.layout.UserBoundry;

public interface UserService {
	public List<UserEntity>  getUsers() ;
	public void update(UserEntity user , String email);
	public Optional<UserEntity> getById(String email);
	public UserEntity newUser(UserEntity newUser);
	
}
