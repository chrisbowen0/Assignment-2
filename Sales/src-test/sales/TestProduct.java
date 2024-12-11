package sales;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class TestProduct {

	private Product product;
	
	@BeforeEach
	void setup() {
		product = new Product("Laptop", 150, 1000);
	}
	
	@Test
	void testGetName() {
		assertEquals("Laptop", product.getName(), "The name should be Laptop");
	}
	
	@Test
	void testSetName() {
		product.setName("Headset");
		assertEquals("Headset", product.getName(), "The name should be updated to Headset");
	}
	
	@Test
	void testGetPrice() {
		assertEquals(1000, product.getPrice(), "The price should be 1000");
	}
	
	@Test
	void testSetPrice() {
		product.setPrice(2000);
		assertEquals(2000, product.getPrice(), "The price should be updated to 2000");
	}
	
	@Test
	void testGetWeight() {
		assertEquals(150, product.getWeight(), "The weight should be 150");
	}
	
	@Test
	void testSetWeight() {
		product.setWeight(250);
		assertEquals(250, product.getWeight(), "The weight should be updated to 250");
	}
	
	@Test
	void TestCalculateDelivery() {
		assertEquals(30, product.calculateDelivery(), " The delivery cose should be 30p for a weight of 150g");
		
		product.setWeight(1500);
		assertEquals(250, product.calculateDelivery(), "The delivery cost should be 250p based on the new weight of 1500g");
		
		product.setWeight(50);
		assertEquals(0, product.calculateDelivery(), "The delivery cost should be 0p based on the new weight being 50g");
	}
	
	@Test
	void testToString() {
		assertEquals("Product name: Laptop, Weight: 150g, Price: 1000p", product.toString(), "The toString method should return the correct format");
	}
	
}
