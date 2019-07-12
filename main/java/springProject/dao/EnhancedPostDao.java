package springProject.dao;

import java.util.Date;
import java.util.List;

import springProject.data.PostEntiy;

public interface EnhancedPostDao<Key> extends PostDao<Key> {
	public List<PostEntiy> readAll(int size, int page);

	public List<PostEntiy> readAll(String sortBy, int size, int page);

	public List<PostEntiy> readPostWithEmailContaining(String text, int size, int page);

	public List<PostEntiy> readMessageAvaiable(Date fromDate, Date toDate, int size, int page);

	public void deleteByKey(Long key);

}
