package com.designpatterns.observer.observer;

/**
 * Concrete Observer - SMS Notification
 */
public class SmsObserver implements Observer {

  private final String phoneNumber;

  public SmsObserver(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public void update(double stockPrice) {
    System.out.println("SMS sent to " + phoneNumber +
        " | Updated Price: ₹" + stockPrice);
  }
}