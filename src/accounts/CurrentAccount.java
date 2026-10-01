package accounts;

import people.*;

public class CurrentAccount extends BankAccount {

  private Double overdraftLimit;

  public CurrentAccount(AccountOwner owner, double initBalance,
                        double overdraftLimit) {
    super(owner, initBalance);
    this.overdraftLimit = overdraftLimit;
  }

  public CurrentAccount(AccountOwner owner, Double overdraftLimit) {
    super(owner);
    this.overdraftLimit = overdraftLimit;
  }

  public CurrentAccount(String uuid, String accountNumber, AccountOwner owner,
                        double overdraftLimit) {
    super(owner, accountNumber, uuid);
    this.overdraftLimit = overdraftLimit;
  }
}
