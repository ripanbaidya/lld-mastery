package com.designpatterns.prototype;

/**
 * Concrete Prototype Class
 */
public class Enemy implements Prototype<Enemy> {

  // Private fields
  private String type;
  private int health;
  private Weapon weapon;

  // Constructor

  public Enemy(String type, int health, Weapon weapon) {
    this.type = type;
    this.health = health;
    this.weapon = weapon;
  }

  // Set health
  public void setHealth(int health) {
    this.health = health;
  }

  // Get Weapon
  public Weapon getWeapon() {
    return weapon;
  }

  // Deep Copy
  @Override
  public Enemy clone() {
    return new Enemy(
        this.type,
        this.health,
        this.weapon.clone()
    );
  }

  public void printStats() {
    System.out.println(type + " [Health: " + health + ", Weapon: " + weapon + "]");
  }
}
