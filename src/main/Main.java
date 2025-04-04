package main;

import bankservices.*;

public class MainClass {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");

        int acc1 = bank.createAccount("Ali", 10, 1000);
        int acc2 = bank.createAccount("Vali", 15, 500);

        bank.deposit(acc1, 20, 300);
        bank.withdraw(acc1, 25, 200);

        bank.transfer(acc1, acc2, 30, 100);

        bank.deleteAccount(acc2, 40);

        Account a1 = bank.getAccount(acc1);
        if (a1 != null) {
            System.out.println("Account 1 operations:");
            for (Operation op : a1.getOperations()) {
                System.out.println(op);
            }
        }
    }
}
