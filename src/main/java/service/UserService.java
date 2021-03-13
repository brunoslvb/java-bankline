package service;

import java.util.List;

import model.Account;
import model.StatusAccount;
import model.User;
import repository.AccountRepository;
import repository.UserRepository;
import utils.Validators;

public class UserService {

	private UserRepository userRepository = new UserRepository();
	private AccountRepository accountRepository = new AccountRepository();
	
	public void createUser(User user) {
		
		if(Validators.isExceedMaxLength(user.getLogin(), 20)) {
			System.out.println("Exception login excedido");
			return;
		}
		
		if(!Validators.hasMinLenght(user.getPassword(), 5)) {
			System.out.println("Exception senha não tem o mínimo de caracteres");
			return;
		}
		
		if(!Validators.cpfIsValid(user.getCpf())) {
			System.out.println("Exception cpf não é válido");
			return;
		}
		
		Account account = new Account();
		account.setUser(user);
				
		accountRepository.save(account);
		
		System.out.println("Usuário e conta criada com sucesso");
		
	}
	
	public void updateUser(User user) {
		
		if(Validators.isExceedMaxLength(user.getLogin(), 20)) {
			System.out.println("Exception login excedido");
			return;
		}
		
		if(!Validators.hasMinLenght(user.getPassword(), 5)) {
			System.out.println("Exception senha não tem o mínimo de caracteres");
			return;
		}
				
		userRepository.update(user);
		
		System.out.println("Usuário atualizado com sucesso");
		
	}
	
	public void deleteUser(User user) {
		
		Account account = accountRepository.findByCpf(user);
		
		user.setStatus(StatusAccount.DISABLE);
		account.setStatus(StatusAccount.DISABLE);
		
		accountRepository.delete(account);
		userRepository.delete(user);
		
	}
	
	public List<User> ListUsers() {
		
		UserRepository userRepository = new UserRepository();
		
		return userRepository.list();
		
	}
	
	public User findById(Object id) {
		
		UserRepository userRepository = new UserRepository();
		
		return userRepository.find(id);
		
	}
	
}
