package accounts;

import people.*;

public class SavingsAccount extends BankAccount {
  private double interest;

  public SavingsAccount(AccountOwner owner, double interest,
                        double initBalance) {
    super(owner, initBalance);
    this.interest = CountInterest(interest);
  }

  public SavingsAccount(AccountOwner owner, double interest) {
    super(owner);
    this.interest = CountInterest(interest);
  }

  public double CountInterest(double interest) { return interest += 1; }

  @Override
  public void add(double amount) {
    double newBalance = this.balance + amount * interest;
    this.balance = newBalance;
  }
}
