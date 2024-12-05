package sales;

import java.util.ArrayList;

public class Transaction {

	protected int value;
	private static int counterID = 1;
	private String transactionID;	
	private ArrayList<Saleable> items;
	
	//Transaction constructor witch requires attribute of value
	protected Transaction(int value) {
		this.transactionID = generateID();
		this.value = value;
		this.items = new ArrayList<>();
	}
	
	//Method to generate a transaction ID using the counterID variable returning the counter + 1 with every iteration and adding AST (Aston) as a prefix
	private String generateID() {
		return "AST-" + counterID++;
	}
	
	//Add item to the items ArrayList
		public void addItem(Saleable item) {
			items.add(item);
		}
		
		//getter method to get transaction ID
		public String getTransactionID() {
			return transactionID;
		}
		
		//Method to display a transaction which will return the transactionID, total value of the order and then iterate through the order and return each item name and item price
		public void displayTransaction() {
			System.out.println("Transaction ID: " + transactionID);
			System.out.println("Total Value: " + value);
			for(Saleable item : items) {
				System.out.println("Item: " + item.getName() + ", Price: " + item.getPrice());
			}
		}
	
	//Getter method used to retrieve value
	public int getValue() {
		return value;
	}
	
	//Setter for value variable only accessible by this class and any sub classes
	protected void setValue(int value) {
		this.value = value;
	}
	
	//Method to return items in ArrayList
	public ArrayList<Saleable> getItems() {
		return items;
	}
	
	
	
		
}
