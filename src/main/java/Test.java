import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.exception.ConstraintViolationException;

import model.User;
import repository.UserRepository;

public class Test {

	public static void main(String[] args) {
		
		UserRepository repository = new UserRepository();
		
		User user = new User();
		
		user.setName("Bruno da Silva Barros 2");
		user.setCpf(1234567890);
		user.setLogin("bruno");
		user.setPassword("123456");
		
		// repository.save(user);
		
		// repository.update(user);
		
		User userFound = repository.find("teste");
		
		repository.delete(userFound);
		
		// System.out.println("Teste: "+userFound.getName());
			
	}
	
}
