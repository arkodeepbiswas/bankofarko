package dto;

import java.util.Date;

public class SendMoneyRequest {

    private Integer userID;
    private Integer merchantAccountNo;
    private String ifsc;
    private Integer amount;
    private Integer transactionType;
    private Date transactionTime;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getMerchantAccountNo() {
        return merchantAccountNo;
    }

    public void setMerchantAccountNo(Integer merchantAccountNo) {
        this.merchantAccountNo = merchantAccountNo;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }
}
