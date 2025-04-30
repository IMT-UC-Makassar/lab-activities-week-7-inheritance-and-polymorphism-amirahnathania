package oop.lab;

public class SavingsAccount extends BankAccount implements OnlineService {
    private static final double INTEREST_RATE = 0.05; // 5% interest
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    
    // Implementasi BankAccount
    @Override
    public double calculateInterest() {
        double interest = balance * INTEREST_RATE;
        deposit(interest);
        return interest;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }
    
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    // Implementasi OnlineService
    @Override
    public void transferFunds(double amount, String targetAccount) {
        withdraw(amount);
        // Logika transfer ke rekening tujuan
    }
    
    @Override
    public void payBills(double amount) {
        withdraw(amount);
    }
}