package springProject.infra;


import springProject.data.UserEntity;
import springProject.layout.UserBoundry;

public interface UserService {
	public UserEntity getUser(UserBoundry user);
}
