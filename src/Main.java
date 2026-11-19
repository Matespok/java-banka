import di.Container;
import accounts.BankAccount;
import accounts.services.IBankAccountService;
import people.AccountOwner;
import transfers.TransferService;

public class Main {
  public static void main(String[] args) {
    Container container = new Container();

    IBankAccountService accountService = container.getBankAccountService();
    TransferService transferService = container.getTransferService();

    AccountOwner owner1 = new AccountOwner("Janos", "Kredenc");
    AccountOwner owner2 = new AccountOwner("Bela", "Kovacs");

    BankAccount businessAccount = accountService.createBusinessAccount(owner1, 0.05);
    BankAccount studentAccount = accountService.createStudentAccount(owner2, "BME");

    businessAccount.add(5000);
    studentAccount.add(1000);

    transferService.transferMoney(500, businessAccount, studentAccount);

    System.out.println("Zůstatek business: " + businessAccount.getBalance());
    System.out.println("Zůstatek student: " + studentAccount.getBalance());
  }
}
