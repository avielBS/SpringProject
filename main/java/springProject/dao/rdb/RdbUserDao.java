package springProject.dao.rdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springProject.dao.EnhancedUserDao;
import springProject.data.UserEntity;

@Repository
public class RdbUserDao implements EnhancedUserDao{

	private UserCrud userCrud;
	
	public RdbUserDao(UserCrud userCrud) {
		super();
		this.userCrud = userCrud;
	}
	
	@Override
	@Transactional
	public UserEntity create(UserEntity user) {
		if(!this.userCrud.existsById(user.getEmail())) {
		UserEntity rv = this.userCrud.save(user);
		return rv;
		}
		else
			throw new RuntimeException("this user already in DB");
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<UserEntity> readById(String email) {
		return this.userCrud.findById(email);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserEntity> readAll() {
		List<UserEntity> rv = new ArrayList<UserEntity>();
		this.userCrud.findAll().forEach(rv::add);
		return rv;
	}

	@Override
	@Transactional
	public void update(UserEntity update, String email) {

		UserEntity user = readById(email).orElseThrow(() -> new RuntimeException("user not in db"));

		if (update.getAvatar() != null)
			user.setAvatar(update.getAvatar());
		//if update email need to update all his posts userEmail
		//but i use the email to be the key of the user
//		if (update.getEmail() != null)
//			user.setEmail(update.getEmail());
		if (update.getName() != null)
			user.setName(update.getName());
		if (update.getPassword() != null)
			user.setPassword(update.getPassword());
		if (update.getUsername() != null)
			user.setUsername(update.getUsername());
		
		this.userCrud.save(user);
	}

	@Override
	public void deleteAll() {
		this.userCrud.deleteAll();
	}

	@Override
	public List<UserEntity> readAll(int size, int page) {
		return this.userCrud
				.findAll(PageRequest.of(page, size))
				.getContent();
	}

	@Override
	public List<UserEntity> readAll(String sortBy, int size, int page) {
		return this.userCrud
				.findAll(PageRequest.of(
						page, size, 
						Direction.ASC, sortBy))
				.getContent();	}

	@Override
	public List<UserEntity> readMessageWithNameContaining(String text, int size, int page) {
		return this.userCrud
				.findAllByNameLike(
						"%" + text + "%",
						PageRequest.of(page, size));
	}

	@Override
	public List<UserEntity> readMessageAvaiable(Date fromDate, Date toDate, int size, int page) {
		return this.userCrud
				.findAllByAvailableFromBetween(
						fromDate, toDate,
						PageRequest.of(page, size));
	}

	@Override
	public void deleteByKey(String email) {
		this.userCrud.deleteById(email);
	}

}
