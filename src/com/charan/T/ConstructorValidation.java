package com.charan.T;

import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    // Parameterized constructor with validation
    public Account(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.err.println("Error: Account number cannot be null or empty.");
            return; // Exit constructor
        }
        if (balance < 0) {
            System.err.println("Error: Balance cannot be negative.");
            return; // Exit constructor
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods for accountNumber and balance
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Main method to test the Account class
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String accnumber=sc.next();
        double balance= sc.nextDouble();
        Account validAccount=new Account(accnumber,balance);

        if (validAccount.getAccountNumber() != null) {
            System.out.println("Account Number: " + validAccount.getAccountNumber());
            System.out.println("Balance: " + validAccount.getBalance());
        }
    }
}
