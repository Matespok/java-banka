package people;

public class Owner {
  private String uuid;
  private String name;
  private String lastName;

  public Owner(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public void setName(String name) { this.name = name; }

  public String getName() { return this.name; }

  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getLastName() { return this.lastName; }
}
