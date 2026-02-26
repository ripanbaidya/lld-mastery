package com.designpatterns.abstractfactory.factory;

import com.designpatterns.abstractfactory.product.PaymentProcessor;
import com.designpatterns.abstractfactory.product.RefundProcessor;
import com.designpatterns.abstractfactory.product.WebhookHandler;
import com.designpatterns.abstractfactory.stripe.StripePaymentProcessor;
import com.designpatterns.abstractfactory.stripe.StripeRefundProcessor;
import com.designpatterns.abstractfactory.stripe.StripeWebhookHandler;

/**
 * Concrete Creator
 */
public class StripePaymentGatewayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new StripePaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new StripeRefundProcessor();
    }

    @Override
    public WebhookHandler createWebhookHandler() {
        return new StripeWebhookHandler();
    }
}