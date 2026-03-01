package com.designpatterns.proxy;

/**
 * Proxy
 * This is a proxy object that controls access to the RealSubject.
 */
public class ATMProxy implements BankAccount {
  private final RealBankAccount realBankAccount;

  public ATMProxy() {
    this.realBankAccount = new RealBankAccount();
  }

  @Override
  public void withdraw(double amount) {
    // Add additional logging or monitoring
    // Maybe some additional validation
    if (amount > 5000.0) {
      System.out.println("Withdrawal limit exceed!");
    } else if (amount > realBankAccount.getBalance()) {
      System.out.println("Insufficient Balance!");
    }
    realBankAccount.withdraw(amount);
  }

  @Override
  public double getBalance() {
    return realBankAccount.getBalance();
  }
}
