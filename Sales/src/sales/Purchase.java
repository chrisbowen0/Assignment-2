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
				
		items.put(item, items.getOrDefault(item, 0) + quantity);
		
		int totalValue = 0;
		for (Saleable i : items.keySet()) {
				totalValue += i.getPrice() * items.get(i);
			if (i instanceof Product) {
				Product product = (Product) i;
				totalValue += product.calculateDelivery() * items.get(i);
			}
		}
		setValue(totalValue);
	}
	
	//Getter method that gets the items
	public HashMap<Saleable, Integer> getItems() {
		return items;
	}
	
	//Display transaction method that will override the parent classes (Transaction) method of the same name
	 @Override
	    public void displayTransaction() {
	        System.out.println("TransactionID: " + getTransactionID());

	        int totalDelivery = 0;
	        int subtotal = 0;

	        for (Saleable currentItem : items.keySet()) {
	        	this.item = currentItem;
	            quantity = items.get(item);
	            int itemSubtotal = item.getPrice() * quantity;
	            subtotal += itemSubtotal;

	            System.out.println("- Item: " + item.getName() + ", Product price: " + item.getPrice() + "p, Quantity: " + quantity + ",\n SubTotal: " + itemSubtotal + "p");

	            if (item instanceof Product) {
	                Product product = (Product) item;
	                int deliveryCost = product.calculateDelivery() * quantity;
	                totalDelivery += deliveryCost;
	                System.out.println(" Delivery Cost: " + deliveryCost + "p");
	            }
	        }

	        int total = subtotal + totalDelivery;
	        System.out.println(" Total: " + total + "p\n");
	    }
	
}
