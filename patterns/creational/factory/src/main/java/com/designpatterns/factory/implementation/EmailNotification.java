package com.designpatterns.factory.implementation;

import com.designpatterns.factory.model.Notification;

/**
 * Concrete Product
 */
public class EmailNotification implements Notification {

  @Override
  public void sendNotification(String message) {
    System.out.println("Sending email: " + message);
  }
}
