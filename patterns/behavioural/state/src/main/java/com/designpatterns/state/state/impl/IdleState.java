package com.designpatterns.state.state.impl;

import com.designpatterns.state.context.VendingMachine;
import com.designpatterns.state.state.MachineState;

public class IdleState implements MachineState {

  @Override
  public void selectItem(VendingMachine context, String itemCode) {
    System.out.println("Item selected: " + itemCode);
    context.setSelectedItem(itemCode);
    context.setState(new ItemSelectedState());
  }

  @Override
  public void insertMoney(VendingMachine context, double amount) {
    System.out.println("Please select an item before inserting coins.");
  }

  @Override
  public void dispenseItem(VendingMachine context) {
    System.out.println("No item selected. Nothing to dispense.");
  }
}