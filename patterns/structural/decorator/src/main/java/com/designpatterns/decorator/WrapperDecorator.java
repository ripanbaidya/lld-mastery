package com.designpatterns.decorator;

public class WrapperDecorator extends GiftDecorator {

  public WrapperDecorator(Gift gift) {
    super(gift);
  }

  @Override
  public String prepare() {
    return gift.prepare() + " wrapped in paper";
  }
}