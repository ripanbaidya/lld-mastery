package com.designpatterns.factory.factory;

import com.designpatterns.factory.implementation.EmailNotification;
import com.designpatterns.factory.implementation.PushNotification;
import com.designpatterns.factory.implementation.SlackNotification;
import com.designpatterns.factory.model.Notification;

public class SimpleNotificationFactory {

  public static Notification createNotification(String type) {
    return switch (type.toUpperCase().trim()) {
      case "EMAIL" -> new EmailNotification();
      case "PUSH" -> new PushNotification();
      case "SLACK" -> new SlackNotification();
      default -> throw new IllegalArgumentException("Invalid notification type");
    };
  }
}
