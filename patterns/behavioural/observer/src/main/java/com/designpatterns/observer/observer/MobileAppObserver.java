package com.designpatterns.observer.observer;

/**
 * Concrete Observer - Mobile App Notification
 */
public class MobileAppObserver implements Observer {

  private final String username;

  public MobileAppObserver(String username) {
    this.username = username;
  }

  @Override
  public void update(double stockPrice) {
    System.out.println("Push notification sent to user: "
        + username + " | New Price: ₹" + stockPrice);
  }
}