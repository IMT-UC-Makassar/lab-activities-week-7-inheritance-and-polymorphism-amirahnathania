package oop.lab;

public class BusinessAccount extends BankAccount implements OnlineService, LoanService {
    private String loanStatus;
    private static final double ANNUAL_INTEREST_RATE = 0.07; // 7% per tahun
    
    public BusinessAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
        this.loanStatus = "No Loan";
    }

    // ========== Implementasi BankAccount ==========
    @Override
    public double calculateInterest() {
        double monthlyInterest = balance * (ANNUAL_INTEREST_RATE / 12);
        deposit(monthlyInterest);
        return monthlyInterest;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
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

    // ========== Implementasi OnlineService ==========
    @Override
    public void transferFunds(double amount, String targetAccount) {
        withdraw(amount); // Tarik dana dari akun ini
        // Logika transfer ke rekening tujuan (contoh sederhana)
        System.out.println("Transfer " + amount + " ke rekening " + targetAccount);
    }

    @Override
    public void payBills(double amount) {
        withdraw(amount);
        System.out.println("Pembayaran tagihan sebesar " + amount);
    }

    // ========== Implementasi LoanService ==========
    @Override
    public void applyForLoan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah pinjaman harus positif");
        }
        loanStatus = "Pending - Amount: " + amount;
    }

    @Override
    public String checkLoanStatus() {
        return loanStatus;
    }
}