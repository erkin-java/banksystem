package bankservices;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String owner;
    private int balance;
    private int lastOperationDate;
    private List<Operation> operations;

    public Account(String owner, int activationDate, int initialDeposit) {
        this.owner = owner;
        this.balance = initialDeposit;
        this.lastOperationDate = activationDate;
        this.operations = new ArrayList<>();
        operations.add(new Deposit(activationDate, initialDeposit));
    }

    public int getBalance() {
        return balance;
    }

    public int getLastOperationDate() {
        return lastOperationDate;
    }

    public void deposit(int date, int amount) {
        if (date < lastOperationDate) {
            date = lastOperationDate;
        }
        operations.add(new Deposit(date, amount));
        balance += amount;
        lastOperationDate = date;
    }

    public boolean withdraw(int date, int amount) {
        if (amount > balance) {
            return false;
        }
        if (date < lastOperationDate) {
            date = lastOperationDate;
        }
        operations.add(new Withdrawal(date, amount));
        balance -= amount;
        lastOperationDate = date;
        return true;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public String getOwner() {
        return owner;
    }
}