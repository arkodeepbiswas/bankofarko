package models;

import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity(name = "transaction_history")
public class TransactionHistory {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private Integer userId;

    @Column(name = "ifsc")
    private String ifsc;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "date_time")
    private DateTime dateTime;

    @Column(name = "merchant_acc_no")
    private Integer merchant;

    @ManyToOne
    @JoinColumn(name = "t_id", referencedColumnName = "trans_id")
    private TransactionType transactionType;


    public static final Finder<Integer, TransactionHistory> find = new Finder<>(TransactionHistory.class);

}
