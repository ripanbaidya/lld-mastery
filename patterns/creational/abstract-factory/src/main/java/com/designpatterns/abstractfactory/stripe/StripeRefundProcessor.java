package com.designpatterns.abstractfactory.stripe;

import com.designpatterns.abstractfactory.product.RefundProcessor;

/**
 * Concrete Product
 */
public class StripeRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(String transactionId) {
        System.out.println("Processing refund via Stripe for transaction: " + transactionId);
    }
}