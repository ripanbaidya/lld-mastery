package com.designpatterns.factory;

import com.designpatterns.factory.factory.EmailNotificationCreator;
import com.designpatterns.factory.factory.NotificationCreator;
import com.designpatterns.factory.factory.PushNotificationCreator;
import com.designpatterns.factory.factory.SlackNotificationCreator;
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
    final String message = "Future FAANG Engineer";

    NotificationCreator creator = null;

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
