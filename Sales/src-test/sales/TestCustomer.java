package sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;




public class TestCustomer {

	public Customer customer;
	
	
	//setup for test by creating a customer object before each test
	@BeforeEach
	void setup() {
		customer = new Customer("John Doe");
		
	}
	
	@Test
	void testCreateProducts() {
		ArrayList<Saleable> products = customer.getProducts();
		Product laptop = (Product) products.get(0);
		assertNotNull(products, "Products list should not be null");
		assertFalse(products.isEmpty(), "Products list should not be empty");
		assertEquals(16, products.size(), "Products list should contain 16 items");
		assertEquals("Laptop", products.get(0).getName(), "The first Product should be a Laptop");
		assertEquals("Insert product 1", products.get(11).getName(), "The 11th Product should be a Insert product 1");
		assertEquals(250, laptop.getWeight(), "The weight of the Laptop should be 250g");
		assertEquals(1000, laptop.getPrice(), "The price of the Laptop should be 1000");
	}
	
	@Test
	void testCreateServices() {
	  ArrayList<Saleable> services = customer.getServices();
	  Service antiVirus = (Service) services.get(0);
	  assertNotNull(services, "Services list should not be null");
	  assertFalse(services.isEmpty(), "Services list should not be empty");
	  assertEquals(14, services.size(), "Services list should contain 14 items");
	  assertEquals("Anti-Virus", services.get(0).getName(), "The first service should be Anti-Virus");
	  assertEquals("Coding class", services.get(11).getName(), "The 10th service in the list should be coding class");
	  assertEquals(100, antiVirus.getPrice(), "The price of the Anti-Virus should be 100");
	}
	
	//verify the customer's name is set correctly and return a String if the test fails
	@Test
	void testCustomer() {
		assertEquals("John Doe", customer.getName(), "Customer name should match the input value");
		
	}
	
	//Add a test transaction, verify it's added to the ArrayList and the total is returned correctly. If test fails return string
	@Test
	void testTransaction() {
		Transaction transaction = new Transaction(-100);
		customer.transact(transaction);
		
		assertEquals(-100, customer.getTotal(), "Total should be -100 after adding a value of -100");
	}
	
	//Second test with multiple transactions
	@Test
	void testTransactions() {
		customer.transact(new Transaction(100));
		customer.transact(new Transaction(200));
		customer.transact(new Transaction(550));
		
		assertEquals(850, customer.getTotal(), "Total should be 850 after adding all transactions with values 100, 200 and 550");
	}
	
	@Test
	void testGetValue() {
	    
	    Product laptop = new Product("Laptop", 250, 1000);
	    Purchase laptopPurchase = new Purchase(laptop, 2); 
	    assertEquals(2000, laptopPurchase.getValue(), "The item price should be 2000 before delivery.");
	    Service antivirus = new Service("Anti-Virus", 100);
	    Purchase antivirusPurchase = new Purchase(antivirus, 3);
	    assertEquals(300, antivirusPurchase.getValue(), "The service price should be 300 before delivery.");
	}
	
	@Test
	void testCustomerTotalIncludingDelivery() {
	    Product laptop = new Product("Laptop", 250, 1000);
	    Purchase laptopPurchase = new Purchase(laptop, 2); 
	    Service antivirus = new Service("Anti-Virus", 100);
	    Purchase antivirusPurchase = new Purchase(antivirus, 3); 
	    customer.transact(laptopPurchase);
	    customer.transact(antivirusPurchase);
	    int expectedTotal = 2700;
	    assertEquals(expectedTotal, customer.getTotal(), "The total value should include both item price and delivery cost for products.");
	}
	
	
	
}
