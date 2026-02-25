package com.designpatterns.singleton;

public class EagerSingleton {

  private static final EagerSingleton INSTANCE = new EagerSingleton();

  // Prevent Instantiation
  private EagerSingleton() {
  }

  public static EagerSingleton getInstance() {
    return INSTANCE;
  }
}
