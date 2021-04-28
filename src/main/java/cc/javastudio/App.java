package cc.javastudio;

public class App {

  public static void main(String[] args) {
    Bank cryptoBank = new Bank();
    Client client = cryptoBank.addClient();
    Account account = cryptoBank.addAccount(client);




    //System.out.println(client1.toString());



  }
}