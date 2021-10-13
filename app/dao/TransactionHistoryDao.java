package dao;

import models.TransactionHistory;

public class TransactionHistoryDao {

    public static void saveTransactionHistory(TransactionHistory transactionHistory)
    {
        DbConnector.save(transactionHistory);
    }
}
