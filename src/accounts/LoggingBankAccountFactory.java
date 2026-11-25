package accounts;

import accounts.*;
import currency.Currency;
import notifiers.ConsoleNotifier;
import people.*;

import java.time.LocalTime;

/**
 * LoggingBankAccountFactory
 */

public class LoggingBankAccountFactory extends BankAccountFactory {
    private final ConsoleNotifier notifier;

    public LoggingBankAccountFactory(BankAccountFactory originalBankAccountFactory, ConsoleNotifier consoleNotifier) {
        this.notifier = consoleNotifier;
    }

    @Override
    public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee) {
        return createBusinessAccount(owner, withdrawFee, Currency.CZK);
    }

    @Override
    public BankAccount createBusinessAccount(AccountOwner owner, double withdrawFee, Currency currency) {
        notifier.notify("Creating an account " + LocalTime.now().toString());
        BankAccount account = super.createBusinessAccount(owner, withdrawFee, currency);
        notifier.notify("Created an account" + LocalTime.now().toString());
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountOwner owner, String school) {
        return createStudentAccount(owner, school, Currency.CZK);
    }

    @Override
    public BankAccount createStudentAccount(AccountOwner owner, String school, Currency currency) {
        notifier.notify("Creating an account");
        BankAccount account = super.createStudentAccount(owner, school, currency);
        notifier.notify("Created an account");
        return account;
    }

    @Override
    public BankAccount createCurrentAccount(AccountOwner owner, double overdraftLimit) {
        return createCurrentAccount(owner, overdraftLimit, Currency.CZK);
    }

    @Override
    public BankAccount createCurrentAccount(AccountOwner owner, double overdraftLimit, Currency currency) {
        notifier.notify("Creating an account");
        notifier.notify("Creating an account" + LocalTime.now().toString());
        BankAccount account = super.createCurrentAccount(owner, overdraftLimit, currency);
        notifier.notify("Created an account");
        notifier.notify("Created an account" + LocalTime.now().toString());
        return account;
    }
}
