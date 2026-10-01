package accounts;

import notifiers.*;
import people.*;

public class BankAccount {
  private String uuid;
  private String accountNumber;
  private AccountOwner owner;
  protected double balance;
  private ConsoleNotifier notifier;

  public BankAccount(AccountOwner owner, double balance) {
    this.owner = owner;
    this.balance = balance;
  }

  public BankAccount(AccountOwner owner, String accountNumber, String uuid) {
    this.owner = owner;
    this.accountNumber = accountNumber;
    this.uuid = uuid;
  }

  public BankAccount(AccountOwner owner) {
    this.owner = owner;
    this.balance = 0;
  }

  public double getBalance() { return this.balance; }

  public void setBalance(double balance) { this.balance = balance; }

  public void add(double amount) { this.balance += amount; }

  public void substract(double amount) {
    double newBalance = this.balance - amount;
    if (newBalance < 0) {
      throw new ArithmeticException("Insufficient balance");
    }
    this.balance = newBalance;
  }
}
