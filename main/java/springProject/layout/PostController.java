package springProject.layout;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springProject.data.PostEntiy;
import springProject.infra.PostService;

@RestController
public class PostController {

	private PostService postService;

	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping(path = "myapp/myposts/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundry[] getPostsFromUser(@PathVariable("email") String email,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		PostBoundry[] posts = this.postService.getPostsFromUser(email, size, page).stream().map(PostBoundry::new)
				.collect(Collectors.toList()).toArray(new PostBoundry[0]);
		System.out.println(posts);
		return posts;
	}

	@RequestMapping(path = "myapp/posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundry[] getPosts() {
		PostBoundry[] posts = this.postService.getAllPosts().stream().map(PostBoundry::new).collect(Collectors.toList())
				.toArray(new PostBoundry[0]);
		System.out.println(posts);
		return posts;
	}

	@RequestMapping(path = "myapp/newPost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundry createPost(@RequestBody PostBoundry postBoundry) {
		PostEntiy post = null;
		post = this.postService.newPost(postBoundry.convertToEntity());
		System.out.println(post);
		return new PostBoundry(post);
	}

	@RequestMapping(path = "myapp/posts/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundry getPostById(@PathVariable("key") Long key) {
		PostBoundry post = null;
		post = new PostBoundry(postService.getById(key).orElseThrow(() -> new RuntimeException("in serviece")));
		return post;
	}

	@RequestMapping(path = "myapp/delete/post/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletePostById(@PathVariable("key") Long key) {
		this.postService.deleteById(key);
	}

}
