package com.designpatterns.strategy.context;

import com.designpatterns.strategy.strategy.PaymentStrategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Context class.
 * Delegates the payment processing to a PaymentStrategy.
 */
public class PaymentContext {

  private PaymentStrategy paymentStrategy;

  public PaymentContext(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = Objects.requireNonNull(paymentStrategy);
  }

  /**
   * Allows changing strategy at runtime.
   */
  public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = Objects.requireNonNull(paymentStrategy);
  }

  public void executePayment(BigDecimal amount) {
    paymentStrategy.pay(amount);
  }
}