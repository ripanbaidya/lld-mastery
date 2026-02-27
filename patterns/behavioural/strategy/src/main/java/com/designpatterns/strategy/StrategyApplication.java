package com.designpatterns.strategy;

import com.designpatterns.strategy.context.PaymentContext;
import com.designpatterns.strategy.factory.PaymentStrategyFactory;
import com.designpatterns.strategy.strategy.PaymentStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class StrategyApplication {
  public static void main(String[] args) {
//    SpringApplication.run(StrategyApplication.class, args);

    // Create Credit Card Strategy
    PaymentStrategy creditCardStrategy = PaymentStrategyFactory
        .createCreditCardStrategy("1234-5678-9012-3456", "Ripan Baidya");

    PaymentContext paymentContext = new PaymentContext(creditCardStrategy);
    paymentContext.executePayment(BigDecimal.valueOf(1500));

    System.out.println("----- Switching Payment Method -----");

    // Switch to UPI at runtime
    PaymentStrategy upiStrategy = PaymentStrategyFactory.createUpiStrategy("ripan@upi");

    paymentContext.setPaymentStrategy(upiStrategy);
    paymentContext.executePayment(BigDecimal.valueOf(750));
  }
}
