package com.example.serverapp.pojo;

public class TransactionResponse {

    private String trxId;
  //  private String stan;
    private String status;
    private String reason;
    private long processingTimeMs;
    private String bankId;

    public TransactionResponse() {
    }

    public TransactionResponse(
            String trxId,
          //  String stan,
            String status,
            String reason,
            long processingTimeMs,
            String bankId) {

        this.trxId = trxId;
    //    this.stan = stan;
        this.status = status;
        this.reason = reason;
        this.processingTimeMs = processingTimeMs;
        this.bankId = bankId;
    }

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

  */  public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(long processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}
