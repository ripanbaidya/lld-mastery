package com.designpatterns.abstractfactory.stripe;

import com.designpatterns.abstractfactory.product.WebhookHandler;

/**
 * Concrete Product
 */
public class StripeWebhookHandler implements WebhookHandler {

    @Override
    public void handleWebhook(String payload) {
        System.out.println("Handling Stripe webhook: " + payload);
    }
}