package com.designpatterns.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyApplication {
  public static void main(String[] args) {
    // SpringApplication.run(ProxyApplication.class, args);

    BankAccount bankAccount = new ATMProxy();

    // Note: Client doesn't know whether it's proxy or real

    // Withdraw amount
    bankAccount.withdraw(1000.0);

    // Check bank balance
    System.out.println("Balance: " + bankAccount.getBalance());
  }
}
