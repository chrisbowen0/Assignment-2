package sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestTransaction {

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new Transaction(1000) {
        };
    }

    @Test
    void testGenerateID() {
        String transactionID = transaction.getTransactionID();
        assertTrue(transactionID.startsWith("AST-"), "Transaction ID should start with 'AST-'");
        assertTrue(transactionID.length() > 4, "Transaction ID should include numbers after the prefix of 'AST-'");
    }

    @Test
    void testGetValue() {
        assertEquals(1000, transaction.getValue(), "getValue() should return the correct value of 1000");
    }

    @Test
    void testSetValue() {
        transaction.setValue(500);
        assertEquals(500, transaction.getValue(), "Value should be updated to the 500");
    }

}
	

