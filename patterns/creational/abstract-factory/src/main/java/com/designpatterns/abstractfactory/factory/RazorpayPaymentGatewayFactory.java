package com.designpatterns.abstractfactory.factory;

import com.designpatterns.abstractfactory.product.PaymentProcessor;
import com.designpatterns.abstractfactory.product.RefundProcessor;
import com.designpatterns.abstractfactory.product.WebhookHandler;
import com.designpatterns.abstractfactory.razorpay.RazorpayPaymentProcessor;
import com.designpatterns.abstractfactory.razorpay.RazorpayRefundProcessor;
import com.designpatterns.abstractfactory.razorpay.RazorpayWebhookHandler;

/**
 * Concrete Creator
 */
public class RazorpayPaymentGatewayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new RazorpayPaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new RazorpayRefundProcessor();
    }

    @Override
    public WebhookHandler createWebhookHandler() {
        return new RazorpayWebhookHandler();
    }
}