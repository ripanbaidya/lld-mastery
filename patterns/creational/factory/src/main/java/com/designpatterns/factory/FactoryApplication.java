package com.designpatterns.factory;

import com.designpatterns.factory.factory.*;
import com.designpatterns.factory.model.Notification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Client
 */
@SpringBootApplication
public class FactoryApplication {
  public static void main(String[] args) {
    // SpringApplication.run(FactoryApplication.class, args);
    final String message = "Hello World";

    // Simple factory
    Notification emailNotification = SimpleNotificationFactory.createNotification("email");

    System.out.println("*------------ Using Simple Factory ------------*");
    emailNotification.sendNotification(message);

    NotificationCreator creator = null;

    System.out.println("\n*------------ Using Factory Method ------------*");
    // Email notification
    creator = new EmailNotificationCreator();
    creator.sendNotification(message);

    // Push notification
    creator = new PushNotificationCreator();
    creator.sendNotification(message);

    // Slack notification
    creator = new SlackNotificationCreator();
    creator.sendNotification(message);
  }
}
