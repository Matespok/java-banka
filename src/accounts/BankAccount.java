package accounts;

import notifiers.*;
import people.*;
import currency.*;

public class BankAccount {
  private String uuid;
  private String accountNumber;
  private AccountOwner owner;
  protected double balance;
  private ConsoleNotifier notifier;
  private Currency currency;

  public BankAccount(AccountOwner owner, double balance) {
    this.owner = owner;
    this.balance = balance;
    this.currency = Currency.CZK;
  }

  public BankAccount(AccountOwner owner, String accountNumber, String uuid) {
    this(owner, accountNumber, uuid, Currency.CZK);
  }

  public BankAccount(AccountOwner owner, String accountNumber, String uuid, Currency currency) {
    this.owner = owner;
    this.accountNumber = accountNumber;
    this.uuid = uuid;
    this.currency = currency;
  }

  public BankAccount(AccountOwner owner) {
    this.owner = owner;
    this.balance = 0;
    this.currency = Currency.CZK;
  }

  public Currency getCurrency() {
    return this.currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void add(double amount) {
    this.balance += amount;
  }

  public void substract(double amount) {
    double newBalance = this.balance - amount;
    if (newBalance < 0) {
      throw new ArithmeticException("Insufficient balance");
    }
    this.balance = newBalance;
  }
}
