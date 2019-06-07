package springProject.infra;

import org.springframework.stereotype.Service;

import springProject.data.UserEntity;
import springProject.layout.UserBoundry;

@Service
public class userServiceImpl implements UserService {


	@Override
	public UserEntity getUser(UserBoundry user) {
		return user.convertToEntity();
	}

}
