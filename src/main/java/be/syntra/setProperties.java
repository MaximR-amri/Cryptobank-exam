package be.syntra;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class setProperties {
    public static void main(String[] args) {
        try(OutputStream output = new FileOutputStream("src/main/resources/rates.properties")){
            Properties prop = new Properties();

            prop.setProperty("bitcoin", "48550.27");
            prop.setProperty("ethereum", "2634.52");

            prop.store(output, "exchange rates added for bitcoin and ethereum");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
