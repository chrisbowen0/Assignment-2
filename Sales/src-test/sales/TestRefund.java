package sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

public class TestRefund {

	private Product product;
	private Service service;
	private Refund refund;
	
	//setup refund with positive value
	@BeforeEach
	void setup() {
		product = new Product("Laptop", 250, 1000);
		service = new Service("Warranty", 80);
		refund = new Refund(product, 1, "faulty item");
	}
	
	@Test
	void testRefundItem() {
		refund.addRefundItem(product, 3, "Ordered in error");
		refund.addRefundItem(service, 2, "No longer requred");
		
		HashMap<Saleable, Integer> items = refund.getItems();
		assertEquals(2, items.size(), "Refund should contain 2 items");
		assertEquals(4, items.get(product), "Quantity of product should be 3");
		assertEquals(2, items.get(service), "Quantity of Service should be 2");
	}
	
	@Test
	void testProcessRefund() {
	refund.addRefundItem(product, 2, "No longer required");
	refund.addRefundItem(service,  1, "No longer requires service");
	
	refund.processRefund();
	//3 Laptops with delivery of 50p plus 1 warranty
	assertEquals(-3230, refund.getValue(), "Refund value should include items and delivery cost if applicable");
	}
	
	@Test
	void tesGetItems() {
		refund.addRefundItem(service, 2, "Incorrect item");
		
		HashMap<Saleable, Integer> items = refund.getItems();
		assertEquals(true, items.containsKey(product), "Refund item should be Laptop product"); //See setup above for product information
		assertEquals(true, items.containsKey(service), "Refund item should be Warranty"); //see setup for service information
		assertEquals(1, items.get(product), "Quantity of product should be 1");
		assertEquals(2, items.get(service), "Quantity of service should be 2");
	}
	
}
