package be.syntra.cryptobank;


import java.util.Locale;

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

    boolean checkBalance(Double coins){
        return this.coins - coins >= 0 ? true : false;
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

    public String getCurrency() {
        return currency;
    }

    double getEuroValue(){
        double euroValue;
        switch(currency.toLowerCase()){
            case "ethereum":
                euroValue = (coins * ExchangeRates.getEthereumRate());
                break;
            default:
                euroValue = (coins * ExchangeRates.getBitcoinRate());
        }
        return euroValue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", owner=" + owner +
                ", coins=" + coins +
                ", value=" + getEuroValue() +
                '}';
    }
}

