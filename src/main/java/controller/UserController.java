package controller;

import java.util.List;

import model.User;
import service.UserService;

public class UserController {

	private UserService service = new UserService();
	
	public void save(User user) {
		
		service.createUser(user);
		
	}
	
	public void update(User user) {
		
		service.updateUser(user);
		
	}
	
	public void delete(User user) {
		
		service.deleteUser(user);
		
	}
	
	public User find(Object id) {
		
		return service.findById(id);
		
	}

	public List<User> listAll() {
	
		return service.ListUsers();
	
	}
	
}
