package be.syntra;

import be.syntra.cryptobank.Account;
import be.syntra.cryptobank.Bank;
import be.syntra.cryptobank.Client;

public class Main {
  public static void main(String[] args) {

    Bank cryptoBank = new Bank();
    //Create Bob
    Client bob = cryptoBank.addClient("Bob");
    Account bitcoin1 = cryptoBank.addAccount(bob,"Bitcoin");
    //and add money to it
    cryptoBank.deposit(bitcoin1,1000.0);
    //Create an Ethereum account
    Account ethereum1 = cryptoBank.addAccount(bob,"Ethereum");
    cryptoBank.deposit(ethereum1,500.0);

    //Create Alice
    Client alice = cryptoBank.addClient("Alice");
    Account bitcoin2 = cryptoBank.addAccount(alice,"Bitcoin");
    cryptoBank.deposit(bitcoin2,250.0);
    Account ethereum2 = cryptoBank.addAccount(alice,"Ethereum");
    cryptoBank.deposit(ethereum2,250.0);

    //print initial state
    System.out.println(cryptoBank);

    cryptoBank.transferCoins(bitcoin1,bitcoin2,500.0);
    cryptoBank.transferAccount(bitcoin1,alice);
    cryptoBank.withdraw(bitcoin1,250.0);
    cryptoBank.transferCoins(bitcoin1, ethereum1, 250);
    System.out.println(cryptoBank);

  }
}