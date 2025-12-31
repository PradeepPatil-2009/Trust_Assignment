package com.example.serverapp.xml;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "TxnRequestXml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionXml {

    @NotBlank(message = "TrxId is required")
    @XmlElement(name = "TrxId", required = true)
    @JsonProperty("TrxId")
    private String trxId;

  
  //  @JsonProperty("Stan")
  //  private String stan;

    @NotBlank(message = "Bank ID is required")
    @XmlElement(name = "BankId", required = true)
    @JsonProperty("BankId")
    private String bankId;

    @NotNull(message = "Customer ID must not be null")
    @XmlElement(name = "CustomerId", required = true)
    @JsonProperty("CustomerId")
    private Long customerId;

    @NotBlank(message = "FromAccount must not be empty")
    @XmlElement(name = "FromAccount", required = true)
    @JsonProperty("FromAccount")
    private String fromAccount;

    @NotBlank(message = "ToAccount must not be empty")
    @XmlElement(name = "ToAccount", required = true)
    @JsonProperty("ToAccount")
    private String toAccount;

    @NotNull(message = "Amount must not be null")
    @XmlElement(name = "Amount", required = true)
    @JsonProperty("Amount")
    private Double amount;

    @XmlElement(name = "Currency")
    @JsonProperty("Currency")
    private String currency;

    @XmlElement(name = "Timestamp")
    @JsonProperty("Timestamp")
    private OffsetDateTime timestamp;

    // ================= Getters & Setters =================

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

  /*  public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }
    */

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }
}