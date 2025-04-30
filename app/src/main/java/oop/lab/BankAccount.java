package oop.lab;

public abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    // Tambahkan method withdraw yang bisa diakses oleh subclass
    protected void withdraw(double amount) {
        this.balance -= amount;
    }
    
    public abstract double calculateInterest();
    public abstract double getBalance();
    public abstract void deposit(double amount);
}