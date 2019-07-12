package springProject.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProject.dao.EnhancedUserDao;
import springProject.data.UserEntity;


@Service
public class userServiceImpl implements UserService {

	private EnhancedUserDao userDao;

	@Autowired
	public userServiceImpl(EnhancedUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<UserEntity> getUsers() {
		return this.userDao.readAll();
	}

	@Override
	public void update(UserEntity user ,String email) {
		this.userDao.update(user, email);
	}

	@Override
	public Optional<UserEntity> getById(String email) {
		return this.userDao.readById(email);
	}

	@Override
	public UserEntity newUser(UserEntity newUser) {
		return this.userDao.create(newUser);
	}
	@Override
	public void delete(String email) {
		this.userDao.deleteByKey(email);
	}

}
