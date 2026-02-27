package com.designpatterns.prototype;

public class Weapon implements Prototype<Weapon> {

  // Private fields
  private String name;
  private int damage;

  // Constructor
  public Weapon(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }

  // Setters
  public void setDamage(int damage) {
    this.damage = damage;
  }

  // Implementation of the clone method from the Prototype interface
  // Deep Copy
  @Override
  public Weapon clone() {
    return new Weapon(this.name, this.damage);
  }

  @Override
  public String toString() {
    return "Weapon{" + "name='" + name + '\'' + ", damage=" + damage + '}';
  }
}
