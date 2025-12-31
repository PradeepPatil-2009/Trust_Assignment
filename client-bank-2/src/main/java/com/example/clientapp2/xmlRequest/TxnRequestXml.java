package com.example.clientapp2.xmlRequest;
import java.time.OffsetDateTime;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "TxnRequestXml")
@XmlAccessorType(XmlAccessType.FIELD)

public class TxnRequestXml {
	    @XmlElement(name = "TrxId")
	    private String trxId;

	    @XmlElement(name = "Stan")
	    private int stan;
	    
	    @XmlElement(name = "BankId")
	    private String bankId;

	    @XmlElement(name = "CustomerId")
	    private Long customerId;

	    @XmlElement(name = "FromAccount")
	    private String fromAccount;

	    @XmlElement(name = "ToAccount")
	    private String toAccount;

	    @XmlElement(name = "Amount")
	    private Double amount;

	    @XmlElement(name = "Currency")
	    private String currency;

	//    @XmlElement(name = "Timestamp")
	//    private OffsetDateTime timestamp;
	    @XmlElement(name = "Timestamp")
	    @XmlJavaTypeAdapter(OffsetDateTimeAdapter.class)
	    private OffsetDateTime timestamp;
	    
		public String getTrxId() {
			return trxId;
		}

		public void setTrxId(String trxId) {
			this.trxId = trxId;
		}

		public int getStan() {
			return stan;
		}

		public void setStan(int stan) {
			this.stan = stan;
		}

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

		public void setTimestamp(OffsetDateTime timestamp) {
			this.timestamp = timestamp;
		}

		
	

}
