package accounts;

import people.*;

public class SavingsAccount extends BankAccount {
  private double interest;

  public SavingsAccount(AccountOwner owner, double interest,
                        double initBalance) {
    super(owner, initBalance);
    this.interest = interest;
  }

  public SavingsAccount(AccountOwner owner, double interest) {
    super(owner);
    this.interest = interest;
  }

  @Override
  public void add(double amount) {
    double newBalance = this.balance + amount * (interest + 1);
    this.balance = newBalance;
  }
}
