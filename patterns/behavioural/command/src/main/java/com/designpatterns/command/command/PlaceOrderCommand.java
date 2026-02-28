package com.designpatterns.command.command;

import com.designpatterns.command.model.Order;
import com.designpatterns.command.receiver.OrderService;

public class PlaceOrderCommand implements Command {

  private final OrderService orderService;
  private final Order order;

  public PlaceOrderCommand(OrderService orderService, Order order) {
    this.orderService = orderService;
    this.order = order;
  }

  @Override
  public void execute() {
    orderService.placeOrder(order);
  }

  @Override
  public void undo() {
    orderService.cancelOrder(order);
  }
}
