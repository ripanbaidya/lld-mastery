package com.designpatterns.state;

import com.designpatterns.state.context.VendingMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ripan Baidya
 */
@SpringBootApplication
public class StateApplication {
  public static void main(String[] args) {
    // SpringApplication.run(StateApplication.class, args);
    VendingMachine vm = new VendingMachine();

    vm.insertCoin(1.0);   // Rejected: no item selected
    vm.selectItem("A1");  // Transitions to ItemSelectedState
    vm.insertCoin(1.5);   // Transitions to HasMoneyState
    vm.dispenseItem();    // Dispenses, resets to IdleState

    System.out.println("\n--- Second Transaction ---");
    vm.selectItem("B2");
    vm.insertCoin(2.0);
    vm.dispenseItem();
  }
}
