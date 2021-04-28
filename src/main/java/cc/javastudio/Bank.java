package cc.javastudio;

import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String,Client> clients= new HashMap<>();
    private HashMap<String,Account> accounts= new HashMap<>();

    private  String generatetUid(int length) {
        String s = "";
        Random rand = new Random();
        for (int i = 0; i<length; i++) {
            s += rand.nextInt();
        }
        return s;
    }

    public Client addClient() {
        String key;
        do {
            key = generatetUid(9);
        } while (clients.get(key) != null);
        Client client = new Client("Alice", key);
        clients.put(key,client);
        return client;
    }

    public Account addAccount(Client client) {
        String key;
        do {
            key = generatetUid(9);
        } while (accounts.get(key) != null);
        Account account = new Account(client);
        accounts.put(key,account);
        return account;
    }

}
