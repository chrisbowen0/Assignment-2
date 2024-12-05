package sales;

import java.util.ArrayList;


public class Customer {

	private String name;
	private ArrayList<Transaction> transactions; 
	
	public Customer(String name) {
		this.name = name;
		this.transactions = new ArrayList<>();
	}
	
	public void transact(Transaction transaction) {
		transactions.add(transaction);
		System.out.println("Transaction added: " + transaction.getTransactionID());
	    }
	
	public int getTotal() {
		int total = 0;
		for (Transaction transaction : transactions) {
			total += transaction.getValue();
		}
		return total;
	}
	
	public void displayTransactions() {
		System.out.println("Customer: " + name);
		for (Transaction transaction : transactions) {
			transaction.displayTransaction();
		}
	}
	
	public Transaction getTransaction(String transactionID) {
		for (Transaction transaction : transactions) {
			if(transaction.getTransactionID().equals(transactionID)) {
				return transaction;
			}
		}
		System.out.println("No transaction ID found");
		return null;
	}
	
	public String getName() {
		return name;
	}
	
}
