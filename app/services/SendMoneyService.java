package services;

import dao.TransactionHistoryDao;
import dto.SendMoneyRequest;
import dto.SendMoneyResponse;
import models.TransactionHistory;
import models.TransactionType;
import org.joda.time.DateTime;

public class SendMoneyService {

    public static SendMoneyResponse saveMoneyDetails(SendMoneyRequest sendMoneyRequest)
    {
        SendMoneyResponse sendMoneyResponse = new SendMoneyResponse();

        try{
//            User user = User.find.byId(sendMoneyRequest.getUserID());
            TransactionHistory transactionHistory = new TransactionHistory();
            transactionHistory.setUserId(sendMoneyRequest.getUserID());
            transactionHistory.setIfsc(sendMoneyRequest.getIfsc());
            transactionHistory.setMerchant(sendMoneyRequest.getMerchantAccountNo());
            transactionHistory.setAmount(sendMoneyRequest.getAmount());
            transactionHistory.setTransactionType(TransactionType.getInstance
                    (TransactionType.transactionTypeEnum.DEBIT.gettId()));
            transactionHistory.setDateTime(new DateTime());

            TransactionHistoryDao.saveTransactionHistory(transactionHistory);

            sendMoneyResponse.setStatusCode(200);
            sendMoneyResponse.setStatusName("Money Transferred successfully");
        }
        catch (Exception exception)
        {
            sendMoneyResponse.setStatusCode(400);
            sendMoneyResponse.setStatusName("Oops seems likes there's an error" + exception);
            return sendMoneyResponse;
        }
        return sendMoneyResponse;
    }
}
