package springProject.dao;

import java.util.List;
import java.util.Optional;

import springProject.data.PostEntiy;


public interface PostDao<Key> {

	public PostEntiy create (PostEntiy message);
	public Optional<PostEntiy> readById (Key key);
	public List<PostEntiy> readAll();
	public void update (PostEntiy update);
	public void deleteAll();
	
}
