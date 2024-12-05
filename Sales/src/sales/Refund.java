package sales;

public class Refund extends Transaction {

	private String reason;
	private Saleable item;
	
	//Constructor to create a refund object
	public Refund(Saleable item, int value, String reason) {
		super(value);
		this.item = item;
		this.reason = reason;
	}
	
	//Method to refund an item and set the refund value
	public void refundItem() {
		//sets a new variable using the getValue method in the transaction class as it is a protected variable
		int refundValue = super.getValue();
		/* using setValue method in Transaction class to set value and then uses the below check to set to a 
		    negative value if the method is passed a positive number or leaves the number as is if it's 0 or negative */
		super.setValue(refundValue > 0 ? -refundValue : refundValue);
		System.out.println("Refunding item: " +  item.getName() + " Refund reason: " + reason);
	}
	
	//Getter to return the reason variable
	public String getReason() {
		return reason;
	}
	
	//Getter to return the item variable
	public Saleable getItem() {
		return item;
	}
	
	//Display transaction method that overrides the method of the same name in the parent class (Transaction)
	@Override
	public void displayTransaction() {
		System.out.println("Refund TransactionID: " + getTransactionID() + ", Reason for refund: " + reason + ", Refund amount: " + getValue());
	}
	
}
