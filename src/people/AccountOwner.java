package people;

public class AccountOwner {
  private String uuid;
  private String name;
  private String lastName;

  public void setName(String newName) { this.name = newName; }

  public void setLastName(String newLastName) { this.lastName = newLastName; }

  public AccountOwner(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }
}
