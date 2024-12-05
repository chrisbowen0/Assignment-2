package sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;



public class TestCustomer {

	public Customer customer;
	
	
	//setup for test by creating a customer object before each test
	@BeforeEach
	void setup() {
		customer = new Customer("John Doe");
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
	
	
	
}
