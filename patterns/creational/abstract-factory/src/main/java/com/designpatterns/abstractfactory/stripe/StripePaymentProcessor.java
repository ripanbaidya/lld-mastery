package com.designpatterns.abstractfactory.stripe;

import com.designpatterns.abstractfactory.product.PaymentProcessor;

/**
 * Concrete Product
 */
public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Stripe: ₹" + amount);
    }
}