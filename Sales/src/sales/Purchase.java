package sales;

import java.util.HashMap;

public class Purchase extends Transaction {

	private Saleable item;
	private int quantity;
	private HashMap<Saleable, Integer> items;
	
	//Purchase constructor
	public Purchase() {
		super(0);
		this.items = new HashMap<>();
	}
	
	public void addItem(Saleable item, int quantity) {
		if (this.item == null) {
			this.item = item;
			this.quantity = quantity;
		} else {
		
		items.put(item, items.getOrDefault(item, 0) + quantity);
		}
		int totalValue = 0;
		if (this.item != null) {
			totalValue += this.item.getPrice() * this.quantity;
		}
		for (Saleable i : items.keySet()) {
			totalValue += i.getPrice() * items.get(i);
		}
		setValue(totalValue);
	}
	
	//Setter method that sets the item variable
	public void setItem(Saleable item) {
		this.item = item;
	}
	
	public Saleable getItem() {
        return item;
    }
	
	//Getter method that gets the items
	public HashMap<Saleable, Integer> getItems() {
		return items;
	}
	
	//Setter method to set the quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		setValue(super.getValue() / this.quantity * quantity);
	}
	
	//Getter method to get the quantity
	public int getQuantity() {
		return quantity;
	}
	
	//Display transaction method that will override the parent classes (Transaction) method of the same name
	@Override
	public void displayTransaction() {
		System.out.println("TransactionID: " + getTransactionID());
		int subtotal = 0;
		int totalDelivery = 0;
		
		if(this.item != null) {
			int itemSubtotal = item.getPrice() * quantity;
			subtotal += itemSubtotal;
			System.out.println("- Item: " + item.getName() + ", Quantity: " + quantity + ", \n SubTotal: " + itemSubtotal);	
		
			if (item instanceof Product) {
				Product product = (Product) item;
				int deliveryCost = product.calculateDelivery() * quantity;
				totalDelivery += deliveryCost;
				System.out.println(" Delivery cost: " + deliveryCost);
		    }
	    }
	    for (Saleable item : items.keySet()) {
	    	int itemQuantity = items.get(item);
	    	int itemSubtotal = item.getPrice() * itemQuantity;
	    	subtotal += itemSubtotal;
	    	System.out.println("- Item: " + item.getName() + ", Quantity: " + itemQuantity + ", \n SubTotal:  " + itemSubtotal);
	    	if (item instanceof Product) {
	    		Product product = (Product) item;
	    		int deliveryCost = product.calculateDelivery() * itemQuantity;
	    		totalDelivery += deliveryCost;
	    		System.out.println(" Delivery Cost: " + deliveryCost);
	    	}
	    }
	
		int total = subtotal + totalDelivery;
		
		
		System.out.println(" Total Value:   " + total);
	}
	
}
