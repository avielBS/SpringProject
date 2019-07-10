package springProject.dao.rdb;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import springProject.data.PostEntiy;

public interface PostCrud extends 
	PagingAndSortingRepository<PostEntiy, Long>{
	
	public List<PostEntiy> findAllByUserIdLike(
			@Param("pattern") String pattern,
			Pageable pageable);
	
	public List<PostEntiy> findAllBycreationTimeBetween(
			@Param("fromDate") Date fromDate, 
			@Param("toDate") Date toDate, 
			Pageable pageable);	

}
