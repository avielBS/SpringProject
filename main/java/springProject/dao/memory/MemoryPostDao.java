package springProject.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import springProject.dao.EnhancedPostDao;
import springProject.data.PostEntiy;

// @Repository
public class MemoryPostDao implements EnhancedPostDao<Long> {

	private List<PostEntiy> posts;
	private AtomicLong nextId;

	public MemoryPostDao() {
		this.posts = Collections.synchronizedList(new ArrayList<>());
		this.nextId = new AtomicLong(1);
	}

	protected List<PostEntiy> getPosts() {
		return this.posts;
	}

	@Override
	public PostEntiy create(PostEntiy post) {
		post.setKey(this.nextId.getAndIncrement());
		this.posts.add(post);
		return post;
	}

	@Override
	public Optional<PostEntiy> readById(Long key) {
		PostEntiy target = null;

		for (PostEntiy current : this.posts) {
			if (current.getKey().equals(key))
				target = current;
		}

		if (target != null)
			return Optional.of(target);
		else
			return Optional.empty();
	}

	@Override
	public List<PostEntiy> readAll() {
		return this.posts;
	}

	@Override
	public void update(PostEntiy update) {

		synchronized (this.posts) {

			PostEntiy exist = this.readById(update.getKey())
					.orElseThrow(() -> new RuntimeException("no post to update"));

			if (update.getAuthor() != null)
				exist.setAuthor(update.getAuthor());
			if (update.getContent() != null)
				exist.setContent(update.getContent());
			if (update.getTitle() != null)
				exist.setTitle(update.getTitle());

		}

	}

	@Override
	public void deleteAll() {
		this.posts.clear();
	}

	@Override
	public List<PostEntiy> readAll(int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostEntiy> readAll(String sortBy, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostEntiy> readPostWithEmailContaining(String text, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostEntiy> readMessageAvaiable(Date fromDate, Date toDate, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub

	}

}
