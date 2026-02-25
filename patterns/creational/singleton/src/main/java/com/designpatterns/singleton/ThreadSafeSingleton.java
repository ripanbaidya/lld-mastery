package com.designpatterns.singleton;

public class ThreadSafeSingleton {

  private static ThreadSafeSingleton instance = null;

  // Prevent Instantiation
  private ThreadSafeSingleton() {
  }

  public static synchronized ThreadSafeSingleton getInstance() {
    if (instance == null) {
      instance = new ThreadSafeSingleton();
    }
    return instance;
  }
}
