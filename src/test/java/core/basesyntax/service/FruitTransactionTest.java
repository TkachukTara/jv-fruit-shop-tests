package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTransactionTest {
    @Test
    void setOperation_setsOperationCorrectly() {
        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "Apple", 10);
        fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
        assertEquals(FruitTransaction.Operation.SUPPLY, fruitTransaction.getOperation());
    }

    @Test
    void setFruit_setsFruitCorrectly() {
        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "Apple", 10);
        fruitTransaction.setFruit("Banana");
        assertEquals("Banana", fruitTransaction.getFruit());
    }

    @Test
    void setQuantity_setsQuantityCorrectly() {
        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "Apple", 10);
        fruitTransaction.setQuantity(5);
        assertEquals(5, fruitTransaction.getQuantity());
    }

    @Test
    void getByCode_returnsCorrectOperation() {
        FruitTransaction.Operation expectedOperation = FruitTransaction.Operation.RETURN;
        FruitTransaction.Operation actualOperation = FruitTransaction.Operation.getByCode("r");
        assertEquals(expectedOperation, actualOperation);
    }

    @Test
    void getByCode_throwsRuntimeExceptionForUnknownOperation() {
        assertThrows(RuntimeException.class, () ->
                        FruitTransaction.Operation.getByCode("unknown"),
                "Expected RuntimeException but it was not thrown");
    }
}