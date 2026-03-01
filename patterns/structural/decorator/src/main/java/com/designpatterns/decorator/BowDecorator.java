package com.designpatterns.decorator;

public class BowDecorator extends GiftDecorator {

  public BowDecorator(Gift gift) {
    super(gift);
  }

  @Override
  public String prepare() {
    return gift.prepare() + " with a bow";
  }
}