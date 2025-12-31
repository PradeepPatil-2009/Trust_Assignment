package com.example.clientapp1.pojo;


public class TransactionResponse {
    private String trxId;
    private int stan;
    private String status;
    private String message;
	public TransactionResponse(String trxId, int stan, String status, String message) {
		super();
		this.trxId = trxId;
		this.stan = stan;
		this.status = status;
		this.message = message;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
