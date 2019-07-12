package springProject.layout;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springProject.data.UserEntity;
import springProject.infra.UserService;
import springProject.infra.userServiceImpl;

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "myapp/users", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserBoundry[] newUser() {
		UserBoundry[] users = this.userService.getUsers().stream().map(UserBoundry::new).collect(Collectors.toList())
				.toArray(new UserBoundry[0]);
		return users;
	}

	@RequestMapping(path = "myapp/newuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserBoundry createUser(@RequestBody UserBoundry newUser) {
		UserBoundry user = new UserBoundry(this.userService.newUser(newUser.convertToEntity()));
		return user;
	}

	@RequestMapping(path = "myapp/update/{email}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@PathVariable("email") String email, @RequestBody UserBoundry user) {
		this.userService.update(user.convertToEntity(), email);
	}

	@RequestMapping(path = "myapp/delete/user/{email}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable("email") String email) {
		this.userService.delete(email);
	}

}
