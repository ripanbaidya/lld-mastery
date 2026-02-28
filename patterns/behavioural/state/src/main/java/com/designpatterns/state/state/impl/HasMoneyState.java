package com.designpatterns.state.state.impl;

import com.designpatterns.state.context.VendingMachine;
import com.designpatterns.state.state.MachineState;

class HasMoneyState implements MachineState {

  @Override
  public void selectItem(VendingMachine context, String itemCode) {
    System.out.println("Cannot change item after inserting money.");
  }

  @Override
  public void insertMoney(VendingMachine context, double amount) {
    System.out.println("Money already inserted.");
  }

  @Override
  public void dispenseItem(VendingMachine context) {
    System.out.println("Dispensing item: " + context.getSelectedItem());
    context.setState(new DispensingState());
    System.out.println("Item dispensed successfully.");
    context.reset();
  }
}