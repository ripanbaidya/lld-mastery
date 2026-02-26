package com.designpatterns.abstractfactory.razorpay;

import com.designpatterns.abstractfactory.product.PaymentProcessor;

/**
 * Concrete Product
 */
public class RazorpayPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Razorpay: ₹" + amount);
    }
}