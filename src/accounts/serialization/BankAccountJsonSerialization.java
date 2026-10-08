package accounts.serialization;

import accounts.BankAccount;
import java.util.List;

public class BankAccountJsonSerialization {
  public String createJson(List<BankAccount> bankAccounts) {
    int size = bankAccounts.size();
    StringBuilder builder = new StringBuilder();
    if (size > 1) {
      // [ {}, {}, {}, ]
      builder.append("[");
      for (int i = 0; i < size; i++) {
        builder.append("{ \"accountNumber\": \"" + bankAccounts.get(i) +
                       "\" }");
        if (i != size - 1) {
          builder.append(",");
        }
      }
      builder.append("]");
      String json = builder.toString();
      return json;
    }
    builder.append("{ \"accountNumber\": \"" + bankAccounts.get(0) + "\" }");
    String json = builder.toString();
    return json;
  }
}
