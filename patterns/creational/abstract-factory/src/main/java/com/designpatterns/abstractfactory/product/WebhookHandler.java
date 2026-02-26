package com.designpatterns.abstractfactory.product;

/**
 * Product
 */
public interface WebhookHandler {

  void handleWebhook(String payload);
}
