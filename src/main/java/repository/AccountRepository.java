package repository;

import javax.persistence.Query;

import model.Account;

public class AccountRepository extends AbstractRepository<Account> implements Repository<Account> {

	public Account findByCpf(Object id) {
		
		String sql = String.format("SELECT e FROM %s e WHERE e.user = :cpf", entityClass.getName());
		
		Query query =  em.createQuery(sql);
		
		query.setParameter("cpf", id);
		
		return (Account) query.getSingleResult();
				
	}
	
	public Account findById(Account id) {
		String sql = String.format("SELECT e FROM %s e WHERE e.number = :number", entityClass.getName());
		
		Query query =  em.createQuery(sql);
		
		query.setParameter("number", id.getNumber());
		
		return (Account) query.getSingleResult();
	}
	
	public void delete(Account account) {

		super.update(account);
		
	}
	
}
