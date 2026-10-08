package accounts.serialization;

import accounts.BankAccount;
import java.util.List;

public class BankAccountXmlSerialization {
  public String createXml(List<BankAccount> bankAccounts) {
    int size = bankAccounts.size();
    StringBuilder builder = new StringBuilder();

    if (size > 1) {
      builder.append("<bankAccounts>");
      for (int i = 0; i < size; i++) {
        builder.append("<bankAccount><accountNumber>" + bankAccounts.get(i) +
                       "</accountNumber></bankAccount>");
      }
      builder.append("</bankAccounts>");
      String xml = builder.toString();
      return xml;
    }

    builder.append("<bankAccount><accountNumber>" + bankAccounts.get(0) +
                   "</accountNumber></bankAccount>");
    String xml = builder.toString();
    return xml;
  }
}
