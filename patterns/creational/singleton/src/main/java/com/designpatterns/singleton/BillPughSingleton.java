package com.designpatterns.singleton;

public class BillPughSingleton {

  // Prevent Instantiation
  private BillPughSingleton() {
  }

  // static inner class
  private static class Helper {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance() {
    return Helper.INSTANCE;
  }
}
