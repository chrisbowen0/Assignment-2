package sales;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class TestProduct {

	private Product calculator;
	
	@BeforeEach
	void setup() {
		calculator = new Product("Laptop", 50, 200);
	}
	//No delivery cost for items under 100g
	@Test
	public void FreeDelivery() {
		calculator.setWeight(50);
		int price = calculator.calculateDelivery();
		assertEquals(0, price, "Delivery cost should be free for less than 100g");
	}
	//Delivery cost at 20% of product weight
	@Test
	public void middleDelivery() {
		calculator.setWeight(500);
		int price = calculator.calculateDelivery();
		assertEquals(100, price, "Delivery cost should be 20% of weight for anything more than or equal to 100g and less than 1000g");
	}
	//Delivery cost is 20% on the first 1000g then 10% of any wait over 1000g
	@Test
	public void highestDeliveryCost() {
		calculator.setWeight(1500);
		int price = calculator.calculateDelivery();
		assertEquals(250, price, "Delivery cost should be 20% on the first 1000g and 10% on the remaining weight over 1000g");
	}
	
}
