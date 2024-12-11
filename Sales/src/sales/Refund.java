package sales;

import java.util.HashMap;

public class Refund extends Transaction {
	private String reason;
	private HashMap<Saleable, Integer> items;
	int quantity;
	
	//Constructor to create a refund object
	public Refund(Saleable item, int quantity, String reason) {
		super(-(item.getPrice() * quantity));
		this.reason = reason;
		this.items = new HashMap<>();
		this.items.put(item, quantity);
	}
	
	public void addRefundItem(Saleable item, int quantity, String reason) {
		items.put(item, items.getOrDefault(item, 0) + quantity);
		System.out.println("Add item to refund: " + item.getName() + " " + item.getPrice() + "p");
	}
	
	public HashMap<Saleable, Integer> getItems() {
		return items;
	}
	
	public void processRefund() {
		System.out.println("Processing refund...");
		int total = 0;
		
		for (Saleable item : items.keySet()) {
			quantity = items.get(item);
			int refundValue = item.getPrice() * quantity;
			total += refundValue;
			
			if (item instanceof Product) {
				Product product = (Product) item;
				int deliveryCost = product.calculateDelivery() * quantity;
			System.out.println("Refunding item: " + item.getName() + ", Refund reason: " + reason);
			total += deliveryCost;
			System.out.println("Refund value includes delivery cost of: " + deliveryCost + "p");
			} 
		}
		super.setValue(-total);
		System.out.println("Total refund amount: " + (-total) + "p");
	}
	
	public String getReason() {
		return reason;
	}
	
	//Display transaction method that overrides the method of the same name in the parent class (Transaction)
	@Override
	public void displayTransaction() {
		System.out.println("Refund TransactionID: " + getTransactionID() + ", Reason for refund: " + reason + ", Refund amount: " + getValue() + "p");
	}
	
}
