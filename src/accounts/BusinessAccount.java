package accounts;

import people.*;

public class BusinessAccount extends BankAccount {
  private double withdrawFee;

  public BusinessAccount(AccountOwner owner, double initBalance,
                         double withdrawFee) {
    super(owner, initBalance);
    this.withdrawFee = withdrawFee;
  }

  public BusinessAccount(AccountOwner owner, double withdrawFee) {
    super(owner);
    this.withdrawFee = withdrawFee;
  }

  public BusinessAccount(AccountOwner owner, double withdrawFee, String uuid,
                         String accountNumber) {
    super(owner, accountNumber, uuid);
    this.withdrawFee = withdrawFee;
  }

  public double getFee() { return this.withdrawFee; }

  @Override
  public void substract(double amount) {
    double total = amount + (amount * this.withdrawFee);
    double newBalance = this.balance - total;
    if (newBalance < 0) {
      throw new ArithmeticException("Insufficient balance");
    }
    this.balance = newBalance;
  }
}
