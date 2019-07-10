package springProject.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springProject.dao.EnhancedPostDao;
import springProject.dao.EnhancedUserDao;
import springProject.dao.UserDao;
import springProject.data.UserEntity;

@Repository
public class MemoryUserDao implements EnhancedUserDao{

	private List<UserEntity> users;

	public MemoryUserDao() {
		this.users = Collections.synchronizedList(new ArrayList<>());
	}

	@Override
	public UserEntity create(UserEntity user) {
		this.users.add(user);
		return user;
	}

	@Override
	public Optional<UserEntity> readById(String email) {

		UserEntity target = null;

		for (UserEntity current : this.users) {
			if (current.getEmail().equals(email))
				target = current;
		}

		if (target != null)
			return Optional.of(target);
		else
			return Optional.empty();
	}

	@Override
	public List<UserEntity> readAll() {
		return this.users;
	}

	@Override
	public void update(UserEntity update , String email) {
		synchronized (users) {
			UserEntity user = readById(email).orElseThrow(() -> new RuntimeException("user not in db"));

			if (update.getAvatar() != null)
				user.setAvatar(update.getAvatar());
			// need to update all his posts
			if (update.getEmail() != null)
				user.setEmail(update.getEmail());
			if (update.getName() != null)
				user.setName(update.getName());
			if (update.getPassword() != null)
				user.setPassword(update.getPassword());
			if (update.getUsername() != null)
				user.setUsername(update.getUsername());

		}
	}

	@Override
	public void deleteAll() {
		this.users.clear();
	}

	@Override
	public List<UserEntity> readAll(int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> readAll(String sortBy, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> readMessageWithNameContaining(String text, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> readMessageAvaiable(Date fromDate, Date toDate, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub
		
	}

}
