package unit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.UserController;
import exception.ExceedMaxLengthException;
import exception.InvalidCpfException;
import exception.MinLengthNotReachedException;
import model.User;

public class UserTest {

	UserController userController = new UserController();

	void BeforeAll() {
		
	}
	
	@Test
	@DisplayName("Deve retornar uma exceção do tipo ExceedMaxLengthException na tentativa de criação de um usuário com login maior que 20 caracteres")
	public void testCreateUserWithInvalidLogin() {
		
		User user = new User();
		
		user.setName("Bruno");
		user.setCpf("44444444444");
		user.setLogin("bruno_da_silva_barros");
		user.setPassword("123456");
		
		assertThrows(ExceedMaxLengthException.class, () -> {
			userController.save(user);	
		});
		
	}
	
	@Test
	@DisplayName("Deve retornar uma exceção do tipo InvalidCpfException na tentativa de criação de um usuário com cpf inválido")
	public void testCreateUserWithInvalidCpf() {
		
		User user = new User();
		
		user.setName("Bruno");
		user.setCpf("44444444443");
		user.setLogin("bruno");
		user.setPassword("123456");
		
		assertThrows(InvalidCpfException.class, () -> {
			userController.save(user);	
		});
		
	}
	
	@Test
	@DisplayName("Deve retornar uma exceção do tipo MinLengthNotReachedException na tentativa de criação de um usuário com senha inferior a 5 caracteres")
	public void testCreateUserWithInvalidPassword() {
		
		User user = new User();
		
		user.setName("Bruno");
		user.setCpf("44444444443");
		user.setLogin("bruno");
		user.setPassword("1234");
		
		assertThrows(MinLengthNotReachedException.class, () -> {
			userController.save(user);	
		});
		
	}
	
}
