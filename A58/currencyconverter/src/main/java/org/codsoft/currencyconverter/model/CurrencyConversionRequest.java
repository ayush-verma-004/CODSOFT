package org.codsoft.currencyconverter.model;

import java.math.BigDecimal;

public class CurrencyConversionRequest {

    private String from;
    private String to;
    private BigDecimal amount;

    // Getters and Setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}