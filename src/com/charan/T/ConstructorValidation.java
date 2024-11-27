package com.charan.T;

import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.err.println("Error: Account number cannot be null or empty.");
            return;
        }
        if (balance < 0) {
            System.err.println("Error: Balance cannot be negative.");
            return;
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
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
