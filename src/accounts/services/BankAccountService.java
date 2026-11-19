package accounts.services;

import accounts.*;
import people.*;

public class BankAccountService implements IBankAccountService {
  private final BankAccountFactory factory;

  public BankAccountService(BankAccountFactory factory) {
    this.factory = factory;
  }

  @Override
  public BankAccount createStudentAccount(AccountOwner owner, String school) {
    return factory.createStudentAccount(owner, school);
  }

  @Override
  public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee) {
    return factory.createBusinessAccount(owner, withdrawFee);
  }

  @Override
  public BankAccount createCurrentAccount(AccountOwner owner, double overdraftLimit) {
    return factory.createCurrentAccount(owner, overdraftLimit);
  }
}
