package sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestService {

	private Service service;
	
	@BeforeEach
	void setUp() {
		service = new Service("Warranty", 80);
	}
	
	@Test
	void testGetName() {
		assertEquals("Warranty", service.getName(), "name should return correctly as set by constructor");
	}
	
	@Test
	void testGetPrice() {
		assertEquals(80, service.getPrice(), "Price should be returned as 80 as per the constructor");
	}
	
	@Test
	void testSetPrice() {
		service.setPrice(600);
		assertEquals(600, service.getPrice(), "Price should be set to 600 instead of cost set by constructor");
	}
	
	@Test
	void testToString() {
		assertEquals("Service name: Warranty, Price: 80p", service.toString(), "should return correct string of service item");
	}
	
}
