package com.designpatterns.command.model;

public class Order {

  private final String orderId;
  private OrderStatus orderStatus;

  public Order(String orderId) {
    this.orderId = orderId;
    this.orderStatus = OrderStatus.CREATED;
  }

  public String getOrderId() {
    return orderId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
}
