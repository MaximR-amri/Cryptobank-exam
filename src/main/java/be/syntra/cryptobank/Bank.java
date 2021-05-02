package be.syntra.cryptobank;



import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


public class Bank {
    //Create empty Accounts List
    HashMap<String,Account> accounts = new HashMap<>();
    //Create empty Client List
    HashMap<String,Client> clients = new HashMap<>();

    // Add (Create) a new client to the bank,
    // Returns (a reference to) the new client Object.
    public Client addClient(String alias) {
        String clientNumber;
        do {
            clientNumber  = generateUid(9);
        } while (clients.get(clientNumber) != null);

        Client client = new Client(alias,clientNumber);
        clients.put(clientNumber, client);
        return client;
    }

    // Add (create) a new account to an existing client)
    // Returns (a reference to) the new account Object.
    public Account addAccount(Client client, String currency) {
        String accountNumber;
        do {
            accountNumber  = generateUid(9);
        } while (clients.get(accountNumber) != null);
        Account account = new Account(client,accountNumber,currency);

        accounts.put(accountNumber, account);
        client.addAccount(account);
        return account;
    }

    // Transfers coins from one account to another
    // Check if the accounts have the same cryptocurrency
    public void transferCoins(Account origin, Account destination, double coins) {
        if (!destination.equalCurrency(origin)) {
            throw new UnsupportedOperationException("Currencies or not the same");
        }
        origin.widraw(coins);
        destination.deposit(coins);
    }

    // Transfers an account to a new owner
    public void transferAccount(Account account, Client newOwner) {
        Client owner = account.getOwner();
        account.setOwner(newOwner);
        owner.removeAccount(account);
        newOwner.addAccount(account);
    }

    // Add coins to an account
    public void deposit(Account account, Double coins) {
        account.deposit(coins);
    }

    // Withdraw coins from an account
    public void withdraw(Account account, Double coins) {
        account.widraw(coins);
    }

    //Helper method, create unique ID's
    private String generateUid(int l) {
        String s = "";
        Random random = new Random();
        for (int i = 0; i < l; i++){
            s += random.nextInt(10);
        }
        return s;
    }

    @Override
    public String toString() {
        return "\n**Bank**\n" +
               "Clients:\n" + prettyPrintMap(clients) +
               "\nAccounts:\n" + prettyPrintMap(accounts);
    }

    private String prettyPrintMap(Map map) {
        String s = "";
        for (Object key : map.keySet()) {
            s += (key + " = " + map.get(key)) +"\n";
        }
        return s.replaceAll("\\s+$", "");
    }
}
