package com.designpatterns.abstractfactory;

import com.designpatterns.abstractfactory.factory.PaymentGatewayFactory;
import com.designpatterns.abstractfactory.factory.StripePaymentGatewayFactory;
import com.designpatterns.abstractfactory.product.PaymentProcessor;
import com.designpatterns.abstractfactory.product.RefundProcessor;
import com.designpatterns.abstractfactory.product.WebhookHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Client
 *
 * @author Ripan Baidya
 */
@SpringBootApplication
public class AbstractFactoryApplication {
  public static void main(String[] args) {
    // SpringApplication.run(AbstractFactoryApplication.class, args);

    // Choose payment provider
    PaymentGatewayFactory factory = new StripePaymentGatewayFactory();

    PaymentProcessor paymentProcessor = factory.createPaymentProcessor();
    RefundProcessor refundProcessor = factory.createRefundProcessor();
    WebhookHandler webhookHandler = factory.createWebhookHandler();

    paymentProcessor.processPayment(5000);
    refundProcessor.processRefund("TXN12345");
    webhookHandler.handleWebhook("payment_success_event");
  }
}