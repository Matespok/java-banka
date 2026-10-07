package transfers;

import accounts.BankAccount;
import java.time.LocalDateTime;

// Premyslim, jestli pouzit record, nebo class..

public class Transaction {
  private final String uuid;
  private final LocalDateTime timestamp;
  private final BankAccount fromAccount;
  private final BankAccount toAccount;
  private final double amount;

  public Transaction(String uuid, LocalDateTime timestamp,
                     BankAccount fromAccount, BankAccount toAccount,
                     double amount) {
    this.uuid = uuid;
    this.timestamp = timestamp;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.amount = amount;
  }

  TransactionFactory factory;

  String getUuid() { return this.uuid; }

  LocalDateTime getTimestamp() { return this.timestamp; }

  BankAccount getFromAccount() { return this.fromAccount; }

  BankAccount getToAccount() { return this.toAccount; }

  double getAmount() { return this.amount; }
}
