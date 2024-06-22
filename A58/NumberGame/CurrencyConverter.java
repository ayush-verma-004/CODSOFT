
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class CurrencyConverter {

    public static void mian(String args[]) {

        HashMap<Integer, String> code = new HashMap<Integer, String>();

        //Add currency code
        code.put(1, "USD");
        code.put(2, "CAD");
        code.put(3, "EUR");
        code.put(4, "HKD");
        code.put(5, "INR");

        String fromCode;
        String toCode;
        Double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the currency converter! ");

        System.out.println("Currency converting From");

        System.out.println("1:USD \t 2:CAD \t 3:EUR \t :HKD \t 5:INR");

        fromCode = code.get(sc.nextInt());

        System.out.println("Currency converting To");

        System.out.println("1:USD \t 2:CAD \t 3:EUR \t :HKD \t 5:INR");

        toCode = code.get(sc.nextInt());

        System.out.println("Amount you wish to convert ?");
        amount = sc.nextFloat();

        sendHttpGETRequest(fromCode, toCode, amount);

        System.out.println("Thank you for using the currency converter");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, Double amount) {
        String GET_URL = "https://api.exchangeratesapi.io/v1/latest?access_key=" + toCode + "&symbols=" + fromCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine));
            }in.close();
        }

        
    }
}
