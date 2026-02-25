# Singleton Pattern

<p align="right"><b>Last Updated: 25.02.2026</b></p>

## 🔥 Introduction

Singleton is a **Creational Design** Pattern that ensures:

- Only one instance of a class exists
- Provides a global access point to that instance
- It controls object creation.

In many applications, we need **exactly one instance** of a class throughout the entire lifecycle of the application.

**Creating multiple instances may lead to:**

- ⚠️ Inconsistent state
- 🔥 Resource conflicts
- 🧠 Unnecessary memory usage
- 🔌 Duplicate database connections

## 📌 Problem

Imagine, You are building a **backend system** where:

📂 The application reads configuration from a file <br>
🔄 Multiple services need access to the same configuration

Now think about what happens if **every service creates its own configuration object**:

- 📖 The file will be read multiple times
- 💾 Memory will be wasted
- ❌ Application state may become inconsistent

**That’s inefficient and risky.**

**_🚨 We Need_**

- ✅ Only **one configuration object**
- 🌍 Accessible globally
- 🧵 Thread-safe
- ⚡ Efficient and optimized

## Solution 💡

The Solution to the above problem is **Singleton Design Pattern**,
It **ensures** that:

- 🏗 Only one instance of a class is created
- 🔐 Controlled access to that instance
- 🌎 A global access point
- 🧵 Thread safety (when implemented properly)

## Core Components ⚙️

| Component            | Responsibility                  |
| -------------------- | ------------------------------- |
| Singleton Class      | Holds the single instance       |
| Private Constructor  | Prevents external instantiation |
| Static Access Method | Returns the single instance     |

## UML

![singleton-uml](/resources/images/patterns/creational/singleton-uml.png)

> 🧠 **Mental model**: **Private constructor + static instance + static accessor**

## Code 🧑‍💻

### 1️⃣ Eager Initialization

```java
package com.designpatterns.singleton;

public class EagerSingleton {

  private static final EagerSingleton INSTANCE = new EagerSingleton();

  // Prevent Instantiation
  private EagerSingleton() {
  }

  public static EagerSingleton getInstance() {
    return INSTANCE;
  }
}

```

### Lazy Initialization (NOT Thread-Safe ❌)

```java
package com.designpatterns.singleton;

public class LazySingleton {

  private static LazySingleton instance = null;

  // Prevent Instantiation
  private LazySingleton() {
  }

  public static LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }
}
```

❌ Breaks in multithreaded environment

### 3 Thread-Safe (Synchronized Method)

```java
package com.designpatterns.singleton;

public class ThreadSafeSingleton {

  private static ThreadSafeSingleton instance = null;

  // Prevent Instantiation
  private ThreadSafeSingleton() {
  }

  public static synchronized ThreadSafeSingleton getInstance() {
    if (instance == null) {
      instance = new ThreadSafeSingleton();
    }
    return instance;
  }
}

```

✅ Thread-safe
❌ Performance overhead

### 4 Double-Checked Locking (Best Interview Choice ⭐)

```java
package com.designpatterns.singleton;

public class DoubleCheckedLockingSingleton {

  // Volatile keyword is used for ensuring visibility of instance across threads
  private static volatile DoubleCheckedLockingSingleton instance = null;

  // Prevent Instantiation
  private DoubleCheckedLockingSingleton() {
  }

  public static DoubleCheckedLockingSingleton getInstance() {
    // First check (Non Synchronized) for Performance optimization
    if (instance == null) {
      // Synchronized on class object
      synchronized (DoubleCheckedLockingSingleton.class) {
        // Second check (Synchronized) for thread safety
        if (instance == null) {
          instance = new DoubleCheckedLockingSingleton();
        }
      }
    }
    return instance;
  }
}
```

✅ Thread-safe
✅ Lazy
✅ High performance

📌 `volatile` prevents instruction reordering

### 5. Bill Pugh (Initialization-on-Demand Holder)

```java
package com.designpatterns.singleton;

public class BillPughSingleton {

  // Prevent Instantiation
  private BillPughSingleton() {
  }

  // static inner class
  private static class Helper {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance() {
    return Helper.INSTANCE;
  }
}
```

✅ Best balance
✅ Lazy + Thread-safe
✅ No synchronization

### 6. Enum Singleton (Safest ⭐⭐)

```java
package com.designpatterns.singleton;

public enum EnumSingleton {
  
  INSTANCE;
  
  void doSomething() {
    System.out.println("Hello World");
  }
}

```

✅ Thread-safe
✅ Serialization safe
✅ Reflection safe
❌ Less flexible

## Real-World Use Cases

- Logger
- Configuration Manager
- Cache
- Thread Pool
- Database Connection Pool
- Spring Beans (default scope = singleton)

## Pros & Cons

### ✅ Pros

- Controlled access to sole instance
- Saves memory and resources
- Centralized state management

### ❌ Cons

- Global mutable state
- Hard to test and mock
- Tight coupling
- Can hide dependencies

## Common Pitfalls (VERY IMPORTANT)

### ❌ Breaking Singleton using Reflection

```java
void breakSingletonUsingReflection() throws Exception {
    // With the help of reflection we are accessing the private constructor
    Constructor<Singleton> constructors = Singleton.class.getDeclaredConstructor();

    // Making the private constructor accessible
    constructors.setAccessible(true);

    // Creating a new instance of Singleton using Singleton class itself
    // and using reflection
    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = constructors.newInstance();

    // The hashcode of both the instances will be different
    System.out.println(instance1.hashCode());
    System.out.println(instance2.hashCode());
    System.out.println(instance2.equals(instance1)); // false
}

✅ Fix:

We can use an boolean flag to which will be set to true when the instance is created. If the flag is already set, we will not create a new instance.
```

### ❌ Breaking using Serialization

```java
static void breakSingletonUsingSerialization() throws Exception {

    Singleton instance1 = Singleton.getInstance();

    // Serializing the instance
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
    oos.writeObject(instance1);
    oos.close();

    // Deserializing the instance
    ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("file"));
    Singleton instance2 = (Singleton) ooi.readObject();
    ooi.close();

    // The hashcode of both the instances will be different
    System.out.println(instance1.hashCode());
    System.out.println(instance2.hashCode());
    System.out.println(instance2.equals(instance1)); // false
}
```

✅ Fix: Singleton should implement Serializable interface and override `readResolve()` method. to return the same instance and it will prevent the singleton pattern from being broken using deserialization.

## 🤔 When to Use

- Exactly **one instance** is required
- The object represents a **shared system-wide resource**
- You need **controlled access** to that instance
- Object creation is **expensive**

## 🤕 Avoid Singleton when

- You need **multiple instances** in future
- Testing/mocking is important (Singletons make testing harder)
- The class holds mutable global state
- Dependency Injection can solve the problem better

📌 Overusing Singleton leads to **hidden global state**.

🧠 **One-liner recall**:

> “Singleton restricts a class to one instance and provides global access to it.”

## Resources

**Articles**

- https://algomaster.io/learn/lld/singleton
- https://refactoring.guru/design-patterns/singleton

**Videos**
