package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "transaction_type")
public class TransactionType {

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Id
    @Column(name = "trans_id")
    private Integer transId;

    @Column(name = "trans_type")
    private String transType;


    public enum transactionTypeEnum {
        CREDIT(1),  DEBIT(2);
        private Integer tId;
        public Integer gettId() {
            return tId;
        }

        transactionTypeEnum(Integer id){
            this.tId = id;
        }

    }

    public  static  TransactionType getInstance(Integer id) {

        TransactionType transactionType = new TransactionType();
        transactionType.setTransId(id);
        return transactionType;

    }
    public static final Finder<Integer, TransactionType> find = new Finder<>(TransactionType.class);



}
