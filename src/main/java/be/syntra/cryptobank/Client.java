package be.syntra.cryptobank;

import java.util.HashMap;
import java.util.Map;

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

    double getTotalAssetsValue(){
        double totalAssetValue = 0;
        for(Map.Entry<String, Account> entry : accounts.entrySet()){
            totalAssetValue += entry.getValue().getEuroValue();
        }
        return totalAssetValue;
    }
    @Override
    public String toString() {
        return "Client{" +
                "alias='" + alias + '\'' +
                ", Total Assets Value= " + getTotalAssetsValue() +
                ", accounts=" + prettyPrintMapKeys(accounts) +
                '}';
    }

    private String prettyPrintMapKeys(Map map) {
        String s = "";
        for (Object key : map.keySet()) {
            s += (key +",");
        }
        return s.replaceAll(",$", "");
    }
}
