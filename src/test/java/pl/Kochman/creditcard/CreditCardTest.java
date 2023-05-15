package pl.Kochman.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert // Then

        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert // Then
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());
    }

//    @Test
//    void itDenyCreditLimitBelow100v1() {
//        CreditCard card = new CreditCard("1234-4567");
//
//        try {
//            card.reassignLimit(BigDecimal.valueOf(50));
//            fail("Should throw exception");
//        } catch (CreditBelowThresholdException e) {
//            assertTrue(true);
//        }
//    }

    @Test
    void itDenyCreditLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-5678");

        CreditCard card = new CreditCard("1234-4567");

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.reassignLimit(BigDecimal.valueOf(10)));

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.reassignLimit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(
                () -> card.reassignLimit(BigDecimal.valueOf(100)));


    }

    @Test
    void itCantAssignLimitTwice() {
        CreditCard card = new CreditCard("1234-4567");

        card.assignLimit(BigDecimal.valueOf(1000));

        assertThrows(
                LimitAssignedTwiceException.class,
                () -> card.assignLimit(BigDecimal.valueOf(1100))
        );
    }

    @Test
    void itAllowsToWithdraw() {
        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignCredit(BigDecimal.valueOf(1000));
        card1.withdraw(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(900), card1.getBalance());
    }
}