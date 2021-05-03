package be.syntra.cryptobank;

public class ExchangeRates {


    private static Double bitcoinRate;
    private static Double ethereumRate;

    public static void setBitcoinRate(Double bitcoinRate) {
        ExchangeRates.bitcoinRate = bitcoinRate;
    }

    public static void setEthereumRate(Double ethereumRate) {
        ExchangeRates.ethereumRate = ethereumRate;
    }

    public static Double getBitcoinRate() {
        return bitcoinRate;
    }

    public static Double getEthereumRate() {
        return ethereumRate;
    }

    public static Double euroValueEthereum(Double coins){
        return coins*ethereumRate;
    }
    public static Double euroValueBitcoin(Double coins){
        return coins*bitcoinRate;
    }

    public static Double toEuro(Double coins, String currency){
        double euroValue = 0;
        switch (currency.toLowerCase()){
            case "ethereum":
                euroValue = euroValueEthereum(coins);
                break;
            default:
                euroValue = euroValueBitcoin(coins);
        }
        return euroValue;
    }
    public static Double toCrypto(Double euro, String currency){
        double coins;
        switch (currency.toLowerCase()){
            case "ethereum":
                coins = euro / ethereumRate;
            default:
                coins = euro / bitcoinRate;
        }
        return coins;
    }
}
