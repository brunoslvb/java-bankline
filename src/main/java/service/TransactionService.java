package service;

import java.util.List;

import model.Account;
import model.StatusAccount;
import model.Transaction;
import repository.AccountRepository;
import repository.TransactionRepository;

public class TransactionService {

	private TransactionRepository transactionRepository = new TransactionRepository();
	private AccountRepository accountRepository = new AccountRepository();
	
	public void saveCharge(Transaction transaction) {
		// DESPESA
		
		Account account = accountRepository.findById(transaction.getOriginAccount());
		
		if(account.getStatus() == StatusAccount.DISABLE) {
			System.out.println("Conta inativa");
			return;
		}
		
		if(account.getBalance() < transaction.getAmount()) {
			System.out.println("Pobre");
			return;
		}
		
		Double balance = account.getBalance() - transaction.getAmount();
		
		account.setBalance(balance);
		
		accountRepository.update(account);
		
		transactionRepository.save(transaction);

	}
	
	public void saveRevenue(Transaction transaction) {
		// RECEITA
		
		Account account = accountRepository.findById(transaction.getOriginAccount());
		
		if(account.getStatus() == StatusAccount.DISABLE) {
			System.out.println("Conta inativa");
			return;
		}
		
		Double balance = account.getBalance() + transaction.getAmount();
		
		account.setBalance(balance);
		
		accountRepository.update(account);
		
		transactionRepository.save(transaction);
		
		
	}
	
	public void saveTransfer(Transaction transaction) {
		// TRANSFERENCIA
		
		if(transaction.getDestinyAccount() == null) {
			System.out.println("Conta destino não pode ser nula");
			return;
		}
		
		Account originAccount = accountRepository.findById(transaction.getOriginAccount());
		
		Account destinyAccount = accountRepository.findById(transaction.getDestinyAccount());
		
		if(originAccount.getStatus() == StatusAccount.DISABLE || destinyAccount.getStatus() == StatusAccount.DISABLE) {
			System.out.println("Uma das contas está inativa");
			return;
		}
		
		if(originAccount.getBalance() < transaction.getAmount()) {
			System.out.println("Pobre");
			return;
		}
		
		Double originBalance = originAccount.getBalance() - transaction.getAmount();
		Double destinyBalance = destinyAccount.getBalance() + transaction.getAmount();
		
		originAccount.setBalance(originBalance);
		destinyAccount.setBalance(destinyBalance);
		
		accountRepository.update(originAccount);
		accountRepository.update(destinyAccount);
		
		transactionRepository.save(transaction);
		
	}
	
	/*public List<Transaction> getTransactions() {
	
		List<Transaction> revenues = getRevenues();
		
		List<Transaction> charges = getCharges();
		
	}*/
	
	public List<Transaction> getRevenues(Account account) {
		
		return transactionRepository.getRevenues(account);
		
	}
	
	public List<Transaction> getCharges(Account account) {
		
		return transactionRepository.getCharges(account);
		
	}
	
	public List<Transaction> getAllTransactions(Account account) {
		
		return transactionRepository.getAllTransactions(account);
		
	}
	
	
}
