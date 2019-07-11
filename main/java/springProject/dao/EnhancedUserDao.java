package springProject.dao;

import java.util.Date;
import java.util.List;

import springProject.data.UserEntity;

public interface EnhancedUserDao extends UserDao {
	public List<UserEntity> readAll(int size, int page);

	public List<UserEntity> readAll(String sortBy, int size, int page);

	public List<UserEntity> readMessageWithNameContaining(String text, int size, int page);

	public List<UserEntity> readMessageAvaiable(Date fromDate, Date toDate, int size, int page);

	public void deleteByKey(String email);
}
