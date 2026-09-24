package accounts;

import people.*;

public class StudentAccount extends BankAccount {
  private String school;

  public StudentAccount(AccountOwner owner, double initBalance, String school) {
    super(owner, initBalance);
    this.school = school;
  }

  public StudentAccount(AccountOwner owner, String school) {
    super(owner);
    this.school = school;
  }

  @Override
  public void substract(double amount) {
    double newBalance = this.balance - amount;
    if (newBalance < -5000) {
      throw new ArithmeticException("Insufficient ballance");
    }
    this.balance = newBalance;
  }
}
