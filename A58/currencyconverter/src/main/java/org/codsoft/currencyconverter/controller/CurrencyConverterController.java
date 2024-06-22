package org.codsoft.currencyconverter.controller;



import org.codsoft.currencyconverter.model.CurrencyConversionResponse;
import org.codsoft.currencyconverter.service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @GetMapping("/convert")
    public CurrencyConversionResponse convertCurrency(@RequestParam String from,
                                                      @RequestParam String to,
                                                      @RequestParam BigDecimal amount) {
        BigDecimal convertedAmount = currencyConverterService.convertCurrency(from, to, amount);
        return new CurrencyConversionResponse(from, to, amount, convertedAmount);
    }
}