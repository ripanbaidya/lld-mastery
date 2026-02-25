package com.designpatterns.singleton;

public class DoubleCheckedLockingSingleton {

  // Volatile keyword is used for ensuring visibility of instance across threads
  private static volatile DoubleCheckedLockingSingleton instance = null;

  // Prevent Instantiation
  private DoubleCheckedLockingSingleton() {
  }

  public static DoubleCheckedLockingSingleton getInstance() {
    // First check (Non Synchronized) for Performance optimization
    if (instance == null) {
      // Synchronized on class object
      synchronized (DoubleCheckedLockingSingleton.class) {
        // Second check (Synchronized) for thread safety
        if (instance == null) {
          instance = new DoubleCheckedLockingSingleton();
        }
      }
    }
    return instance;
  }
}
