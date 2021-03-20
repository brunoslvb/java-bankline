import java.time.LocalDate;
import java.util.List;

import controller.TransactionController;
import controller.UserController;
import model.Account;
import model.PlanAccount;
import model.Transaction;
import model.User;
import repository.TransactionRepository;
import utils.Helper;

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
		
		Account account = new Account();
		
		account.setNumber(1);
		account.setUser(userDisable);
		
		Account account2 = new Account();
		
		account2.setNumber(2);
		account2.setUser(userEnable);
		
		Account account3 = new Account();
		
		account3.setNumber(3);
		account3.setUser(user);
				
		Transaction transaction = new Transaction();
		
		transaction.setOriginAccount(account2);
		transaction.setDate(Helper.getDateTime());
		transaction.setDetail("Empréstimo para pagar o teclado");
		transaction.setAmount(50.00);
		transaction.setType(PlanAccount.REVENUE);
		
		// transactionController.save(transaction);
				
		Transaction transactions2 = new Transaction();
		
		transactions2.setOriginAccount(account2);
		transactions2.setDestinyAccount(account3);
		transactions2.setDate(Helper.getDateTime());
		transactions2.setDetail("Devolução parte do dinheiro");
		transactions2.setAmount(33.25);
		transactions2.setType(PlanAccount.TRANSFER);
		
		// transactionController.save(transactions2);
		
		String startDate = LocalDate.of(2021, 03, 15).toString();
		
		String endDate = LocalDate.of(2021, 03, 15).toString();
		
		List<Transaction> transactions = transactionController.getAllTransactions(account2, startDate, endDate);

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
