package com.designpatterns.strategy.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Concrete Strategy for Credit Card payments.
 */
public class CreditCardPaymentStrategy implements PaymentStrategy {

  private final String cardNumber;
  private final String cardHolderName;

  public CreditCardPaymentStrategy(String cardNumber, String cardHolderName) {
    this.cardNumber = Objects.requireNonNull(cardNumber);
    this.cardHolderName = Objects.requireNonNull(cardHolderName);
  }

  @Override
  public void pay(BigDecimal amount) {
    // Simulate credit card processing
    System.out.println("Processing credit card payment...");
    System.out.println("Card Holder: " + cardHolderName);
    System.out.println("Amount Paid: ₹" + amount);
  }
}