package com.designpatterns.factory.factory;

import com.designpatterns.factory.implementation.SlackNotification;
import com.designpatterns.factory.model.Notification;

/**
 * Concrete Creator
 */
public class SlackNotificationCreator extends NotificationCreator {

  @Override
  public Notification createNotification() {
    return new SlackNotification();
  }
}
