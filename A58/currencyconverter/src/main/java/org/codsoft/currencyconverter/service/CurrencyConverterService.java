package  org.codsoft.currencyconverter.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CurrencyConverterService {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/{base}";

    public BigDecimal convertCurrency(String fromCurrency, String toCurrency, BigDecimal amount) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("base", fromCurrency);

        String url = UriComponentsBuilder.fromUriString(API_URL).buildAndExpand(uriVariables).toString();
        
        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response == null || !response.containsKey("rates")) {
                throw new RuntimeException("Invalid response from currency API");
            }

            Map<String, Double> rates = (Map<String, Double>) response.get("rates");
            if (rates == null || !rates.containsKey(toCurrency)) {
                throw new RuntimeException("Invalid currency code: " + toCurrency);
            }

            BigDecimal rate = BigDecimal.valueOf(rates.get(toCurrency));
            return amount.multiply(rate);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching conversion rate", e);
        }
    }
}
