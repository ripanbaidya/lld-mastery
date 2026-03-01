package com.designpatterns.decorator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DecoratorApplication {
  public static void main(String[] args) {
    // SpringApplication.run(DecoratorApplication.class, args);
    Gift gift = new Watch("Peter England");
    System.out.println(gift.prepare());

    Gift wrappedGift = new WrapperDecorator(gift);
    System.out.println(wrappedGift.prepare());

    Gift wrappedBowGift = new BowDecorator(new WrapperDecorator(gift));
    System.out.println(wrappedBowGift.prepare());

    Gift fullyDecoratedGift = new NameTagDecorator(new BowDecorator(new WrapperDecorator(gift)));

    System.out.println(fullyDecoratedGift.prepare());
  }
}
