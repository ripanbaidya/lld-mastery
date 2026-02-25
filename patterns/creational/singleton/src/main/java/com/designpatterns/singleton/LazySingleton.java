package com.designpatterns.singleton;

public class LazySingleton {

  private static LazySingleton instance = null;

  // Prevent Instantiation
  private LazySingleton() {
  }

  public static LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }
}
