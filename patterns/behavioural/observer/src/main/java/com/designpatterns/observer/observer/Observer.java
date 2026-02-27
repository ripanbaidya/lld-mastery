package com.designpatterns.observer.observer;

/**
 * Observer Interface
 * This interface defines the contract for observers in the Observer design pattern.
 * Classes implementing this interface will be notified when the subject's state changes.
 * The observer receives updates about stock price changes and can react accordingly.
 */
public interface Observer {

  /**
   * Called when the observed subject's state changes
   *
   * @param stockPrice the new stock price value
   */
  public void update(double stockPrice);
}