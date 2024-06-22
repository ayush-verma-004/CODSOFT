package org.codsoft.currencyconverter.model;


import java.math.BigDecimal;

public class CurrencyConversionResponse {

    private String from;
    private String to;
    private BigDecimal originalAmount;
    private BigDecimal convertedAmount;

    public CurrencyConversionResponse(String from, String to, BigDecimal originalAmount, BigDecimal convertedAmount) {
        this.from = from;
        this.to = to;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
    }

    // Getters
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }
}