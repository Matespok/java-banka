package currency;

public enum Currency {
  CZK("Kč", 1.0),
  EUR("€", 25.0),
  USD("$", 23.0);

  private final String symbol;
  private final double rateToCzk;

  Currency(String symbol, double rateToCzk) {
    this.symbol = symbol;
    this.rateToCzk = rateToCzk;
  }

  public String getSymbol() {
    return symbol;
  }

  public double getRateToCzk() {
    return rateToCzk;
  }

}
