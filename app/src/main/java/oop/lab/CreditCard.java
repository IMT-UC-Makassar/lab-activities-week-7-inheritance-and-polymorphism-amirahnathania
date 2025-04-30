package oop.lab;

public class CreditCard extends Card {
    public CreditCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }
    
    @Override
    public double getInterestRate() {
        return 1.5; // Bunga 1.5% untuk credit card
    }
}