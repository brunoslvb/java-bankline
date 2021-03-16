import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import controller.TransactionController;
import controller.UserController;
import model.Account;
import model.PlanAccount;
import model.Transaction;
import model.User;
import repository.AccountRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import service.UserService;
import utils.Validators;

public class Test {

	public static void main(String[] args) {

		UserController userController = new UserController();
		
		TransactionController transactionController = new TransactionController();
				
		User userDisable = new User();
		
		userDisable.setName("Teste da Silva");
		userDisable.setCpf("22222222222");
		userDisable.setLogin("teste");
		userDisable.setPassword("020202");	
		
		User userEnable = new User();
		
		userEnable.setName("Teste 2");
		userEnable.setCpf("33333333333");
		userEnable.setLogin("teste2");
		userEnable.setPassword("030303");
		
		User user = new User();
		
		user.setName("Bruno");
		user.setCpf("44444444444");
		user.setLogin("bruno");
		user.setPassword("040404");
		
		// userController.save(user);
		
		// controller.delete(user);
		
		// User userFound = controller.find(user.getCpf());
		
		/* System.out.println("Usuário encontrado: " + userFound.getName());
		
		List<User> users = controller.listAll();
		
		for(User user2 : users) {
			System.out.println(user2.getName());
		}
		
		AccountRepository accountRepository = new AccountRepository();
		*/
		Account account = new Account();
		
		account.setNumber(1);
		account.setUser(userDisable);
		
		Account account2 = new Account();
		
		account2.setNumber(2);
		account2.setUser(userEnable);
		
		Account account3 = new Account();
		
		account3.setNumber(3);
		account3.setUser(user);
		
		// Account userFound = accountRepository.findByCpf(user);
		
		// System.out.println("Usuário encontrado: " + userFound.getNumber());
		
		// accountRepository.delete(account);
		
		// accountRepository.save(account);
		
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
		
		
		TransactionRepository transactionRepository = new TransactionRepository();
		
		Transaction transaction = new Transaction();
		
		transaction.setOriginAccount(account2);
		transaction.setDate(new Date());
		transaction.setDetail("Empréstimo para pagar o teclado");
		transaction.setAmount(5.00);
		transaction.setType(PlanAccount.REVENUE);
		
		// transactionController.save(transaction);
		
		// transactionsRepository.save(transactions);
		
		Transaction transactions2 = new Transaction();
		
		transactions2.setOriginAccount(account3);
		transactions2.setDestinyAccount(account2);
		transactions2.setDate(new Date());
		transactions2.setDetail("Devolução parte do dinheiro");
		transactions2.setAmount(25.00);
		transactions2.setType(PlanAccount.TRANSFER);
		
		// transactionController.save(transactions2);
		
		// transactionsRepository.save(transactions2);
		
		/*Transactions transactionFound = transactionsRepository.find(transactions.getId());
		
		System.out.println("Usuário encontrado: " + transactionFound.getAccount() + " - " + transactionFound.getAmount());
		
		transactions.setDetail("Lala");
		
		transactionsRepository.update(transactions);
		*/
		
		
		List<Transaction> transactions = transactionController.getAllTransactions(account2);

		System.out.println("ALL");
		
		System.out.println(transactions.size());
		
		for(Transaction transactionFor : transactions) {
			transactionController.showTransaction(transactionFor);
		}
		
				
		/*transactions = transactionController.getCharges(account2);
		
		System.out.println("DESPESAS");
		
		System.out.println(transactions.size());
		
		for(Transaction transactionFor : transactions) {
			transactionFor.setAmount(transactionFor.getAmount() * -1);
			transactionController.showTransaction(transactionFor);
		}*/

		System.exit(0);

	}
	
}
