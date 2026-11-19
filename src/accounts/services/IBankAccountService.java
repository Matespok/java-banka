package accounts.services;

import accounts.BankAccount;
import people.AccountOwner;

public interface IBankAccountService {
  BankAccount createStudentAccount(AccountOwner owner, String school);

  BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee);

  BankAccount createCurrentAccount(AccountOwner owner, double overdraftLimit);

}
