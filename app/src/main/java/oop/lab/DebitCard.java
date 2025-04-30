package oop.lab;

public class DebitCard extends Card {
    public DebitCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder); // Memanggil constructor parent
    }
    
    @Override
    public double getInterestRate() {
        return 0.0; // Debit card biasanya tidak ada bunga
    }
}