package springProject.infra;

import java.util.List;
import java.util.Optional;


import springProject.data.PostEntiy;
import springProject.data.UserEntity;

public interface PostService {
	public List<PostEntiy>  getPostsFromUser(UserEntity user,int size,int page) ;
	public List<PostEntiy>  getAllPosts();
	public void update(PostEntiy post);
	public Optional<PostEntiy> getById(Long key);
	public PostEntiy newPost(PostEntiy post);
}
