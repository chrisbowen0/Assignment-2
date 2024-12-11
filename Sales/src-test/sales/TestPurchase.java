package sales;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPurchase {

	private Purchase purchase;
	private Product product;
	private Service service;
	
	@BeforeEach
	void setUp() {
		purchase = new Purchase();
		product = new Product("Laptop", 250, 1000);
		service = new Service("Warranty", 80);
	}
	
	@Test
	void testAddItem() {
		purchase.addItem(product, 1);
		purchase.addItem(service, 3);
		
		HashMap<Saleable, Integer> items = purchase.getItems();
		assertEquals(1, items.get(product), "Quantity returned should be 1");
		assertEquals(3, items.get(service), "Quantity returned should be 3");
		assertEquals(1290, purchase.getValue(), "Total value should include item prices and delivery cost for products only");
	}
	
	@Test
	void testEmptyItems() {
		HashMap<Saleable, Integer> items = purchase.getItems();
		assertTrue(items.isEmpty(), "Items HashMap should be empty ready to accept a new purchase");
	}
	
	
}
