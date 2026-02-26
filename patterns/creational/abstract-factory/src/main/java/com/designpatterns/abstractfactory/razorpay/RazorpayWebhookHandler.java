package com.designpatterns.abstractfactory.razorpay;

import com.designpatterns.abstractfactory.product.WebhookHandler;

/**
 * Concrete Product
 */
public class RazorpayWebhookHandler implements WebhookHandler {

    @Override
    public void handleWebhook(String payload) {
        System.out.println("Handling Razorpay webhook: " + payload);
    }
}