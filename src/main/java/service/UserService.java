package service;

import java.util.List;

import exception.ExceedMaxLengthException;
import exception.InvalidCpfException;
import exception.MinLengthNotReachedException;
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
			throw new ExceedMaxLengthException("N�mero de caracteres excedido no campo login");
		}
		
		if(!Validators.hasMinLenght(user.getPassword(), 5)) {
			throw new MinLengthNotReachedException("A senha n�o possui a quantidade m�nima de caracteres");
		}
		
		if(!Validators.cpfIsValid(user.getCpf())) {
			throw new InvalidCpfException("CPF Inv�lido");
		}
		
		userRepository.save(user);
		
		System.out.println("Usu�rio e conta criada com sucesso");
		
	}
	
	public void updateUser(User user) {
		
		if(Validators.isExceedMaxLength(user.getLogin(), 20)) {
			throw new ExceedMaxLengthException("N�mero de caracteres excedido no campo login");
		}
		
		if(!Validators.hasMinLenght(user.getPassword(), 5)) {
			throw new MinLengthNotReachedException("A senha n�o possui a quantidade m�nima de caracteres");
		}
				
		userRepository.update(user);
		
		System.out.println("Usu�rio atualizado com sucesso");
		
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
