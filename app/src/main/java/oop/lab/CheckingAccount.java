package oop.lab;

public class CheckingAccount extends BankAccount implements OnlineService {
    public CheckingAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    // Ini method withdraw milik CheckingAccount (bukan memanggil super)
    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount; // Langsung ubah balance
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }

    // Implementasi OnlineService
    @Override
    public void transferFunds(double amount, String targetAccount) {
        withdraw(amount);
        // Logika transfer
    }

    @Override
    public void payBills(double amount) {
        withdraw(amount);
    }
}