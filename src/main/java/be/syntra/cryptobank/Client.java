package be.syntra.cryptobank;

import java.util.HashMap;

public class Client {
    private String clientNumber;
    private String alias;
    private HashMap<String,Account> accounts = new HashMap<>();

    Client(String alias, String clientNumber) {
        this.alias = alias;
        this.clientNumber = clientNumber;
    }

    void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    String getAlias() {
        return alias;
    }

    void removeAccount(Account account) {
        accounts.remove(account.getAccountNumber());
    }

    @Override
    public String toString() {
        return "Client{" +
                "alias='" + alias + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
