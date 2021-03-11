package repository;

import java.util.List;

import model.User;

public class UserRepository extends AbstractRepository<User> implements Repository<User>{
	
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User find(String login) {
		
		User entity = em.find(User.class, login);
		return entity;
		
	}

}
