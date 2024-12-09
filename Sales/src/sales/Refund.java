package sales;

import java.util.ArrayList;

public class Refund extends Transaction {
	private String reason;
	private ArrayList<Saleable> items;
	
	//Constructor to create a refund object
	public Refund(int value, String reason) {
		super(value > 0 ? -value : value);
		this.reason = reason;
		this.items = new ArrayList<>();
	}
	
	public void addRefundItem(Saleable item) {
		items.add(item);
		System.out.println("Add item to refund: " + item.getName() + item.getPrice());
	}
	
	public ArrayList<Saleable> getItems() {
		return items;
	}
	
	public void processRefund() {
		System.out.println("Processing refund...");
		int refundValue = 0;
		for (Saleable item : items) {
			refundValue -= item.getPrice();
			
			if (item instanceof Product) {
				Product product = (Product) item;
			System.out.println("Refunding item: " + item.getName() + ", Refund reason: " + reason);
			refundValue -= product.calculateDelivery();
			} else if (item instanceof Service) {
				Service service =  (Service) item;
				System.out.println("Refunding service: " + service.getName() + ", Refund reason: " + reason);
				refundValue -= service.getPrice();
			}
		}
		int value = refundValue;
		refundValue = value > 0 ? -value : value;
		super.setValue(refundValue);
		System.out.println("Total refund amount: " + refundValue + "p");
	}
	
	public String getReason() {
		return reason;
	}
	
	//Display transaction method that overrides the method of the same name in the parent class (Transaction)
	@Override
	public void displayTransaction() {
		System.out.println("Refund TransactionID: " + getTransactionID() + ", Reason for refund: " + reason + ", Refund amount: " + super.getValue() + "p");
	}
	
}
