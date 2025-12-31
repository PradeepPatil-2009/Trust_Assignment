package com.example.clientapp1.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class TransactionRequest {

    @NotNull(message = "CustomerId is required")
    private Long customerId;

    
    private int stan;

    @NotBlank(message = "FromAccount is required")
    private String fromAccount;

    @NotBlank(message = "To Account is required")   
    private String toAccount;

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotBlank(message = "Currency is required")
    @Pattern(regexp = "INR|USD|EUR", message = "Invalid currency. Allowed: INR, USD, EUR")
    private String currency;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
