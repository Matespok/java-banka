package transfers;

import accounts.BankAccount;

public class TransferService {

  TransactionFactory factory;

  public void transferMoney(double amount, BankAccount from, BankAccount to) {
    if (amount <= 0) {
      System.out.println("Positive amount only");
      return;
    }
    try {
      from.substract(amount);
      to.add(amount);
      factory.createTransaction(from, to, amount);
      System.out.println("Transfer successful!");

    } catch (ArithmeticException e) {
      System.out.println("Transfer failed: " + e.getMessage());
    }
  }
}
