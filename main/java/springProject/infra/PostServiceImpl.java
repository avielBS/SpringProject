package springProject.infra;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProject.dao.EnhancedPostDao;
import springProject.dao.EnhancedUserDao;
import springProject.data.PostEntiy;
import springProject.data.UserEntity;

@Service
public class PostServiceImpl implements PostService {

	private EnhancedPostDao<Long> postsDao;
	private EnhancedUserDao userDao;

	@Autowired
	public PostServiceImpl(EnhancedPostDao<Long> postsDao, EnhancedUserDao userDao) {
		this.postsDao = postsDao;
		this.userDao = userDao;
	}

	@Override
	public List<PostEntiy> getPostsFromUser(String userEmail, int size, int page) {
		// search in database for all user post
		return this.postsDao.readPostWithEmailContaining(userEmail, size, page);
	}

	@Override
	public List<PostEntiy> getAllPosts() {
		return this.postsDao.readAll();
	}

	@Override
	public void update(PostEntiy post) {
		this.postsDao.update(post);
	}

	@Override
	public Optional<PostEntiy> getById(Long key) {
		return this.postsDao.readById(key);
	}

	@Override
	public PostEntiy newPost(PostEntiy post) {

		UserEntity user = this.userDao.readById(post.getUserId())
				.orElseThrow(() -> new RuntimeException("this post not belong to users"));
		if (user != null) {
			post.setCreationTime(new Date());
			return this.postsDao.create(post);
		} else
			throw new RuntimeException("this post not belong to users");
	}

	@Override
	public void deleteById(Long key) {
		this.postsDao.deleteByKey(key);
	}

}
