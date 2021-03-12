import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import model.Account;
import model.PlanAccount;
import model.Transactions;
import model.User;
import repository.AccountRepository;
import repository.TransactionsRepository;
import repository.UserRepository;

public class Test {

	public static void main(String[] args) {
		
		UserRepository userRepository = new UserRepository();
		
		User user = new User();
		
		user.setName("Bruno da Silva Barros 2");
		user.setCpf("12345678900");
		user.setLogin("bruno");
		user.setPassword("123456");
		
		// userRepository.save(user);
		
		User user2 = new User();
		
		user2.setName("Gabriel");
		user2.setCpf("55555555555");
		user2.setLogin("gabriel");
		user2.setPassword("66666");
		
		// userRepository.save(user2);
		
		// userRepository.update(user);
		// userRepository.delete(user.getLogin());
		
		// User userFound = userRepository.find("vitor");
		
		// List<User> users = userRepository.list();
		
		/*for(User user2 : users) {
			System.out.println(user2.getName());
		}*/
		
		AccountRepository accountRepository = new AccountRepository();
		
		Account account = new Account();
		
		// account.setNumber(00001);
		account.setUser(user);
		
		accountRepository.save(account);
		
		Account account2 = new Account();
		
		// account2.setNumber(00002);
		account2.setUser(user2);
		
		accountRepository.save(account2);
		
		/*Account accountFound = accountRepository.find(account.getNumber());
		
		System.out.println("Usuário encontrado: " + accountFound.getNumber() + " - " + accountFound.getBalance());
		
		account.setBalance(105.68);
		
		accountRepository.update(account);
		
		List<Account> accounts = accountRepository.list();
		
		for(Account accountFor : accounts) {
			System.out.println(accountFor.getNumber());
		}
		
		accountRepository.delete(account2.getNumber());
		
		accounts = accountRepository.list();
		
		for(Account accountFor : accounts) {
			System.out.println(accountFor.getNumber());
		}*/
		
		
		/*TransactionsRepository transactionsRepository = new TransactionsRepository();
		
		Transactions transactions = new Transactions();
		
		transactions.setOriginAccount(account);
		transactions.setDate(new Date());
		transactions.setDetail("Despesa teste");
		transactions.setAmount(123.25);
		transactions.setType(PlanAccount.CHARGES);
		
		// transactionsRepository.save(transactions);
		
		Transactions transactions2 = new Transactions();
		
		transactions2.setOriginAccount(account2);
		transactions2.setDate(new Date());
		transactions2.setDetail("Salário Accenture");
		transactions2.setAmount(2500.00);
		transactions2.setType(PlanAccount.REVENUE);*/
		
		// transactionsRepository.save(transactions2);
		
		/*Transactions transactionFound = transactionsRepository.find(transactions.getId());
		
		System.out.println("Usuário encontrado: " + transactionFound.getAccount() + " - " + transactionFound.getAmount());
		
		transactions.setDetail("Lala");
		
		transactionsRepository.update(transactions);
		
		List<Transactions> transactionsTeste = transactionsRepository.list();
		
		for(Transactions transactionFor : transactionsTeste) {
			System.out.println(transactionFor.getAccount());
		}
		
		transactionsRepository.delete(transactions2.getId());
		
		transactionsTeste = transactionsRepository.list();
		
		for(Transactions transactionFor : transactionsTeste) {
			System.out.println(transactionFor.getAccount().getNumber());
		}*/
		
	}
	
}
