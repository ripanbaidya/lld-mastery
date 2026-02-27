package com.designpatterns.observer.subject;

import com.designpatterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Concrete Subject implementation for stock price monitoring.
 * This class maintains a list of observers and notifies them when the stock price changes.
 * Implements the Subject interface as part of the Observer design pattern.
 */
public class StockPriceSubject implements Subject {

  // List to store all registered observers
  private final List<Observer> observers = new ArrayList<>();
  // Current stock price value
  private double stockPrice;

  /**
   * Registers a new observer to receive stock price updates.
   *
   * @param observer The observer to be registered (must not be null)
   * @throws NullPointerException if observer is null
   */
  @Override
  public void registerObserver(Observer observer) {
    observers.add(Objects.requireNonNull(observer));
  }

  /**
   * Removes an observer from the notification list.
   *
   * @param observer The observer to be removed
   */
  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * Notify all registered observers about the change in stock price.
   * Iterates through all observers and calls their update method with the current stock price.
   */
  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(stockPrice);
    }
  }

  /**
   * Sets a new stock price and automatically notifies all observers.
   * This method triggers the notification mechanism to inform all registered observers
   * about the price change.
   *
   * @param stockPrice The new stock price value
   */
  public void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
    notifyObservers();
  }
}