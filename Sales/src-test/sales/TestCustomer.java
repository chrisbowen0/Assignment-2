package sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestCustomer {

	private Customer customer;
	
	
	//setup for test by creating a customer object before each test
	@BeforeEach
	void setup() {
		customer = new Customer("John Doe");
		
	}

	@Test
	void testCreateProducts() {
		ArrayList<Saleable> products = customer.getProducts();
		assertNotNull(products, "Products list should not be null");
		assertFalse(products.isEmpty(), "Products list should not be empty");
		assertEquals(16, products.size(), "Products list should have 16 items");
	}
	
	@Test
	void testCreateServices() {
		ArrayList<Saleable> services = customer.getServices();
		assertNotNull(services, "Services list should not be null");
		assertFalse(services.isEmpty(), "Services list should not be empty");
		assertEquals(14, services.size(), "Services list should have 14 items");
	}
	
	@Test
	void testAddTransaction() {
		Purchase purchase = new Purchase();
		purchase.addItem((customer.getProducts().get(0)), 1);
		customer.transact(purchase);
		ArrayList<Transaction> transactions = customer.getTransactions();
		
		assertEquals(1, transactions.size(), "There should be 1 transaction");
		assertEquals(purchase, transactions.get(0), "Transaction should match the added purchase");
	}
	
	@Test
	void testAddTransactions() {
		Purchase purchase = new Purchase();
		purchase.addItem((customer.getProducts().get(5)), 2);
		purchase.addItem((customer.getServices().get(5)), 1);
		purchase.addItem((customer.getProducts().get(0)), 3);
		customer.transact(purchase);
		ArrayList<Transaction> transactions = customer.getTransactions();
		
		assertEquals(1, transactions.size());
		assertEquals(3, purchase.getItems().size(), "There should be 3 items in the list");
		
		Saleable laptop = customer.getProducts().get(0);
		Saleable lumbar = customer.getProducts().get(5);
		Saleable xbox = customer.getServices().get(5);
		assertEquals(3, purchase.getItems().get(laptop), "Should return a quantity of 3");
		assertEquals(2, purchase.getItems().get(lumbar), "Should return a quantity of 2");
		assertEquals(1, purchase.getItems().get(xbox), "Should return a quantity of 1");
	}
	
	@Test
	void testGetTransactionID() {
		Purchase purchase = new Purchase();
		purchase.addItem((customer.getProducts().get(0)), 1);
		customer.transact(purchase);
		
		Transaction transactionID = customer.getTransaction(purchase.getTransactionID());
		assertNotNull(transactionID, "Transaction should be found by ID");
		assertEquals(purchase, transactionID, "TransactionDI should match the added purchase");
	}
	
	@Test
	void testGetTotalPurchase() {
		Purchase purchase = new Purchase();
		purchase.addItem((customer.getProducts().get(2)), 2);
		customer.transact(purchase);
		
		assertEquals(160, customer.getTotal(), "Total should include price and delivery");
		
		purchase.addItem((customer.getProducts().get(0)), 1);
		purchase.addItem((customer.getServices().get(4)), 2);
		
		assertEquals(1370, customer.getTotal(), "Total should include delivery cost for products and no delivery cost for the services");
		customer.displayTransactions();
	}
	
	@Test
	void testGetTotalRefund() {
		Purchase purchase = new Purchase();
		purchase.addItem((customer.getProducts().get(0)), 3);
		purchase.addItem((customer.getServices().get(4)), 1);
		customer.transact(purchase);
		purchase.displayTransaction();
		
		Refund refund = new Refund(customer.getProducts().get(0), 1, "Item damaged in transit");
		refund.addRefundItem(customer.getServices().get(4), 1, "Item no longer required");
		refund.processRefund();
		customer.transact(refund);
		refund.displayTransaction();
		
		assertEquals(2100, customer.getTotal(), "Total should account for refund deduction");
	}
	
	
	
}
