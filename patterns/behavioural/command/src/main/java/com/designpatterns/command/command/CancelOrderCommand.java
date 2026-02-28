package com.designpatterns.command.command;

import com.designpatterns.command.model.Order;
import com.designpatterns.command.receiver.OrderService;

public class CancelOrderCommand implements Command{

  private final OrderService orderService;
  private final Order order;

  public CancelOrderCommand(OrderService orderService, Order order) {
    this.orderService = orderService;
    this.order = order;
  }

  @Override
  public void execute() {
    orderService.cancelOrder(order);
  }

  @Override
  public void undo() {
    orderService.placeOrder(order);
  }
}
