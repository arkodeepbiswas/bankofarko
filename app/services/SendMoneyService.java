package services;

import dao.TransactionHistoryDao;
import dto.SendMoneyRequest;
import dto.SendMoneyResponse;
import models.TransactionHistory;
import models.TransactionType;
import org.joda.time.DateTime;

import java.util.regex.Pattern;

public class SendMoneyService {

    public static SendMoneyResponse saveMoneyDetails(SendMoneyRequest sendMoneyRequest)
    {
        SendMoneyResponse sendMoneyResponse = new SendMoneyResponse();

        try{
            boolean amount = Pattern.matches("[0-9]{1,10}",sendMoneyRequest.getAmount().toString());
            if (!amount){
                sendMoneyResponse.setStatusName("Please enter correct amount");
                return sendMoneyResponse;
            }
            boolean accountNo = Pattern.matches("[0-9]{8}",sendMoneyRequest.getMerchantAccountNo().toString());
            if (!accountNo){
                sendMoneyResponse.setStatusName("Please enter correct account no");
                return sendMoneyResponse;
            }
            boolean ifsc = Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]",sendMoneyRequest.getIfsc());
            if (!ifsc){
                sendMoneyResponse.setStatusName("Please enter correct ifsc");
                return sendMoneyResponse;
            }

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
