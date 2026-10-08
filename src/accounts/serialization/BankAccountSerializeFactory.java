package accounts.serialization;

public class BankAccountSerializeFactory {
  public BankAccountSerialize createBankAccountSerialize(String accountNumber) {
    return new BankAccountSerialize(accountNumber);
  }
}
