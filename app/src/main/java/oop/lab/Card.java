package oop.lab;

public class Card {
    protected String cardNumber;
    protected String cardHolder;
    
    public Card(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }
    
    public double getInterestRate() {
        return 0.0; // Default interest rate
    }
}