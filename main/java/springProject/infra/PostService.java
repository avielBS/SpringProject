package springProject.infra;

import java.util.List;

import springProject.data.PostEntiy;
import springProject.data.UserEntity;

public interface PostService {
	public List<PostEntiy>  getPosts(UserEntity user) ;
}
