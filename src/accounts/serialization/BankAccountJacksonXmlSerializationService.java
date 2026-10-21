package accounts.serialization;

import accounts.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class BankAccountJacksonXmlSerializationService implements BankAccountSerialization {

  BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();
  XmlMapper xmlMapper = new XmlMapper();

  @Override
  public String serializeAll(List<BankAccount> bankAccounts) {
    List<BankAccountSerialize> bankAccountsSerialize = new ArrayList<>();
    for (BankAccount bankAccount : bankAccounts) {
      bankAccountsSerialize.add(bankAccountSerializeFactory.createBankAccountSerialize(bankAccount));
    }

    try {
      return xmlMapper.writeValueAsString(bankAccountsSerialize);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to serialize bank accounts to XML", e);
    }
  }

  @Override
  public String serialize(BankAccount bankAccount) {
    BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

    try {
      return xmlMapper.writeValueAsString(bankAccountSerialize);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to serialize bank account to XML", e);
    }
  }
}
