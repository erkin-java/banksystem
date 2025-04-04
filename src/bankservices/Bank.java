package bankservices;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private Map<Integer, Account> accounts;
    private int nextAccountNumber;

    public Bank(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
        this.nextAccountNumber = 1;
    }

    public String getName() {
        return name;
    }

    public int createAccount(String owner, int activationDate, int initialDeposit) {
        Account acc = new Account(owner, activationDate, initialDeposit);
        accounts.put(nextAccountNumber, acc);
        return nextAccountNumber++;
    }

    public Account getAccount(int accountNumber) {
        Account acc = accounts.get(accountNumber);
        if (acc == null) {
            System.err.println("Error: Account " + accountNumber + " not found.");
        }
        return acc;
    }

    public void deposit(int accountNumber, int date, int amount) {
        Account acc = getAccount(accountNumber);
        if (acc != null) {
            acc.deposit(date, amount);
        }
    }

    public void withdraw(int accountNumber, int date, int amount) {
        Account acc = getAccount(accountNumber);
        if (acc != null) {
            boolean success = acc.withdraw(date, amount);
            if (!success) {
                System.err.println("Error: Insufficient funds in account " + accountNumber);
            }
        }
    }

    public void transfer(int fromAccount, int toAccount, int date, int amount) {
        Account src = getAccount(fromAccount);
        Account dst = getAccount(toAccount);

        if (src == null || dst == null) return;

        int actualDate = Math.max(date, src.getLastOperationDate());

        if (amount > src.getBalance()) {
            System.err.println("Error: Insufficient funds in account " + fromAccount);
            return;
        }

        src.withdraw(actualDate, amount);
        dst.deposit(actualDate, amount);
    }

    public Account deleteAccount(int accountNumber, int date) {
        Account acc = getAccount(accountNumber);
        if (acc != null) {
            int balance = acc.getBalance();
            acc.withdraw(date, balance);
            accounts.remove(accountNumber);
            return acc;
        }
        return null;
    }
}