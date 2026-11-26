package currency;

public class CurrencyService {

  public double convert(double amount, Currency from, Currency to) {
    if (from == null || to == null) {
      throw new IllegalArgumentException("Currencies must not be null");
    }
    if (from == to) {
      return amount;
    }

    double inCzk = amount * from.getRateToCzk();
    return inCzk / to.getRateToCzk();
  }
}
