package com.designpatterns.command.receiver;

import com.designpatterns.command.model.Order;
import com.designpatterns.command.model.OrderStatus;

/**
 * Receiver
 */
public class OrderService {

  public void placeOrder(Order order) {
    order.setOrderStatus(OrderStatus.PLACED);
    System.out.println("Order placed: " + order.getOrderId());
  }

  public void cancelOrder(Order order) {
    order.setOrderStatus(OrderStatus.CANCELLED);
    System.out.println("Order cancelled: " + order.getOrderId());
  }

  public void shipOrder(Order order) {
    order.setOrderStatus(OrderStatus.SHIPPED);
    System.out.println("Order shipped: " + order.getOrderId());
  }
}
