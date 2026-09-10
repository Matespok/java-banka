import accounts.*;
import java.util.ArrayList;
import java.util.List;
import people.*;

public class Main {
  public static void main(String[] args) {
    AccountOwner owner = new AccountOwner("Janos", "Kredenc");

    // declare all accs
    List<BankAccount> accounts = new ArrayList<>();
    BankAccount studentAccount =
        new StudentAccount(owner, "Plynarenske uciliste Pardubice");
    accounts.add(studentAccount);

    BankAccount currentAccount = new CurrentAccount(owner, 100);
    accounts.add(currentAccount);

    BankAccount businessAccount = new BusinessAccount(owner, 0.01);
    accounts.add(businessAccount);

    BankAccount savingsAccount = new SavingsAccount(owner, 0.05);
    accounts.add(savingsAccount);

    System.out.println("--- Testing Overridden Methods ---");
  }
}
