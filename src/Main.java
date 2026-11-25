import di.Container;
import accounts.BankAccount;
import accounts.services.IBankAccountService;
import people.AccountOwner;
import people.AccountOwnerFactory;
import transfers.TransferService;

public class Main {
  public static void main(String[] args) {
    Container container = new Container();

    IBankAccountService accountService = container.getBankAccountService();
    TransferService transferService = container.getTransferService();
    AccountOwnerFactory accountOwnerFactory = container.getAccountOwnerFactory();

    AccountOwner owner1 = accountOwnerFactory.createAccountOwner("Jánoš", "Kredenc");
    AccountOwner owner2 = new AccountOwner("Bela", "Kovacs");

    BankAccount businessAccount = accountService.createBusinessAccount(owner1, 0.05);
    BankAccount studentAccount = accountService.createStudentAccount(owner2, "BME");

    businessAccount.add(5000);
    studentAccount.add(1000);

    transferService.transferMoney(500, businessAccount, studentAccount);

    printBalance("Zůstatek business", businessAccount);
    printBalance("Zůstatek student", studentAccount);
  }

  private static void printBalance(String label, BankAccount account) {
    currency.Currency curr = account.getCurrency();
    currency.Currency other = (curr == currency.Currency.EUR) ? currency.Currency.CZK : currency.Currency.EUR;
    double converted = curr.convertTo(account.getBalance(), other);
    System.out.printf("%s: %.2f %s (%s) | Přepočet: %.2f %s (%s)%n",
        label, account.getBalance(), curr.getSymbol(), curr, converted, other.getSymbol(), other);
  }
}
