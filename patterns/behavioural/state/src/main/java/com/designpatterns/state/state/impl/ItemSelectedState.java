package com.designpatterns.state.state.impl;

import com.designpatterns.state.context.VendingMachine;
import com.designpatterns.state.state.MachineState;

class ItemSelectedState implements MachineState {

  @Override
  public void selectItem(VendingMachine context, String itemCode) {
    System.out.println("Item already selected: " + context.getSelectedItem());
  }

  @Override
  public void insertMoney(VendingMachine context, double amount) {
    System.out.println("Inserted $" + amount + " for item: " + context.getSelectedItem());
    context.setInsertedAmount(amount);
    context.setState(new HasMoneyState());
  }

  @Override
  public void dispenseItem(VendingMachine context) {
    System.out.println("Insert coin before dispensing.");
  }
}