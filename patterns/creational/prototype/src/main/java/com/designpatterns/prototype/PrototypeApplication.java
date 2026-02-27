package com.designpatterns.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeApplication {
  public static void main(String[] args) {
    // SpringApplication.run(PrototypeApplication.class, args);
    // Create a prototype
    Weapon weapon = new Weapon("Claws", 50);
    Enemy zombie = new Enemy("Zombie", 500, weapon);

    // Clone the prototype
    Enemy zombie2 = zombie.clone();
    zombie2.setHealth(100);
    zombie2.getWeapon().setDamage(10);

    // Print stats
    zombie.printStats();
    zombie2.printStats();
  }
}
