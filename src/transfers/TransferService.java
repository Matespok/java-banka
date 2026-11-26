package transfers;

import accounts.BankAccount;
import currency.CurrencyService;

public class TransferService {

  TransactionFactory factory;
  CurrencyService currencyService;

  public TransferService(TransactionFactory factory, CurrencyService currencyService) {
    this.factory = factory;
    this.currencyService = currencyService;
  }

  public void transferMoney(double amount, BankAccount from, BankAccount to) {
    if (amount <= 0) {
      System.out.println("Positive amount only");
      return;
    }
    try {
      from.substract(amount);
      double convertedAmount = currencyService.convert(amount, from.getCurrency(), to.getCurrency());
      to.add(convertedAmount);
      factory.createTransaction(from, to, amount);
      System.out.println("Transfer successful! (" + amount + " " + from.getCurrency() + " -> " + convertedAmount + " " + to.getCurrency() + ")");

    } catch (ArithmeticException e) {
      System.out.println("Transfer failed: " + e.getMessage());
    }
  }

}
