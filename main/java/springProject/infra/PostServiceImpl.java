package springProject.infra;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import springProject.data.PostEntiy;
import springProject.data.UserEntity;

@Service
public class PostServiceImpl implements PostService{

	@Override
	public List<PostEntiy> getPosts(UserEntity user) {
		//search in database for all user post
		return  IntStream.range(1, 11).mapToObj(i->new PostEntiy("title"+i,
				"author"+i,
				new UserEntity(),
				new Date(),
				"content"+i)).collect(Collectors.toList());
	}

}
