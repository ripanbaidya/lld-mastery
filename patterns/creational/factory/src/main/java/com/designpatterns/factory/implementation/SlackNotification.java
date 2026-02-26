package com.designpatterns.factory.implementation;

import com.designpatterns.factory.model.Notification;

/**
 * Concrete Product
 */
public class SlackNotification implements Notification {

  @Override
  public void sendNotification(String message) {
    System.out.println("Sending Slack Notification: " + message);
  }
}
