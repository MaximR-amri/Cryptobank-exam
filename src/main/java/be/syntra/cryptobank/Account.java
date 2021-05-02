package be.syntra.cryptobank;


public class Account {
    private String accountNumber;
    private String currency;
    private Client owner;
    private double coins;

    Account(Client owner, String accountNumber, String currency) {
        this.currency = currency;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    boolean equalCurrency(Account other) {
        return currency.equals(other.currency);
    }

    void deposit(Double coins) {
        this.coins += coins;
    }

    void widraw(Double coins) {
        this.coins -= coins;
    }

    String getAccountNumber() {
        return accountNumber;
    }

    void setOwner(Client owner) {
        this.owner = owner;
    }

    Client getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", owner=" + owner.getAlias() +
                ", coins=" + coins +
                '}';
    }
}

