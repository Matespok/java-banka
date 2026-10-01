package accounts;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import people.AccountOwner;

public class BankAccountFactory {
  public static String generateRandomNumber() {
    var r = ThreadLocalRandom.current();

    long account = r.nextLong(100_000_000L, 1_000_000_000L); // 9 číslic
    int bank = r.nextInt(100, 9999);                         // kód banky

    return String.format("%09d/%04d", account, bank);
  }

  public BankAccount createSavingBankAccount(AccountOwner owner,
                                             double interest) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new SavingsAccount(owner, interest, uuid, accountNumber);
  }

  public BankAccount createCurrentBankAccount(AccountOwner owner,
                                              double overdraftLimit) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new CurrentAccount(uuid, accountNumber, owner, overdraftLimit);
  }

  public BankAccount createSavingsAccount(AccountOwner owner, double interest) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new SavingsAccount(owner, interest, uuid, accountNumber);
  }

  public BankAccount createStudentAccount(AccountOwner owner, String school) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new StudentAccount(owner, uuid, accountNumber, school);
  }

  public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee) {
    String uuid = UUID.randomUUID().toString();
    String accountNumber = generateRandomNumber();

    return new BusinessAccount(owner, withdrawFee, uuid, accountNumber);
  }
}
