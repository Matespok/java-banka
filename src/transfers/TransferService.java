package transfers;

import accounts.*;

public class TransferService {

  public boolean ValidateTransfer(double amount, BankAccount from) {
    if (amount <= 0) {
      System.out.println("Positive amount only");
      return false;
    }
    double balance = from.getBalance();
    if (amount >= balance) {
      System.out.println("Insufficient balance");
      return false;
    }
    return true;
  }

  public void transferMoney(double amount, BankAccount from, BankAccount to) {
    if (!ValidateTransfer(amount, from)) {
      return;
    }
    double balance = from.getBalance();
    double fee = 0.0;

    if (from instanceof BusinessAccount bizAccount) {
      fee = bizAccount.getFee();
    }

    from.setBalance(balance - (amount * fee));
    to.setBalance(to.getBalance() + amount);
  }
}
