import accounts.*;
import java.util.ArrayList;
import java.util.List;
import people.*;
import transfers.*;

public class Main {
  public static void main(String[] args) {
    AccountOwner owner1 = new AccountOwner("Janos", "Kredenc");
    AccountOwner owner2 = new AccountOwner("Bela", "Kovacs");

    BankAccountFactory factory = new BankAccountFactory();

    BankAccount studentAccount = factory.createStudentAccount(owner1, "BME");
    studentAccount.add(1000);

    BankAccount businessAccount = factory.createBusinessAccount(owner2, 0.05);
    businessAccount.add(5000);

    TransferService transferService = new TransferService();

    System.out.println("Before Transfer:");
    System.out.println("Student Account Balance: " +
                       studentAccount.getBalance());
    System.out.println("Business Account Balance: " +
                       businessAccount.getBalance());

    System.out.println("\nTransferring 500 from Business to Student...");
    transferService.transferMoney(500, businessAccount, studentAccount);

    System.out.println("\nAfter Transfer:");
    System.out.println("Student Account Balance: " +
                       studentAccount.getBalance());
    System.out.println("Business Account Balance: " +
                       businessAccount.getBalance());
  }
}
