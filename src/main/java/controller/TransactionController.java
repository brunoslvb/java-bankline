package controller;

import model.Transaction;
import service.TransactionService;

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
	
}
