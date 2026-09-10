package accounts;

import people.*;

public class CurrentAccount extends BankAccount {

  public CurrentAccount(AccountOwner owner, double initBalance,
                        double overdraftLimit) {
    super(owner, initBalance);
  }

  public CurrentAccount(AccountOwner owner, double overdraftLimit) {
    super(owner);
  }
}
