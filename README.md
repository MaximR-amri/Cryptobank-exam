# *CRYPTOBANK*

### 1. Create ExchangeRates

Create class **ExchangeRates**. This class holds a private variable for each coin that represents the exhange rate to EURO.
(You can create other methods in this class if you need them)

eg. bitcoin =  47.314,01

### 2.  Account value

##### 2.1 create getEuroValue() in Account class 

Use this exchange rate to calculate the total value of each account (Create method getEuroValue() in Account class)

##### 2.2 Print this value 

Modify the Account toString() method to also print this value for each account

Example output:

Accounts:
Account{accountNumber='652445721', currency='Ethereum', owner=Bob, coins=500.0, **value=12035.0**}

### 3. Customer Total assets value

##### 3.1 create getTotalEuroValue() in Client class

Calculate the total assets value (sum of values of all accounts for each per client) 

Hint: https://www.geeksforgeeks.org/iterate-map-java/

##### 3.2 Print this value 

Modify the Account toString() method to also print this value for each client

Example Output:

796588302 = Client{alias='Alice', Total Assets Value=17777.5, Accounts=589338783,120119886}

### 4. transferCoins Method in Bank class

Modify this method so that transfers can be done between accounts of different currencies, based on the calculated value from the exchange rates.

#### 5. Optional, read the exchange rates from a "properties" file

(only for those who like a chalenge)

hint: https://mkyong.com/java/java-properties-file-examples/





