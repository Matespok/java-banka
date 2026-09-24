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

  @Override
  public void substract(double amount) {
    double newBalance = this.balance - (amount * 1.01);
    if (newBalance < 0) {
      throw new ArithmeticException("Insufficient balance");
    }
    this.balance = newBalance;
  }
}
