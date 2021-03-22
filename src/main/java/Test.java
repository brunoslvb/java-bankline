import java.time.LocalDate;
import java.util.List;

import controller.TransactionController;
import controller.UserController;
import model.Account;
import model.PlanAccount;
import model.Transaction;
import model.User;
import utils.Helper;

public class Test {

	public static void main(String[] args) {

		UserController userController = new UserController();
		
		TransactionController transactionController = new TransactionController();
				
		User userDisable = new User();
		
		userDisable.setName("Teste 1");
		userDisable.setCpf("22222222222");
		userDisable.setLogin("teste1");
		userDisable.setPassword("020202");	
		
		User userEnable = new User();
		
		userEnable.setName("Teste 2");
		userEnable.setCpf("33333333333");
		userEnable.setLogin("teste2");
		userEnable.setPassword("030303");
		
		User user = new User();
		
		user.setName("Teste 3");
		user.setCpf("44444444444");
		user.setLogin("teste3");
		user.setPassword("040404");
		
		// userController.save(userDisable);
		// userController.save(userEnable);
		// userController.save(user);
		
		Account accountDisable = new Account();
		
		accountDisable.setNumber(1);
		accountDisable.setUser(userDisable);
		
		Account accountEnable = new Account();
		
		accountEnable.setNumber(2);
		accountEnable.setUser(userEnable);
		
		Account account = new Account();
		
		account.setNumber(3);
		account.setUser(user);
				
		Transaction transaction = new Transaction();
		
		transaction.setOriginAccount(accountEnable);
		transaction.setDate(Helper.getDateTime());
		transaction.setDetail("Salário");
		transaction.setAmount(850.00);
		transaction.setType(PlanAccount.REVENUE);
		
		// transactionController.save(transaction);
				
		Transaction transactions2 = new Transaction();
		
		transactions2.setOriginAccount(accountEnable);
		transactions2.setDestinyAccount(account);
		transactions2.setDate(Helper.getDateTime());
		transactions2.setDetail("Teclado mecânico");
		transactions2.setAmount(260.00);
		transactions2.setType(PlanAccount.TRANSFER);
		
		// transactionController.save(transactions2);
		
		String startDate = LocalDate.of(2021, 03, 15).toString();
		
		String endDate = LocalDate.of(2021, 03, 15).toString();
		
		List<Transaction> transactions = transactionController.getAllTransactions(accountEnable, startDate, null);

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
