import accounts.*;
import notifiers.ConsoleNotifier;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import people.*;
import transfers.*;

public class Main {
  public static void main(String[] args) {

    AccountOwner owner1 = new AccountOwner("Janos", "Kredenc");
    AccountOwner owner2 = new AccountOwner("Bela", "Kovacs");
    ConsoleNotifier notifier = new ConsoleNotifier();
    BankAccountFactory factory = new BankAccountFactory();
    LoggingBankAccountFactory logFactory = new LoggingBankAccountFactory(factory, notifier);
    BankAccount studentAccount = factory.createStudentAccount(owner1, "BME");

    BankAccount studentAccount1 = logFactory.createStudentAccount(owner1, "BME");
    studentAccount.add(1000);

    BankAccount businessAccount = factory.createBusinessAccount(owner2, 0.05);

    BankAccount businessAccount1 = logFactory.createBusinessAccount(owner1, 0.05);

    BankAccount currentAccount = factory.createCurrentBankAccount(owner2, 5000);

    BankAccount currentAccount1 = logFactory.createCurrentBankAccount(owner1, 5000);
    businessAccount.add(5000);
    TransferService transferService = new TransferService();
    notifier.notify("creating account\nCreating an account " + LocalTime.now());
    notifier.notify("Created account\nCreated an account at " + LocalTime.now());
    System.out.println("Before Transfer:");
    System.out.println("Student Account Balance: " +
        studentAccount.getBalance());
    System.out.println("Business Account Balance: " +
        businessAccount.getBalance());

    System.out.println("\nTransferring 500 from Business to Student...");
    //transferService.transferMoney(500, businessAccount, studentAccount);

    System.out.println("\nAfter Transfer:");
    System.out.println("Student Account Balance: " +
        studentAccount.getBalance());
    System.out.println("Business Account Balance: " +
        businessAccount.getBalance());
  }
}
