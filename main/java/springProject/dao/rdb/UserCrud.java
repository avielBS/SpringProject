package springProject.dao.rdb;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import springProject.data.UserEntity;

public interface UserCrud extends
	PagingAndSortingRepository<UserEntity, String>{

	public List<UserEntity> findAllByNameLike(
			@Param("pattern") String pattern, 
			Pageable pageable);

	public List<UserEntity> findAllByAvailableFromBetween(
			@Param("fromDate") Date fromDate, 
			@Param("toDate") Date toDate, 
			Pageable pageable);
	
}
