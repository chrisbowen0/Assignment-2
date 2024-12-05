package sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class TestRefund {

	private Refund refund;
	
	//setup refund with positive value
	@BeforeEach
	void setup() {
		
	}
	
	//test to check value
	@Test
	public void testValue() {
		//initial test to make sure the value is set correctly
		assertEquals(100, refund.getValue(), "Refund value should be 100");
	}
	
	//test to check refund
	@Test
	public void testRefund() {
		//Apply a reason and ensure the value is negative
		refund.refundItem();
		assertEquals(-100, refund.getValue(), "Refund value should be set to -100");
		assertEquals("Incorrect fit for customer", refund.getReason(), "Reason should match the input reason");
	}
	
	
}
