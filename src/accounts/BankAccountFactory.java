package accounts;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import currency.Currency;
import people.AccountOwner;

public class BankAccountFactory {
  public static String generateRandomNumber() {
    var r = ThreadLocalRandom.current();

    long account = r.nextLong(100_000_000L, 1_000_000_000L); // 9 číslic
    int bank = r.nextInt(100, 9999); // kód banky

    return String.format("%09d/%04d", account, bank);
  }

  public BankAccount createSavingBankAccount(AccountOwner owner,
      double interest) {
    return createSavingBankAccount(owner, interest, Currency.CZK);
  }

  public BankAccount createSavingBankAccount(AccountOwner owner,
      double interest, Currency currency) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new SavingsAccount(owner, interest, uuid, accountNumber, currency);
  }

  public BankAccount createCurrentAccount(AccountOwner owner,
      double overdraftLimit) {
    return createCurrentAccount(owner, overdraftLimit, Currency.CZK);
  }

  public BankAccount createCurrentAccount(AccountOwner owner,
      double overdraftLimit, Currency currency) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new CurrentAccount(uuid, accountNumber, owner, overdraftLimit, currency);
  }

  public BankAccount createSavingsAccount(AccountOwner owner, double interest) {
    return createSavingsAccount(owner, interest, Currency.CZK);
  }

  public BankAccount createSavingsAccount(AccountOwner owner, double interest, Currency currency) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new SavingsAccount(owner, interest, uuid, accountNumber, currency);
  }

  public BankAccount createStudentAccount(AccountOwner owner, String school) {
    return createStudentAccount(owner, school, Currency.CZK);
  }

  public BankAccount createStudentAccount(AccountOwner owner, String school, Currency currency) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new StudentAccount(owner, uuid, accountNumber, school, currency);
  }

  public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee) {
    return createBusinessAccount(owner, withdrawFee, Currency.CZK);
  }

  public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee, Currency currency) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new BusinessAccount(owner, withdrawFee, uuid, accountNumber, currency);
  }
}
