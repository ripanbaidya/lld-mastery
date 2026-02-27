package com.designpatterns.strategy.factory;

import com.designpatterns.strategy.strategy.CreditCardPaymentStrategy;
import com.designpatterns.strategy.strategy.PaymentStrategy;
import com.designpatterns.strategy.strategy.PaypalPaymentStrategy;
import com.designpatterns.strategy.strategy.UpiPaymentStrategy;

/**
 * Factory class to create different types of PaymentStrategy objects.
 *
 */
public final class PaymentStrategyFactory {

  // Prevent instantiation
  private PaymentStrategyFactory() {
  }

  public static PaymentStrategy createCreditCardStrategy(String cardNumber,
                                                         String cardHolderName) {
    return new CreditCardPaymentStrategy(cardNumber, cardHolderName);
  }

  public static PaymentStrategy createUpiStrategy(String upiId) {
    return new UpiPaymentStrategy(upiId);
  }

  public static PaymentStrategy createPaypalStrategy(String email) {
    return new PaypalPaymentStrategy(email);
  }
}