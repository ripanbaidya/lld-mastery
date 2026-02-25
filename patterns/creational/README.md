![creational-design-pattern](/resources/images/patterns/creational/banner.png)

<p align="right"><b>Last Updated:</b> 25.02.2026</p>

## Introduction 🔥

Creational Design Patterns are a category of **Design Patterns** that deal with **object creation mechanisms**.

Instead of creating objects directly using `new`, these patterns provide **flexible, reusable, and controlled ways** to create objects.

In simple words:

> Creational patterns focus on **how objects are created**.

They help you:

- Reduce tight coupling
- Improve flexibility
- Encapsulate object creation logic
- Follow SOLID principles (especially SRP & OCP)

## Why Do We Need Creational Patterns? 🤔

Imagine you are building a backend system. <br>
If everywhere in your code you write:

```java
PaymentService paymentService = new PaymentService();
```

Now later:

- You want to change implementation
- Add logging
- Switch to another provider
- Add caching
- Return a different subclass

You will have to change code everywhere.

❌ Tight coupling <br>
❌ Hard to extend <br>
❌ Violates OCP <br>

Creational patterns solve this.

## Types of Creational Design Patterns 📚

<p>There are <b>5 Creational Patterns</b> defined in the famous book <span style="color: red;">Design Patterns: Elements of Reusable Object-Oriented Software</span>Also known as <b>Gang of Four (GoF)</b> patterns.</p>

Here are the **5 creational patterns**:

| Pattern          | Purpose                                       |
| ---------------- | --------------------------------------------- |
| Singleton        | Ensure only one instance exists               |
| Factory Method   | Create objects without specifying exact class |
| Abstract Factory | Create families of related objects            |
| Builder          | Build complex objects step by step            |
| Prototype        | Clone existing objects                        |

### 1️⃣ [Singleton Pattern](/patterns/creational/singleton/)

**Purpose:** Ensure a class has **only one instance** and provide global access to it.

**Real-world Example:**

- Database connection
- Logger
- Configuration manager

### 2️⃣ [Factory Method Pattern](/patterns/creational/factory/)

**Purpose:** Create objects without exposing the creation logic.

### 3️⃣ [Abstract Factory Pattern](/patterns/creational/abstract-factory/)

**Purpose:** Create families of related objects.

Example:

- GUI library: Windows Button + Windows Checkbox
- Mac Button + Mac Checkbox

Instead of creating one object,
you create a **family of related objects**.

Used when:

- You need consistency between objects
- System should be independent of how products are created

### 4️⃣ [Builder Pattern](/patterns/creational/builder/)

**Purpose:** Build complex objects step by step.

Example:
Creating a `User` object with many optional fields.

```java
User user = new User.Builder("Ripan")
                    .age(21)
                    .email("ripan@email.com")
                    .build();
```

Used when:

- Too many constructor parameters
- Optional parameters
- Immutable objects

### 5️⃣ [Prototype Pattern](/patterns/creational/prototype/)

**Purpose:** Create new objects by cloning existing ones.

Instead of:

```java
new Object();
```

You clone:

```java
Object copy = original.clone();
```

Used when:

- Object creation is expensive
- Many similar objects are needed

## When to Use Creational Patterns? 🤔

Use them when:

✔ Object creation logic is complex <br>
✔ You want loose coupling <br>
✔ You follow SOLID <br>
✔ You want scalable architecture <br>
✔ You want clean, maintainable code <br>

## 🎯 Conclusion

Creational Patterns help you:

- Control object creation
- Reduce dependency
- Improve flexibility
- Write scalable code

## Resources 📚

🔗 https://codewitharyan.com/tech-blogs/creational-design-pattern-introduction <br>
