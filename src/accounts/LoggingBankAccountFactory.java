package accounts;

import accounts.*;
import notifiers.ConsoleNotifier;
import people.*;

import java.time.LocalTime;

/**
 * LoggingBankAccountFactory
 */

public class LoggingBankAccountFactory extends BankAccountFactory {
    private final ConsoleNotifier notifier;
    public  LoggingBankAccountFactory(BankAccountFactory originalBankAccountFactory, ConsoleNotifier consoleNotifier) {
        this.notifier = consoleNotifier;
    }

    @Override
    public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee) {
        notifier.notify("Creating an account " + LocalTime.now().toString());
        BankAccount account = createBusinessAccount(owner, withdrawFee);
        notifier.notify("Created an account" + LocalTime.now().toString());
        return account;
    }
    @Override
    public BankAccount createStudentAccount(AccountOwner owner, String school){
        notifier.notify("Creating an account");
        BankAccount account =  super.createStudentAccount(owner, school);
        notifier.notify("Created an account");
        return account;
    }
    @Override
    public BankAccount createCurrentBankAccount(AccountOwner owner, double overdraftLimit) {
        notifier.notify("Creating an account");
        notifier.notify("Creating an account" + LocalTime.now().toString());
        BankAccount account =  super.createCurrentBankAccount(owner, overdraftLimit);
        notifier.notify("Created an account");
        notifier.notify("Created an account" + LocalTime.now().toString());
        return account;
    }
}