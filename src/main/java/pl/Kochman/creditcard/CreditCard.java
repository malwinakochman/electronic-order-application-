package pl.Kochman.creditcard;

import java.math.BigDecimal;

public class CreditCard {

    private BigDecimal balance;


    public CreditCard(String cardNumber) {
    }
    private boolean isAssigned = false;
    public void assignCredit(BigDecimal creditAmount) {
        if (creditAmount.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new CreditBelowThresholdException();
        }

        if (isAssigned == true){
            throw new LimitWasAlreadyAssignedException();
        }
        isAssigned = true;
        this.balance = creditAmount;


    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
    }
}
