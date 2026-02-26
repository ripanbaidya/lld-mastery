package com.designpatterns.abstractfactory.razorpay;

import com.designpatterns.abstractfactory.product.RefundProcessor;

/**
 * Concrete Product
 */
public class RazorpayRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(String transactionId) {
        System.out.println("Processing refund via Razorpay for transaction: " + transactionId);
    }
}