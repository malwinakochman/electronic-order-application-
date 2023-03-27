package pl.Kochman.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("2403-0404");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignDifferentCreditLimits() {
        //Arrange
        CreditCard card1 = new CreditCard("2413-0404");
        CreditCard card2 = new CreditCard("2422-0404");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert
        assert card1.getBalance().equals(BigDecimal.valueOf(1000));
        assert card2.getBalance().equals(BigDecimal.valueOf(1100));
    }

    @Test
    void itCantAssignLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5278");
        CreditCard card3 = new CreditCard("1234-5648");

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10)));
        assertThrows(
                CreditBelowThresholdException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(
                () -> card3.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void itCantAssignLimitBelow100V1() {
        CreditCard card = new CreditCard("1234-5678");
        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }

    }

    @Test
    void cardAssignmentTest() {
        CreditCard card = new CreditCard("2334-1234");

        assertDoesNotThrow(
                () -> card.assignCredit(BigDecimal.valueOf(100)));

        assertThrows(
                LimitWasAlreadyAssignedException.class,
                () -> card.assignCredit(BigDecimal.valueOf(110)));

    }

    @Test
    void itAllowsToWithdraw() {
        CreditCard card = new CreditCard("2334-1234");

        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(900), card.getBalance());
    }






}
