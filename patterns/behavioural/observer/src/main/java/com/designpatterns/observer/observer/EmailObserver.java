package com.designpatterns.observer.observer;

/**
 * Concrete Observer - Email Notification
 * Implements the Observer interface to receive stock price updates via email
 * and send notifications to subscribers.
 */
public class EmailObserver implements Observer {

  private final String email;

  public EmailObserver(String email) {
    this.email = email;
  }

  @Override
  public void update(double stockPrice) {
    System.out.println("Email sent to " + email
        + " with updated stock price: ₹" + stockPrice);
  }
}
