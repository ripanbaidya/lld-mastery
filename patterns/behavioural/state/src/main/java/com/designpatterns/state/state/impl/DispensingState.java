package com.designpatterns.state.state.impl;

import com.designpatterns.state.context.VendingMachine;
import com.designpatterns.state.state.MachineState;

class DispensingState implements MachineState {

  @Override
  public void selectItem(VendingMachine context, String itemCode) {
    System.out.println("Please wait, dispensing in progress.");
  }

  @Override
  public void insertMoney(VendingMachine context, double amount) {
    System.out.println("Please wait, dispensing in progress.");
  }

  @Override
  public void dispenseItem(VendingMachine context) {
    System.out.println("Already dispensing. Please wait.");
  }
}