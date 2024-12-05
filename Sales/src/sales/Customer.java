package sales;

import java.util.ArrayList;


public class Customer {

	private String name;
	private ArrayList<Transaction> transactions; 
	private ArrayList<Saleable> products;
	private ArrayList<Saleable> services;
	
	public Customer(String name) {
		this.name = name;
		this.transactions = new ArrayList<>();
		this.products = new ArrayList<>();
		this.services = new ArrayList<>();
		
		createProducts();
		createServices();
	}
	
	public void createProducts() {
		products.add(new Product("Laptop", 250, 1000));
		products.add(new Product("32 inch computer monitor", 500, 250));
		products.add(new Product("Laptop stand", 150, 50));
		products.add(new Product("Wireless charger", 50, 100));
		products.add(new Product("Office chair", 5000, 125));
		products.add(new Product("Lumbar support cushion", 10, 50));
		products.add(new Product("Wireless mouse with bluetooth", 10, 85));
		products.add(new Product("Wireless headset with blueetooth", 10, 30));
		products.add(new Product("22 inch monitor", 200, 300));
		products.add(new Product("Wired mouse", 15, 30));
		products.add(new Product("wired headset", 10, 30));
		products.add(new Product("Insert product 1", 10, 10));
		products.add(new Product("Insert product 2", 10, 10));
		products.add(new Product("Insert product 3", 10, 10));
		products.add(new Product("Insert product 4", 10, 10));
		products.add(new Product("Insert product 5", 10, 10));		
	}
	
	public void createServices() {
		services.add(new Service("Anti-Virus", 100));
		services.add(new Service("2-Year extended Warranty", 60));
		services.add(new Service("Microsoft 365", 150));
		services.add(new Service("Online support", 100));
		services.add(new Service("Remote machine wipe", 80));
		services.add(new Service("Xbox game pass", 200));
		services.add(new Service("Cloud back up per 1GB", 50));
		services.add(new Service("24 hour support desk", 500));
		services.add(new Service("Dog sitting", 350));
		services.add(new Service("Social media guidence", 1000));
		services.add(new Service("Musical tune making class", 60));
		services.add(new Service("Coding class", 2000));
		services.add(new Service("Azure for business", 100));
		services.add(new Service("Azure Student", 30));
	}
	
	public void displayItems() {
    System.out.println("Available Products and Services for " + name + ":");
		  
      if(!products.isEmpty()) {
	    System.out.println("Products: ");	
	  	for (Saleable item : products) {
	  	  Product products = (Product) item;
	  	  System.out.println(products.toString());
	  	} 
	  } else {
	      System.out.println("No Products available at this time.");
	  	}
	  	  
	  if(!services.isEmpty()) {
	    System.out.println("Services: ");
	  	for (Saleable item : services) {
	  	  Service services = (Service) item;
	  	  System.out.println(services.toString());
	  	}
	  } else {
		  System.out.println("No Services available at this time.");
	  }
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
	
	//Visible for testing
	protected ArrayList<Saleable> getProducts() {
		return products;
	}
	
	//Visible for testing
	protected ArrayList<Saleable> getServices() {
		return services;
	}
	
	//Visible for testing
	protected ArrayList<Transaction> getTransactions() {
		return transactions;
	}
 	
}
