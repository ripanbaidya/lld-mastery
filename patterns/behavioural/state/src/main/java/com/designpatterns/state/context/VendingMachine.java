package com.designpatterns.state.context;

import com.designpatterns.state.state.MachineState;
import com.designpatterns.state.state.impl.IdleState;

public class VendingMachine {
  private MachineState currentState;
  private String selectedItem;
  private double insertedAmount;

  public VendingMachine() {
    this.currentState = new IdleState();
  }

  public void setState(MachineState newState) {
    this.currentState = newState;
  }

  public void setSelectedItem(String itemCode) {
    this.selectedItem = itemCode;
  }

  public void setInsertedAmount(double amount) {
    this.insertedAmount = amount;
  }

  public String getSelectedItem() {
    return selectedItem;
  }

  public void selectItem(String itemCode) {
    currentState.selectItem(this, itemCode);
  }

  public void insertCoin(double amount) {
    currentState.insertMoney(this, amount);
  }

  public void dispenseItem() {
    currentState.dispenseItem(this);
  }

  public void reset() {
    this.selectedItem = "";
    this.insertedAmount = 0.0;
    this.currentState = new IdleState();
  }
}