package com.designpatterns.command;

import com.designpatterns.command.command.CancelOrderCommand;
import com.designpatterns.command.command.Command;
import com.designpatterns.command.command.PlaceOrderCommand;
import com.designpatterns.command.command.RefundOrderCommand;
import com.designpatterns.command.invoker.CommandInvoker;
import com.designpatterns.command.model.Order;
import com.designpatterns.command.receiver.OrderService;
import com.designpatterns.command.receiver.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandApplication {
  public static void main(String[] args) {
    // SpringApplication.run(CommandApplication.class, args);

    Order order = new Order("ORD-101");

    OrderService orderService = new OrderService();
    PaymentService paymentService = new PaymentService();

    CommandInvoker invoker = new CommandInvoker();

    // Place Order
    Command placeCommand = new PlaceOrderCommand(orderService, order);
    invoker.executeCommand(placeCommand);

    // Cancel Order
    Command cancelCommand = new CancelOrderCommand(orderService, order);
    invoker.executeCommand(cancelCommand);

    // Undo Cancel
    invoker.undoLastCommand();

    // Refund
    Command refundCommand = new RefundOrderCommand(paymentService, order);
    invoker.executeCommand(refundCommand);
  }
}
