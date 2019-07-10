package springProject.dao.rdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springProject.dao.EnhancedPostDao;
import springProject.data.PostEntiy;

@Repository
public class RdbPostDao implements EnhancedPostDao<Long> {

	private PostCrud postCrud;
	private GenericIdGeneratorCrud genericIdGeneratorCrud;

	@Autowired
	public RdbPostDao(PostCrud postCrud, GenericIdGeneratorCrud genericIdGeneratorCrud) {
		super();
		this.postCrud = postCrud;
		this.genericIdGeneratorCrud = genericIdGeneratorCrud;
	}

	@Override
	@Transactional
	public PostEntiy create(PostEntiy post) {

		GenericIdGenerator nextId = this.genericIdGeneratorCrud.save(new GenericIdGenerator());
		post.setKey(nextId.getId());
		this.genericIdGeneratorCrud.delete(nextId);

		if (!this.postCrud.existsById(post.getKey())) {
			PostEntiy rv = this.postCrud.save(post);
			return rv;
		} else
			throw new RuntimeException("post is already exists with key: " + post.getKey());

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PostEntiy> readById(Long key) {
		return this.postCrud.findById(key);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostEntiy> readAll() {
		List<PostEntiy> rv = new ArrayList<>();
		this.postCrud.findAll().forEach(rv::add);

		return rv;
	}

	@Override
	@Transactional
	public void update(PostEntiy update) {

		PostEntiy exist = this.readById(update.getKey()).orElseThrow(() -> new RuntimeException("no post to update"));

		if (update.getAuthor() != null)
			exist.setAuthor(update.getAuthor());
		if (update.getContent() != null)
			exist.setContent(update.getContent());
		if (update.getTitle() != null)
			exist.setTitle(update.getTitle());

		this.postCrud.save(exist);

	}

	@Override
	@Transactional
	public void deleteAll() {
		this.postCrud.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostEntiy> readAll(int size, int page) {
		return this.postCrud.findAll(PageRequest.of(page, size)).getContent();
	}



	@Override
	public List<PostEntiy> readMessageWithNameContaining(String text, int size, int page) {
		return null;
		}

	@Override
	public List<PostEntiy> readMessageAvaiable(Date fromDate, Date toDate, int size, int page) {
		return null;
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		this.postCrud.deleteById(key);
	}

	@Override
	public List<PostEntiy> readAll(String sortBy, int size, int page) {
		return this.postCrud
				.findAll(PageRequest.of(
						page, size, 
						Direction.ASC, sortBy))
				.getContent();
	}

}
