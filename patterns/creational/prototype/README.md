# Prototype Pattern

<p align="right"><b>Last Updated: 27.02.2026</b></p>

## Introduction 🔥

The **Prototype Design Pattern** is a **Creational Design Pattern**.

👉 It **allows us to create new objects by copying an existing object**, instead of creating them from scratch using **new** keyword.

**It is useful when:**

- Object creation is **expensive**
- Objects have **complex initialization**
- Many objects share a **similar structure**

So, The **Key idea** is **“Create once → clone many times”**

## Problem 🧩

Suppose, we are building a **Game Engine**, where each enemy object contains: `Type`, `Health`, `Weapon`, `Armor`, `Speed`, `Special abilities`, `AI behavior configuration` and etc.

➡️ Creating an Enemy object from scratch is:

- **Time-consuming**
- **Configuration-heavy**
- **Contains many nested objects (Weapon, Armor, AI, etc.)**
- **Requires loading data from files / database**
- **May involve expensive resource initialization**

**So, The Problem is:** If we need to create **100 enemies** of the same type (e.g., Zombie Minions) where:

- Only `health` differs
- Maybe `weapon damage` differs
- Everything else is same

Then we are:

- Repeating object creation logic
- Repeating heavy configuration
- Increasing CPU & memory overhead
- Making the code messy
- Duplicating initialization logic

Example (Without Prototype):

```java
Enemy minion1 = new Enemy("Zombie", 100, new Weapon("Claws", 10));
Enemy minion2 = new Enemy("Zombie", 120, new Weapon("Claws", 10));
Enemy minion3 = new Enemy("Zombie", 90, new Weapon("Claws", 10));
...
```

This becomes repetitive and error-prone.

### ✅ What We Want

- A base Enemy template (e.g., Zombie Boss template)
- Quickly generate copies
- Modify only required fields (like health)
- Avoid rebuilding everything from scratch
- Keep code clean and maintainable

### 🤯 Problems Without Prototype Pattern

If we don’t use Prototype:

- Tight coupling between creation logic and client
- Object creation logic scattered everywhere
- Performance overhead due to repeated heavy initialization
- Hard to maintain
- Repeated configuration code
- Higher chance of bugs

### 😎 How Prototype Pattern Solves It

With Prototype:

1. Create one fully configured base object.
2. Clone it whenever needed.
3. Modify only required properties.

Example:

```java
Enemy zombieTemplate = new Enemy("Zombie", 500, new Weapon("Claws", 50));

Enemy minion = zombieTemplate.clone();
minion.setHealth(100);
minion.getWeapon().setDamage(10);
```

✔ No repeated configuration
✔ Faster object creation
✔ Cleaner client code
✔ Easier maintenance
✔ Better scalability

## 🤖 Shallow vs Deep Copy

Before procedding further, It's imporant to know about **shallow copy** and **deep copy**.

### Shallow Copy 🤖

The shallow copy **Copies primitive fields**, **Copies reference addresses for objects** and here **Nested objects are shared**

**Example:**

```java
class Resume implements Cloneable {

  String name;
  List<String> skills;

  public Resume(String name, List<String> skills) {
    this.name = name;
    this.skills = skills;
  }

  @Override
  protected Resume clone() throws CloneNotSupportedException {
    return (Resume) super.clone(); // Shallow Copy
  }

  @Override
  public String toString() {
    return "Resume{" + "name='" + name + '\'' + ", skills=" + skills + '}';
  }
}

public class Main {
  public static void main(String[] args) throws CloneNotSupportedException {
    Resume resume1 = new Resume("Ripan Baidya",
        new ArrayList<>(Arrays.asList("Java", "Go"))
    );

    // Creating copy
    Resume resume2 = resume1.clone();

    // Make some changes
    resume2.skills.remove("Go");
    resume2.name = "John Doe";

    System.out.println(resume1);
    System.out.println(resume2);
  }
}
```

**Output:**

```java
Resume{name='Ripan Baidya', skills=[Java]}
Resume{name='John Doe', skills=[Java]}
```

**Problem:** Nested objects are shared.

### Deep Copy

The deep copy **Copies primitive fields**, **Create new copy of nested objects** and here **No references are shared**

**Example**

