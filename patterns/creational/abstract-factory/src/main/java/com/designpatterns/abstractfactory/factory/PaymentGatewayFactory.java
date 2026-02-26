package com.designpatterns.abstractfactory.factory;

import com.designpatterns.abstractfactory.product.PaymentProcessor;
import com.designpatterns.abstractfactory.product.RefundProcessor;
import com.designpatterns.abstractfactory.product.WebhookHandler;

/**
 * Creator or Factory
 */
public interface PaymentGatewayFactory {

    PaymentProcessor createPaymentProcessor();

    RefundProcessor createRefundProcessor();

    WebhookHandler createWebhookHandler();
}