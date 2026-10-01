package notifiers;

public class ConsoleNotifier implements Notifier {
  @Override
  public void notify(String message) {
    System.out.println("Console notify " + message);
  }
}
