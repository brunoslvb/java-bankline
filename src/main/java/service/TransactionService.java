package service;

import java.util.List;

import exception.DisabledAccountException;
import exception.InsufficientAmountException;
import model.Account;
import model.StatusAccount;
import model.Transaction;
import repository.AccountRepository;
import repository.TransactionRepository;
import utils.Helper;

public class TransactionService {

	private TransactionRepository transactionRepository = new TransactionRepository();
	private AccountRepository accountRepository = new AccountRepository();
	
	public void saveCharge(Transaction transaction) {
		// DESPESA
		
		Account account = accountRepository.findById(transaction.getOriginAccount());
		
		if(account.getStatus() == StatusAccount.DISABLE) {
			throw new DisabledAccountException("Conta desabilitada");
		}
		
		if(account.getBalance() < transaction.getAmount()) {
			throw new InsufficientAmountException("Dinheiro insuficiente para realizar transação");
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
			throw new DisabledAccountException("Conta desabilitada");
		}
		
		Double balance = account.getBalance() + transaction.getAmount();
		
		account.setBalance(balance);
		
		accountRepository.update(account);
		
		transactionRepository.save(transaction);
		
		
	}
	
	public void saveTransfer(Transaction transaction) {
		// TRANSFERENCIA
		
		if(transaction.getDestinyAccount() == null) {
			throw new NullPointerException("Para esse tipo de transação, a conta destino não pode ser nula");
		}
		
		Account originAccount = accountRepository.findById(transaction.getOriginAccount());
		
		Account destinyAccount = accountRepository.findById(transaction.getDestinyAccount());
		
		if(originAccount.getStatus() == StatusAccount.DISABLE || destinyAccount.getStatus() == StatusAccount.DISABLE) {
			throw new DisabledAccountException("Conta desabilitada");
		}
		
		if(originAccount.getBalance() < transaction.getAmount()) {
			throw new InsufficientAmountException("Dinheiro insuficiente para realizar transação");
		}
		
		Double originBalance = originAccount.getBalance() - transaction.getAmount();
		Double destinyBalance = destinyAccount.getBalance() + transaction.getAmount();
		
		originAccount.setBalance(originBalance);
		destinyAccount.setBalance(destinyBalance);
		
		accountRepository.update(originAccount);
		accountRepository.update(destinyAccount);
		
		transactionRepository.save(transaction);
		
	}
	
	
	public List<Transaction> getRevenues(Account account, String startDate, String endDate) {
		
		if(account == null || startDate == null) { 
			throw new NullPointerException("Parâmetros não podem ser nulos");
		}
		
		endDate = Helper.checkIfEndDateIsNull(endDate);

		startDate = Helper.concatStartTime(startDate);
		
		return transactionRepository.getRevenues(account, startDate, endDate);
		
	}
	
	public List<Transaction> getCharges(Account account, String startDate, String endDate) {
		
		endDate = Helper.checkIfEndDateIsNull(endDate);

		startDate = Helper.concatStartTime(startDate);
		
		return transactionRepository.getCharges(account, startDate, endDate);
		
	}
	
	public List<Transaction> getAllTransactions(Account account, String startDate, String endDate) {
		
		endDate = Helper.checkIfEndDateIsNull(endDate);

		startDate = Helper.concatStartTime(startDate);
		
		return transactionRepository.getAllTransactions(account, startDate, endDate);
		
	}

}
