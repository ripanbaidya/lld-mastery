package com.designpatterns.command.command;

import com.designpatterns.command.model.Order;
import com.designpatterns.command.receiver.PaymentService;

public class RefundOrderCommand implements Command {

  private final PaymentService paymentService;
  private final Order order;

  public RefundOrderCommand(PaymentService paymentService, Order order) {
    this.paymentService = paymentService;
    this.order = order;
  }

  @Override
  public void execute() {
    paymentService.refund(order);
  }

  @Override
  public void undo() {
    System.out.println("Refund cannot be undone for order: " + order.getOrderId());
  }
}
