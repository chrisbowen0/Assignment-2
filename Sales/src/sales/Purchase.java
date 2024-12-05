package sales;

public class Purchase extends Transaction {

	private Saleable item;
	private int quantity;
	
	//Purchase constructor
	public Purchase(Saleable item, int quantity, int value) {
		super(value);
		this.quantity = quantity;
		this.item = item;
	}
	
	//Purchase item method - currently does nothing
	public void purchaseItem() {
		
	}
	
	//Setter method that sets the item variable
	public void setItem(Saleable item) {
		this.item = item;
	}
	
	//Getter method that gets the item
	public Saleable getItem() {
		return item;
	}
	
	//Setter method to set the quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//Getter method to get the quantity
	public int getQuantity() {
		return quantity;
	}
	
	//Display transaction method that will override the parent classes (Transaction) method of the same name
	@Override
	public void displayTransaction() {
		super.displayTransaction();
		System.out.println("Item: " + item.getName() + 	", Quantity: " + quantity);
	}
	
}
