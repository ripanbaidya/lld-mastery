package com.designpatterns.observer.subject;

import com.designpatterns.observer.observer.Observer;

/**
 * Subject interface for the Observer design pattern.
 * Defines the contract for objects that can be observed by multiple observers.
 * Provides methods to manage observer registration and notification.
 */
public interface Subject {

  /**
   * Registers an observer to receive notifications when the subject's
   * state changes.
   *
   * @param observer the observer to be registered
   */
  public void registerObserver(Observer observer);

  /**
   * Removes an observer from the notification list.
   *
   * @param observer the observer to be removed
   */
  public void removeObserver(Observer observer);

  /**
   * Notifies all registered observers about state changes in the subject.
   */
  public void notifyObservers();
}