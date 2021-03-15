package repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Account;
import model.PlanAccount;
import model.Transaction;

public class TransactionRepository extends AbstractRepository<Transaction> implements Repository<Transaction> {

	public List<Transaction> getRevenues(Account account){
		
		// String sql = String.format("SELECT e.id, e.detail, e.date, e.type, e.originAccount, e.destinyAccount, e.amount FROM %s e", entityClass.getName());
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> criteriaQuery = cb.createQuery(Transaction.class);
		Root<Transaction> root = criteriaQuery.from(Transaction.class);
		
		criteriaQuery.multiselect(root.get("id"), root.get("originAccount"), root.get("destinyAccount"), root.get("type"), root.get("date"), root.get("amount"), root.get("detail"));
		
		criteriaQuery.where(
			cb.or(
				cb.and(
					cb.equal(root.get("originAccount"), account),
					cb.equal(root.get("type"), PlanAccount.REVENUE)
				),
				
				cb.and(
					cb.equal(root.get("destinyAccount"), account),
					cb.equal(root.get("type"), PlanAccount.TRANSFER)
				)
			)
		);
		
		criteriaQuery.select(root);
		
		TypedQuery<Transaction> typedQuery = em.createQuery(criteriaQuery);

		return typedQuery.getResultList();

	}

	public List<Transaction> getCharges(Account account){
		
		// String sql = String.format("SELECT e.id, e.detail, e.date, e.type, e.originAccount, e.destinyAccount, e.amount FROM %s e", entityClass.getName());
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> criteriaQuery = cb.createQuery(Transaction.class);
		Root<Transaction> root = criteriaQuery.from(Transaction.class);
		
		criteriaQuery.multiselect(root.get("id"), root.get("originAccount"), root.get("destinyAccount"), root.get("type"), root.get("date"), root.get("amount"), root.get("detail"));
		
		criteriaQuery.where(
			cb.or(
				cb.and(
					cb.equal(root.get("originAccount"), account),
					cb.equal(root.get("type"), PlanAccount.CHARGE)
				),
				
				cb.and(
					cb.equal(root.get("originAccount"), account),
					cb.equal(root.get("type"), PlanAccount.TRANSFER)
				)
			)
		);
		
		criteriaQuery.select(root);
		
		TypedQuery<Transaction> typedQuery = em.createQuery(criteriaQuery);

		return typedQuery.getResultList();

	}
	
}
