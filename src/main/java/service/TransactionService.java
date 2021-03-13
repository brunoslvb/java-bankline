package service;

import model.Account;
import model.StatusAccount;
import model.Transaction;
import repository.AccountRepository;
import repository.TransactionsRepository;

public class TransactionService {

	private TransactionsRepository transactionRepository = new TransactionsRepository();
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
	
}
