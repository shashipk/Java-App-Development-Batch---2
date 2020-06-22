package com.company;

public class BankObject {

    private int accountNo;
    private int balance;

    public int getAccountNo() {
        return accountNo;
    }

    public BankObject(int accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
