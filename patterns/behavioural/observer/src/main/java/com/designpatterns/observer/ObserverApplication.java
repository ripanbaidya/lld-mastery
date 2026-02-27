package com.designpatterns.observer;

import com.designpatterns.observer.observer.EmailObserver;
import com.designpatterns.observer.observer.MobileAppObserver;
import com.designpatterns.observer.observer.SmsObserver;
import com.designpatterns.observer.subject.StockPriceSubject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverApplication {
  public static void main(String[] args) {
//    SpringApplication.run(ObserverApplication.class, args);
    StockPriceSubject stockPriceSubject = new StockPriceSubject();

    // Register observers
    stockPriceSubject.registerObserver(new EmailObserver("ripan@gmail.com"));
    stockPriceSubject.registerObserver(new MobileAppObserver("ripan_user"));
    stockPriceSubject.registerObserver(new SmsObserver("1234567890"));

    // Change state
    stockPriceSubject.setStockPrice(1500.00);

    System.out.println("----- Price Updated Again -----");
    stockPriceSubject.setStockPrice(2000.00);
  }
}
