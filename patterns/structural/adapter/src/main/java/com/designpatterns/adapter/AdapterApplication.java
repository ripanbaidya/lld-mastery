package com.designpatterns.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdapterApplication {
  public static void main(String[] args) {
//    SpringApplication.run(AdapterApplication.class, args);
    
    // Modern processor
    PaymentProcessor processor = new InHousePaymentProcessor();
    CheckoutService modernCheckout = new CheckoutService(processor);
    System.out.println("--- Using Modern Processor ---");
    modernCheckout.checkout(199.99, "USD");

    // Legacy gateway through adapter
    System.out.println("\n--- Using Legacy Gateway via Adapter ---");
    LegacyGateway legacy = new LegacyGateway();
    processor = new LegacyGatewayAdapter(legacy);
    CheckoutService legacyCheckout = new CheckoutService(processor);
    legacyCheckout.checkout(75.50, "USD");
  }
}
