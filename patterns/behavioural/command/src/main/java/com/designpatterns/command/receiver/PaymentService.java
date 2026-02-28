package com.designpatterns.command.receiver;

import com.designpatterns.command.model.Order;

/**
 * Receiver
 */
public class PaymentService {

    public void refund(Order order) {
        System.out.println("Refund processed for order: " + order.getOrderId());
    }
}