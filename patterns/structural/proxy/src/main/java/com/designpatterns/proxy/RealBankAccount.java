package com.designpatterns.proxy;

/**
 * RealSubject
 * This is the actual object that performs the withdrawal operation
 */
public class RealBankAccount implements BankAccount {
  /**
   * Note: Here I have used hard-coded balance to simplify the demonstration,
   * but, In real world application the value or balance in our case will be
   * respected to a specific use and that value will be fetched from database
   * or api or any other source.
   */
  private static double balance = 10000;

  /**
   * Withdraws a specified amount from the bank account
   */
  @Override
  public void withdraw(double amount) {
    balance -= amount;
    System.out.println("Withdrawal successful");
  }

  /**
   * Returns the current balance of the bank account
   */
  @Override
  public double getBalance() {
    return balance;
  }
}
