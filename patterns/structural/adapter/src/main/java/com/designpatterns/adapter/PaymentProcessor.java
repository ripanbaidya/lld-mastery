package com.designpatterns.adapter;

/**
 * Target Interface for Payment Processor
 * The interface that the client expects to work with
 */
public interface PaymentProcessor {

  public void processPayment(double amount, String currency);

  public boolean isPaymentSuccessful();

  public String getTransactionId();
}
