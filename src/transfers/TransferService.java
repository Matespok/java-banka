package transfers;

import accounts.BankAccount;

public class TransferService {

  TransactionFactory factory;

  public TransferService(TransactionFactory factory) {
    this.factory = factory;
  }

  public void transferMoney(double amount, BankAccount from, BankAccount to) {
    if (amount <= 0) {
      System.out.println("Positive amount only");
      return;
    }
    try {
      from.substract(amount);
      double convertedAmount = from.getCurrency().convertTo(amount, to.getCurrency());
      to.add(convertedAmount);
      factory.createTransaction(from, to, amount);
      System.out.println("Transfer successful! (" + amount + " " + from.getCurrency() + " -> " + convertedAmount + " " + to.getCurrency() + ")");

    } catch (ArithmeticException e) {
      System.out.println("Transfer failed: " + e.getMessage());
    }
  }

}
