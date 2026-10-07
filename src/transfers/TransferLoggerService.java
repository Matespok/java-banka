package transfers;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {
  private List<Transaction> allTransfers = new ArrayList<>();

  public void logTransfer(Transaction transactionToLog) {
    allTransfers.add(transactionToLog);
    System.out.println(transactionToLog);
  }
}
