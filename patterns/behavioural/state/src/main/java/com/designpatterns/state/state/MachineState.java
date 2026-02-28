package com.designpatterns.state.state;

import com.designpatterns.state.context.VendingMachine;

/**
 * State Interface
 */
public interface MachineState {

  public void selectItem(VendingMachine context, String itemCode);

  public void insertMoney(VendingMachine context, double money);

  public void dispenseItem(VendingMachine context);
}
