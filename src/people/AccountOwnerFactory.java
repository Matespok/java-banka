package people;

public class AccountOwnerFactory {
  public AccountOwner createAccountOwner(String Name, String LastName) {
    return new AccountOwner(Name, LastName);
  }
}
