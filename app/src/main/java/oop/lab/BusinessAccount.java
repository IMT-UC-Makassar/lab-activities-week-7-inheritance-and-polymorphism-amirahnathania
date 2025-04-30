package oop.lab;

public class BusinessAccount extends BankAccount implements OnlineService, LoanService {
    private String loanStatus;
    
    public BusinessAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
        this.loanStatus = "No Loan";
    }
    
    @Override
    public double calculateInterest() {
        return 0; // Implementasi sementara
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
        balance += amount;
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    // OnlineService methods
    @Override
    public void transferFunds(double amount, String targetAccount) {
        withdraw(amount);
        // Logika transfer
    }
    
    @Override
    public void payBills(double amount) {
        withdraw(amount);
    }
    
    // LoanService methods
    @Override
    public void applyForLoan(double amount) {
        loanStatus = "Pending";
    }
    
    @Override
    public String checkLoanStatus() {
        return loanStatus;
    }
}