package entities;

import exception.DomainException;

public class Account {

    private Integer numberAccount;
    private String holderAccount;
    private Double balance;
    private static Double withDrawLimit = 250.00;

    public Account() {
    }

    public Account(Integer numberAccount, String holderAccount, Double initialDeposit) {
        this.numberAccount = numberAccount;
        this.holderAccount = holderAccount;
        this.balance = 0.0;
        deposit(initialDeposit);
    }

    public Double getBalance() {
        return balance;
    }

    public static Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public String getHolderAccount() {
        return holderAccount;
    }

    public void setHolderAccount(String holderAccount) {
        this.holderAccount = holderAccount;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Integer numberAccount) {
        this.numberAccount = numberAccount;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withDraw(Double amount) {
        if (amount > withDrawLimit) {
            throw new DomainException("The withdrawal limit is R$ " + String.format("%.2f", withDrawLimit));
        }

        if (amount > balance) {
            throw new DomainException("The account balance is insufficient.");
        }
        balance -= amount;
    }
}
