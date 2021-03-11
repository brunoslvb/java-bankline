package repository;

import javax.persistence.EntityManager;

import database.Database;

public class AbstractRepository <E> {
	
	protected EntityManager em;
	
	public AbstractRepository() {
		em = Database.connection("BankLineDB");
	}
	
	public void save(E e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void update(E e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void delete(E e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();			
	}
	

}
