package com.designpatterns.strategy.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Concrete Strategy for PayPal payments.
 */
public class PaypalPaymentStrategy implements PaymentStrategy {

  private final String email;

  public PaypalPaymentStrategy(String email) {
    this.email = Objects.requireNonNull(email);
  }

  @Override
  public void pay(BigDecimal amount) {
    System.out.println("Processing PayPal payment...");
    System.out.println("Account Email: " + email);
    System.out.println("Amount Paid: ₹" + amount);
  }
}