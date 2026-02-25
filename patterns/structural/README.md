![structural-design-pattern](/resources/images/patterns/structural/banner.png)

<p align="right"><b>Last Updated:</b> 25.02.2026</p>

## Introduction 🏗️

Structural Design Patterns focus on:

> **How classes and objects are composed to form larger structures while keeping the system flexible and efficient.**

If:

- **Creational** → How objects are created
- **Behavioral** → How objects communicate
- **Structural** → How objects are arranged & connected

These patterns help you:

- Reduce tight coupling
- Improve flexibility
- Make systems extensible
- Wrap legacy code cleanly

They are defined in **📘 Design Patterns: Elements of Reusable Object-Oriented Software**

## 📦 Types of Structural Design Patterns (7 Total)

### 1️⃣ Adapter Pattern

**📌 Purpose:** Convert one interface into another that clients expect.

**👉 Example:** Mobile charger adapter:

- Socket provides 220V
- Phone needs 5V
- Adapter converts it

**🔥 Backend Use:** Integrating third-party libraries without modifying them.

### 2️⃣ Bridge Pattern

**📌 Purpose:** Separate abstraction from implementation.

**👉 Example:** Instead of inheritance explosion:

`CircleRed`, `CircleBlue`, `SquareRed`, `SquareBlue`

Use composition.

**🔥 Backend Use:** You want independent variation of abstraction & implementation.

### 3️⃣ Composite Pattern

**📌 Purpose:** Treat individual objects and groups uniformly.

**👉 Example:** File system:

- File
- Folder (contains files & folders)

Folder contains list of Components.

**🔥 Backend Use:** Menu systems, hierarchical data, tree structures.

### 4️⃣ Decorator Pattern

**📌 Purpose:** Add new behavior dynamically without modifying class.

**👉 Example:** Coffee:

- Basic coffee
- Add milk
- Add sugar
- Add chocolate

Instead of subclass explosion.

### 5️⃣ Facade Pattern

**📌 Purpose:** Provide simple interface to complex subsystem.

**👉 Example:** Home theater system:
Instead of:

- Turn on DVD
- Turn on amplifier
- Set input
- Adjust sound

You call:

```java
homeTheater.watchMovie();
```

**🔥 Backend Use:** Service layer acting as facade over multiple services.

### 6️⃣ Flyweight Pattern

**📌 Purpose:** Reduce memory usage by sharing common objects.

**👉 Example:** Text editor:

- Characters share font objects

Instead of creating thousands of identical objects.

**Used when:**

- Many similar objects
- Memory optimization required

### 7️⃣ Proxy Pattern

**📌 Purpose:** Control access to an object. <br>
**⭐️ Types:**

- Virtual Proxy (lazy loading)
- Protection Proxy (security)
- Remote Proxy (RMI)

**👉 Example:** Lazy loading image: Object created only when needed.

**🔥 Backend Use:** Spring AOP uses proxy heavily.

## 🎯 Quick Comparison Table

| Pattern   | Solves What?                |
| --------- | --------------------------- |
| Adapter   | Interface mismatch          |
| Bridge    | Avoid inheritance explosion |
| Composite | Tree structures             |
| Decorator | Add behavior dynamically    |
| Facade    | Simplify complex subsystem  |
| Flyweight | Reduce memory usage         |
| Proxy     | Control access              |

## Conclusion ❇️

## Resources 📚

🔗 https://codewitharyan.com/tech-blogs/structural-design-pattern
