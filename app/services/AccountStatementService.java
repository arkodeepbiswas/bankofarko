package services;

import dto.AccountStatementRequest;
import dto.AccountStatementResponse;
import models.TransactionHistory;

import java.util.ArrayList;
import java.util.List;

public class AccountStatementService {

    public static List<AccountStatementResponse> renderAccountStatement(AccountStatementRequest accountStatementRequest)
    {
        List<AccountStatementResponse> accountStatementResponseList = new ArrayList<AccountStatementResponse>();

        try
        {
            AccountStatementResponse accountStatementResponse = new AccountStatementResponse();

            List<TransactionHistory> transactionHistoryList = TransactionHistory.find.query().where()
                    .eq("user_id", accountStatementRequest.getUserId()).findList();

            if (transactionHistoryList.size() == 0)
            {
                accountStatementResponse.setStatusCode(414);
                accountStatementResponse.setStatusName("No transactions found...");
                accountStatementResponseList.add(accountStatementResponse);
                return accountStatementResponseList;
            }

            for (TransactionHistory transactionHistory : transactionHistoryList)
            {
                AccountStatementResponse accountStatementResponse1 = new AccountStatementResponse();

                accountStatementResponse1.setTransId(transactionHistory.getId());
                accountStatementResponse1.setMerchant(transactionHistory.getMerchant());
                accountStatementResponse1.setAmount(transactionHistory.getAmount());
                accountStatementResponse1.setDate(transactionHistory.getDateTime().toString());
                accountStatementResponse1.setTransactionType(transactionHistory.getTransactionType().getTransType());
                accountStatementResponse1.setStatusCode(200);
                accountStatementResponse1.setStatusName("Transaction history is shown....");
                accountStatementResponseList.add(accountStatementResponse1);
            }
        }
        catch (Exception exception)
        {
            AccountStatementResponse accountStatementResponse = new AccountStatementResponse();
            accountStatementResponse.setStatusCode(500);
            accountStatementResponse.setStatusName("Oops looks likes there's an error" + exception);
            accountStatementResponseList.add(accountStatementResponse);
            return accountStatementResponseList;
        }

        return accountStatementResponseList;
    }

}
