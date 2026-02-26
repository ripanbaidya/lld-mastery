# Factory Method Pattern

<p align="right"><b>Last Updated: 26.02.2026</b></p>

![factory-banner](/resources/images/patterns/creational/factory-banner.png)

## Introduction 🔥

Factory Method Pattern defines an **interface for creating an object**, but lets subclasses decide **which class to
instantiate**.

It promotes:

- ✅ Loose Coupling
- ✅ Open/Closed Principle
- ✅ Clean Object Creation Logic

## Problem 🤔

Suppose we have a **notification system** that **sends notifications via email or push notifications**.

The notification system should be **flexible** enough to **support different notification** types in the future without modifying the existing code.

## Solution 🎯

Factory Method Pattern can be used to create a **flexible notification system** that can be **extended** with new notification types **in the future**.

## Components ⚙️

1️⃣ **Product (Interface)**: The **interface** or **abstract class** that defines the **contract** for all objects the factory method creates. Every concrete product implements this interface, which means the rest of the system can work with any product without knowing its concrete type.

2️⃣ **Concrete Products**: The actual classes that implement the Product interface. Each one provides its own behavior.

3️⃣ **Creator (Abstract Factory)**: An abstract class or interface that Declares the factory method, which returns an object of type Product. It can also contain common logic that depends on the product.

4️⃣ **Concrete Creators**: Implement the factory method to return a specific product. These classes are responsible for creating objects of a specific type.

5️⃣ **Client**: The client code that uses the factory method to create objects without knowing the specific class of the object.

## UML

![factory-method-uml](/resources/images/patterns/creational/factory-uml.png)

## Code 🧑‍💻

### **Package Structure** 📦

```
com.designpatterns.factory

├── model
│   └── Notification.java
│
├── implementation
│   ├── EmailNotification.java
│   └── PushNotification.java
│
├── factory
│   ├── NotificationFactory.java
│   ├── EmailNotificationFactory.java
│   ├── PushNotificationFactory.java
│   └── SimpleNotificationFactory.java
│
└── client
    └── FactoryApplication.java
```

**Step By Step Implementation**

### 1️⃣ **Product Interface**

```java
package com.designpatterns.factory.model;

public interface Notification {

  void send(String message);
}
```

### **2️⃣ Concrete Products**

**Email Notification** 📧

```java
package com.designpatterns.factory.implementation;

import com.designpatterns.factory.model.Notification;

public class EmailNotification implements Notification {

  @Override
  public void send(String message) {
    System.out.println("Sending Email Notification: " + message);
  }
}
```

**Push Notification** 📱

```java
package com.designpatterns.factory.implementation;

import com.designpatterns.factory.model.Notification;

public class PushNotification implements Notification {

  @Override
  public void send(String message) {
    System.out.println("Sending Push Notification: " + message);
  }
}
```

### 3️⃣ **Simple Factory** **(Not GoF, but commonly used)**

⚠️ This is **NOT** the Factory Method pattern officially, It centralizes object creation using **condition logic**.

```java
package com.designpatterns.factory.factory;

import com.designpatterns.factory.model.Notification;
import com.designpatterns.factory.implementation.EmailNotification;
import com.designpatterns.factory.implementation.PushNotification;

public class SimpleNotificationFactory {

  public static Notification createNotification(String type) {

    return switch (type.toUpperCase()) {
      case "EMAIL" -> new EmailNotification();
      case "PUSH" -> new PushNotification();
      default -> throw new IllegalArgumentException("Invalid notification type");
    };
  }
}
```

🚨 **Problem**: Violates **Open/Closed Principle** (needs modification when new type is added).

### 4️⃣ **Creator (Factory Method Pattern Core)**

```java
package com.ripan.designpatterns.factory.factory;

import com.ripan.designpatterns.factory.model.Notification;

public abstract class NotificationFactory {

  protected abstract Notification createNotification();

  public void sendNotification(String message) {
    Notification notification = createNotification();
    notification.send(message);
  }
}
```

### 5️⃣ **Concrete Factories**

**Email Factory** 📧

```java
package com.designpatterns.factory.factory;

import com.designpatterns.factory.model.Notification;
import com.designpatterns.factory.implementation.EmailNotification;

public class EmailNotificationFactory extends NotificationFactory {

  @Override
  protected Notification createNotification() {
    return new EmailNotification();
  }
}
```

**Push Factory** 📱

```java
package com.designpatterns.factory.factory;

import com.designpatterns.factory.model.Notification;
import com.designpatterns.factory.implementation.PushNotification;

public class PushNotificationFactory extends NotificationFactory {

  @Override
  protected Notification createNotification() {
    return new PushNotification();
  }
}
```

### 6️⃣ **Client Code**

```java
package com.designpatterns.factory.client;

import com.designpatterns.factory.factory.EmailNotificationFactory;
import com.designpatterns.factory.factory.NotificationFactory;
import com.designpatterns.factory.factory.PushNotificationFactory;

public class FactoryApplication {
  public static void main(String[] args) {

    NotificationFactory creator = null;

    // Email notification
    creator = new EmailNotificationFactory();
    creator.sendNotification("You got offer from Amazon!");

    // Push notification
    creator = new PushNotificationFactory();
    creator.sendNotification("Congratulations!!");
  }
}
```

## Why Factory Method is Better Than Simple Factory?

| Simple Factory    | Factory Method         |
| ----------------- | ---------------------- |
| Uses `if/switch`  | Uses Polymorphism      |
| Violates OCP      | Follows OCP            |
| Centralized logic | Decentralized creation |
| Harder to extend  | Easy to extend         |

## 🧠 When To Use Factory Method?

Use it when:

- Object creation logic is complex
- You want loose coupling
- You want to follow Open/Closed Principle
- The client should not know concrete classes
- Creation varies based on subclass

## Conclusion

Factory Method Pattern is a **flexible** and **extensible** design pattern that can be used to create objects in a **loose coupled** way.

## Resources

🔗 https://algomaster.io/learn/lld/factory-method <br>
🔗 https://refactoring.guru/design-patterns/factory-method
