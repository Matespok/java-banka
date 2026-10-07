package transfers;

import accounts.BankAccount;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionFactory {

  /*
   * private final String uuid;
   * private final LocalDateTime timestamp;
   * private final BankAccount fromAccount;
   * private final BankAccount toAccount;
   * private final double amount;
   *
   */
  public Transaction createTransaction(BankAccount fromAccount,
                                       BankAccount toAccount, double amount) {
    String uuid = UUID.randomUUID().toString();
    LocalDateTime timestamp = LocalDateTime.now();

    return new Transaction(uuid, timestamp, fromAccount, toAccount, amount);
  }
}
