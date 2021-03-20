package controller;

import java.time.LocalDate;
import java.util.List;

import model.Account;
import model.PlanAccount;
import model.Transaction;
import service.TransactionService;
import utils.Helper;

public class TransactionController {

	private TransactionService service = new TransactionService();
	
	public void save(Transaction transaction) {
		
		switch (transaction.getType()) {
			case CHARGE:
				service.saveCharge(transaction);
				break;
				
			case REVENUE:
				service.saveRevenue(transaction);
				break;
				
			case TRANSFER:
				service.saveTransfer(transaction);
				break;
	
			default:
				System.out.println("Operação inválida");
				return;
		}
		
	}
	
	
	public List<Transaction> getRevenues(Account account, String startDate, String endDate) {
		
		return service.getRevenues(account, startDate, endDate);
		
	}
	
	public List<Transaction> getCharges(Account account, String startDate, String endDate) {
		
		return service.getCharges(account, startDate, endDate);
		
	}
	
	public List<Transaction> getAllTransactions(Account account, String startDate, String endDate) {
		
		return service.getAllTransactions(account, startDate, endDate);
		
	}
	
	public void showTransaction(Transaction transaction) {
		
		System.out.println(
				"ID: " + transaction.getId() + "\n" +
				"Origin: " + transaction.getOriginAccount() + "\n" +
				"Destiny: " + transaction.getDestinyAccount() + "\n" +
				"Type: " + transaction.getType() + "\n" +
				"Detail: " + transaction.getDetail() + "\n" +
				"Amount: " + transaction.getAmount() + "\n" +
				"Date: " + transaction.getDate() + "\n" +
				"\n"
		);
		
	}
	
}
