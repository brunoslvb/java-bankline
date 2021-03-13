package repository;

import java.util.List;

import javax.persistence.Query;

import model.Account;
import model.StatusAccount;
import model.User;
import utils.Validators;

public class UserRepository extends AbstractRepository<User> implements Repository<User>{

	public void save(User user) {
		
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
		
		AccountRepository accountRepository = new AccountRepository();
		
		accountRepository.save(account);
		
		System.out.println("Usuário e conta criada com sucesso");
		
	}
	
	public void update(User user) {
		
		if(Validators.isExceedMaxLength(user.getLogin(), 20)) {
			System.out.println("Exception login excedido");
			return;
		}
		
		if(Validators.hasMinLenght(user.getPassword(), 5)) {
			System.out.println("Exception senha não tem o mínimo de caracteres");
			return;
		}
		
		super.update(user);
		
		System.out.println("Usuário atualizado com sucesso");
		
	}
	
	public void delete(User user) {
		
		super.update(user);
		
	}
	
	public List<User> list(){

		String sql = String.format("SELECT e FROM  %s e WHERE status = :status", entityClass.getName());
		
		Query query =  em.createQuery(sql);
		
		query.setParameter("status", StatusAccount.ENABLE);
		
		return query.getResultList();
		
	}
	
}
