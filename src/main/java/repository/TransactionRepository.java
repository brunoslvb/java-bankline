package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Account;
import model.PlanAccount;
import model.Transaction;
import utils.Helper;

public class TransactionRepository extends AbstractRepository<Transaction> implements Repository<Transaction> {

	public List<Transaction> getRevenues(Account account, String startDate, String endDate){
				
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> criteriaQuery = cb.createQuery(Transaction.class);
		Root<Transaction> root = criteriaQuery.from(Transaction.class);

		criteriaQuery.multiselect(root.get("id"), root.get("originAccount"), root.get("destinyAccount"), root.get("type"), root.get("date"), root.get("amount"), root.get("detail"));
		
		criteriaQuery.where(
			cb.or(
				cb.and(
					cb.equal(root.get("originAccount"), account),
					cb.equal(root.get("type"), PlanAccount.REVENUE),
					cb.between(root.<String>get("date"), startDate, endDate)
				),
				
				cb.and(
					cb.equal(root.get("destinyAccount"), account),
					cb.equal(root.get("type"), PlanAccount.TRANSFER),
					cb.between(root.<String>get("date"), startDate, endDate)
				)
			)
		);
		
		criteriaQuery.select(root);
		
		TypedQuery<Transaction> typedQuery = em.createQuery(criteriaQuery);

		return typedQuery.getResultList();

	}

	public List<Transaction> getCharges(Account account, String startDate, String endDate){
				
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> criteriaQuery = cb.createQuery(Transaction.class);
		Root<Transaction> root = criteriaQuery.from(Transaction.class);
		
		criteriaQuery.multiselect(root.get("id"), root.get("originAccount"), root.get("destinyAccount"), root.get("type"), root.get("date"), root.get("amount"), root.get("detail"));
		
		criteriaQuery.where(
			cb.or(
				cb.and(
					cb.equal(root.get("originAccount"), account),
					cb.equal(root.get("type"), PlanAccount.CHARGE),
					cb.between(root.<String>get("date"), startDate, endDate)
				),
				
				cb.and(
					cb.equal(root.get("originAccount"), account),
					cb.equal(root.get("type"), PlanAccount.TRANSFER),
					cb.between(root.<String>get("date"), startDate, endDate)
				)
			)
		);
		
		criteriaQuery.select(root);
		
		TypedQuery<Transaction> typedQuery = em.createQuery(criteriaQuery);

		return typedQuery.getResultList();

	}
	
	public List<Transaction> getAllTransactions(Account account, String startDate, String endDate) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		transactions.addAll(getRevenues(account, startDate, endDate));
		
		transactions.addAll(getCharges(account, startDate, endDate));
		
		Collections.sort(transactions, new Transaction());
		
		return transactions;
		
	}
	
}