```java
class Resume implements Cloneable {

  String name;
  List<String> skills;

  public Resume(String name, List<String> skills) {
    this.name = name;
    this.skills = skills;
  }


  // Deep Copy
  @Override
  protected Resume clone() throws CloneNotSupportedException {
    Resume cloned = (Resume) super.clone(); // Shallow copy first
    cloned.skills = new ArrayList<>(this.skills); // Deep copy of list
    return cloned;
  }

  @Override
  public String toString() {
    return "Resume{" + "name='" + name + '\'' + ", skills=" + skills + '}';
  }
}

public class ShallowAndDeepCopyExample {
  public static void main(String[] args) throws CloneNotSupportedException {
    Resume resume1 = new Resume("Ripan Baidya",
        new ArrayList<>(Arrays.asList("Java", "Go"))
    );

    // Creating copy
    Resume resume2 = resume1.clone();

    // Apply changes
    resume2.skills.remove("Go");
    resume2.name = "John Doe";

    System.out.println(resume1);
    System.out.println(resume2);
  }
}
```

**Output:**

```java
Resume{name='Ripan Baidya', skills=[Java, Go]}
Resume{name='John Doe', skills=[Java]}
```

👉 **In interviews, always say:**

“Prefer custom deep copy instead of Java’s default clone because clone() gives shallow copy by default.”

## Components ⚙️

| Component                                        | Responsibility             |
| ------------------------------------------------ | -------------------------- |
| prototype.Prototype (Interface / Abstract Class) | Declares clone method      |
| ConcretePrototype                                | Implements cloning logic   |
| Client                                           | Creates objects by cloning |

## UML

<img src="/resources/images/patterns/creational/prototype-uml.png" height="350" width="550" style="display: block; margin: 0 auto;"/>

## Code

1️⃣ **Prototype Interface**

```java
package com.designpatterns.prototype;

public interface Prototype<T> {

  T clone();
}
```

2️⃣ **ConcretePrototype**

```java
package com.designpatterns.prototype;

public class Weapon implements Prototype<Weapon> {

  private String name;
  private int damage;

  public Weapon(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  @Override
  public Weapon clone() {
    return new Weapon(this.name, this.damage);
  }

  @Override
  public String toString() {
    return "Weapon{" + "name='" + name + '\'' + ", damage=" + damage + '}';
  }
}
```

```java
package com.designpatterns.prototype;

public class Enemy implements Prototype<Enemy> {

  private String type;
  private int health;
  private Weapon weapon;

  public Enemy(String type, int health, Weapon weapon) {
    this.type = type;
    this.health = health;
    this.weapon = weapon;
  }

  public void setHealth(int health) {
    this.health = health;
  }
  public Weapon getWeapon() {
    return weapon;
  }

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
```

3️⃣ **Client**

```java
package com.designpatterns.prototype;

public class PrototypeApplication {
  public static void main(String[] args) {

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
```

**Output:**

```
Zombie [Health: 500, Weapon: Weapon{name='Claws', damage=50}]
Zombie [Health: 100, Weapon: Weapon{name='Claws', damage=10}]
```

## Real-World Use Cases 🌐

1. Resume Template System
2. Game Characters (Enemy cloning)
3. Document Templates (Word template duplication)
4. UI Components (Clone styled button)

## When to Use & When Not to Use 🎯

| 🚀 **Use Prototype When**                                 | 🚫 **Avoid Prototype When**                            |
| --------------------------------------------------------- | ------------------------------------------------------ |
| 🧠 Object creation is **expensive or complex**            | ⚡ Objects are **simple and cheap** to create          |
| 🧬 You need **many similar objects**                      | 🧩 Deep cloning is **hard or risky**                   |
| 🏗 You want to avoid **subclass explosion**               | 🌳 Object graph is **very complex**                    |
| 🔁 Configuration is mostly same with **small variations** | 🧊 Objects are **immutable** and don’t require copying |
| 🎮 Heavy initialization (DB, file, API calls)             | 🛠 Standard constructors are sufficient                |

## Pros & Cons

| ✅ **Pros**                                      | ❌ **Cons**                                                     |
| ------------------------------------------------ | --------------------------------------------------------------- |
| ⚡ Faster object creation                        | 🧠 Deep cloning can be difficult                                |
| 🧱 Reduces subclassing                           | 🧩 Cloning complex object graphs is error-prone                 |
| 🔗 Decouples client from concrete classes        | ⚠ Copying mutable objects needs extra care                      |
| 🚀 Improves performance in heavy object creation | 🐞 Risk of shared references (if shallow copy used incorrectly) |
| 🎯 Cleaner object creation logic                 | 📉 May increase memory usage if overused                        |

## Summary

> **Use prototype.Prototype when object creation is expensive and you need many similar objects by cloning instead of creating from scratch.**

## Resources

🔗 https://algomaster.io/learn/lld/prototype <br>
🔗 https://refactoring.guru/design-patterns/prototype <br>
🔗 https://www.baeldung.com/java-pattern-prototype <br>
🎥 https://youtu.be/mTelfA9ccXE [Video]
