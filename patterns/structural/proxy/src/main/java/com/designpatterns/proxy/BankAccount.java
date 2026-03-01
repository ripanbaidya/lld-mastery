package com.designpatterns.proxy;

/**
 * Subject
 * This is a common interface for both RealSubject and Proxy
 */
public interface BankAccount {

  /**
   * Withdraws a specified amount from the bank account
   *
   * @param amount the amount to withdraw
   */
  void withdraw(double amount);

  /**
   * Returns the current balance of the bank account
   *
   * @return the current balance
   */
  double getBalance();
}
