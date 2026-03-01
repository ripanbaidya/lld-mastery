package com.designpatterns.decorator;

public abstract class GiftDecorator implements Gift {

  protected final Gift gift;

  protected GiftDecorator(Gift gift) {
    this.gift = gift;
  }
}
