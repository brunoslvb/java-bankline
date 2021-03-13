package repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import database.Database;

public class AbstractRepository <E> {
	
	protected EntityManager em;
	
	protected Class<E> entityClass;
	
	public AbstractRepository() {
		em = Database.connection("BankLineDB");
		
		this.entityClass = (Class<E>)
				   ((ParameterizedType)getClass().getGenericSuperclass())
				      .getActualTypeArguments()[0];
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
	
	public void delete(Object id) {
		
		Object entity = find(id);
		
		if(entity != null) {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();			
		} else {
			System.out.println("Usuário não encontrado");
		}
	}
	
	public E find(Object id) {
		Object entity = em.find(entityClass, id);
		return (E) entity;
	}
	
	public List<E> list(){
		//Ver sobre JPQL + String.format
		String sql = String.format("SELECT e FROM  %s e", entityClass.getName());
		
		Query query =  em.createQuery(sql);
		
		return query.getResultList();
		
	}
	
}
