package repository;

import java.util.List;

import javax.persistence.Query;

import model.Account;
import model.StatusAccount;
import model.User;
import utils.Validators;

public class UserRepository extends AbstractRepository<User> implements Repository<User>{

	public void save(User user) {
				
		Account account = new Account();
		
		account.setUser(user);
		
		AccountRepository accountRepository = new AccountRepository();
		
		accountRepository.save(account);
		
		System.out.println("Usuário e conta criada com sucesso");
		
	}
	
	public void update(User user) {
		
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
