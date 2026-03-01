package com.designpatterns.decorator;


public class NameTagDecorator extends GiftDecorator {

  public NameTagDecorator(Gift gift) {
    super(gift);
  }

  @Override
  public String prepare() {
    return gift.prepare() + " and a name tag";
  }
}