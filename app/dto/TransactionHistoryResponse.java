package dto;

import java.util.Date;

public class TransactionHistoryResponse {

        private Integer userId;
        private Integer transactionId;
        private String amount;
        private Date date_time;
        private String merchant_acc_no;
        private String t_type;
        private String ifsc;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getMerchant_acc_no() {
        return merchant_acc_no;
    }

    public void setMerchant_acc_no(String merchant_acc_no) {
        this.merchant_acc_no = merchant_acc_no;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
}
