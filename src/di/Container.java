package di;

import accounts.*;
import accounts.services.*;
import currency.CurrencyService;
import notifiers.*;
import people.AccountOwnerFactory;
import transfers.*;

public class Container {
    private final Notifier notifier = new ConsoleNotifier();
    private final TransferLoggerService transferLogger = new TransferLoggerService();

    private final BankAccountFactory bankAccountFactory = new LoggingBankAccountFactory(new BankAccountFactory(),
            (ConsoleNotifier) notifier);
    private final TransactionFactory transactionFactory = new TransactionFactory();

    private final CurrencyService currencyService = new CurrencyService();

    private final IBankAccountService bankAccountService = new BankAccountService(bankAccountFactory);
    private final TransferService transferService = new TransferService(transactionFactory, currencyService);

    private final AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();

    // Gettery
    public Notifier getNotifier() {
        return notifier;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public IBankAccountService getBankAccountService() {
        return bankAccountService;
    }

    public TransferService getTransferService() {
        return transferService;
    }

    public TransferLoggerService getTransferLoggerService() {
        return transferLogger;
    }

    public AccountOwnerFactory getAccountOwnerFactory() {
        return accountOwnerFactory;
    }

    public CurrencyService getCurrencyService() {
        return currencyService;
    }
}
