import accounts.*;
import java.util.ArrayList;
import java.util.List;
import people.*;

public class Main {
  public static void main(String[] args) {
    AccountOwner owner = new AccountOwner("Janos", "Kredenc");

    // declare all accs
    List<BankAccount> accounts = new ArrayList<>();
    BankAccount studentAccount = new StudentAccount(owner, "Plynarenske uciliste Pardubice");
    accounts.add(studentAccount);

    BankAccount currentAccount = new CurrentAccount(owner, 100);
    accounts.add(currentAccount);

    BankAccount businessAccount = new BusinessAccount(owner, 0.01);
    accounts.add(businessAccount);

    BankAccount savingsAccount = new SavingsAccount(owner, 0.05);
    accounts.add(savingsAccount);

    System.out.println("--- Testing Overridden Methods ---");

    // 1. Test StudentAccount: allows overdraft up to -5000
    System.out.println("\n[StudentAccount] Initial balance: " +
        studentAccount.getBalance());
    studentAccount.substract(2000);
    System.out.println(
        "[StudentAccount] After subtracting 2000 (within overdraft): " +
            studentAccount.getBalance());
    try {
      studentAccount.substract(4000); // Total would be -6000
    } catch (ArithmeticException e) {
      System.out.println(
          "[StudentAccount] Exception when trying to exceed -5000 limit: " +
              e.getMessage());
    }

    // 2. Test BusinessAccount: subtracts an extra 1% fee (amount * 1.01)
    businessAccount.add(1000); // Set initial balance
    System.out.println("\n[BusinessAccount] Initial balance: " +
        businessAccount.getBalance());
    businessAccount.substract(100); // 100 * 1.01 = 101 should be subtracted
    System.out.println("[BusinessAccount] After subtracting 100 (should be "
        + "1000 - 101 = 899): " + businessAccount.getBalance());

    // 3. Test SavingsAccount: add() applies interest (amount * (interest + 1))
    System.out.println("\n[SavingsAccount] Initial balance: " +
        savingsAccount.getBalance());
    savingsAccount.add(100); // 100 * (1 + 0.05) = 105 should be added
    System.out.println("[SavingsAccount] After adding 100 (should be 105): " +
        savingsAccount.getBalance());
  }
}
