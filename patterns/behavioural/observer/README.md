# Observer Pattern

<p align="right"><b>Last Updated: 27.02.2026</b></p>

## Introduction 🔥

The **Observer Design Pattern** is a **behavioral pattern** that defines a **one-to-many dependency** between objects so that when one object (the **subject**) changes its state, all its dependents (observers) are automatically notified and updated.

This pattern is useful in scenarios where:

- You have **multiple parts** of the system that need to **react to a change** in one central component.
- You want to **decouple** the publisher of data from the **subscribers** who react to it.
- You need a **dynamic**, **event-driven communication** model without hardcoding who is listening to whom.

> It is also known as **Publish–Subscribe Pattern**.

## 🧩 Real-Life Analogy

When you subscribe to a YouTube channel:

- **You** = **Observer**
- **Channel** = **Subject**
- When a new **video** is uploaded → All **subscribers** get **notified**.

Subscribers don’t constantly check.
They get notified automatically.

That is **Observer Pattern**.

## 💡 When To Use Observer Pattern

Use it when:

- One object change must notify many objects.
- You need event-driven architecture.
- You want loose coupling.
- You want dynamic subscription/unsubscription.

## Problem Statement ✴️

Imagine we are building a **stock price notification system**, Whenever a stock price changes, we need to notify:

📧 Email subscribers <br>
📱 Mobile app users <br>
📩 SMS subscribers <br>

A naive implementation might look like this:

```java
public class StockService {

    private EmailService emailService;
    private SmsService smsService;
    private MobileAppService mobileAppService;

    public void setStockPrice(double price) {

        // Update stock price internally...

        if (emailService != null) {
            emailService.send(price);
        }

        if (smsService != null) {
            smsService.send(price);
        }

        if (mobileAppService != null) {
            mobileAppService.push(price);
        }
    }
}
```

### ❌ Problem With This Approach

🔗 **Tight Coupling**: StockService directly depends on concrete notification services. <br>
❌ **Violates Open/Closed Principle (OCP)**: If we add WhatsApp notifications, we must modify StockService. <br>
🧱 **Hard to Extend**: Every new subscriber type requires changes in existing code. <br>
🧪 **Difficult to Test**: Notification logic is mixed with business logic. <br>
📉 **Poor Scalability**: As subscribers grow, the method becomes messy and unmaintainable. <br>

### ✅ Solution — Use Observer Pattern

We decouple the notification mechanism from the stock price logic.

🎯 **Key Idea**

Stock price system becomes the Subject <br>
Subscribers (Email, SMS, Mobile App) become Observers <br>
Observers register themselves <br>
Subject notifies all observers automatically when price changes <br>

## Components ⚙️

| 🏷 Component                | 🎯 Role             | 💡 Responsibility                                   |
| --------------------------- | ------------------- | --------------------------------------------------- |
| 📢 **Subject (Observable)** | Maintains state     | Keeps list of observers and notifies them on change |
| 🔔 **Observer**             | Receives updates    | Defines update contract                             |
| 🏗 **Concrete Subject**     | Implements Subject  | Stores actual state and triggers notifications      |
| 📧 **Concrete Observer**    | Implements Observer | Performs action when notified                       |
| 👤 **Client**               | Configures system   | Registers/unregisters observers                     |

🎯 **Easy Way to Remember (Interview Trick)**

📢 **Subject** → “I have data.” <br>
🔔 **Observer** → “Notify me when it changes.” <br>
🏗 **Concrete Subject** → “State changed! Notifying everyone.” <br>
📧 **Concrete Observer** → “Got the update. Taking action.” <br>
👤 **Client** → “You subscribe. You unsubscribe.” <br>

## UML

![observer-uml](/resources/images/patterns/behavioural/observer-uml.png)

## Code 💻

### Package Structure 📦

```
com.designpatterns.observer
│
├── observer
│   ├── Observer.java
│   ├── EmailObserver.java
│   ├── MobileAppObserver.java
│   └── SmsObserver.java
│
├── subject
│   ├── Subject.java
│   └── StockPriceSubject.java
│
└── Application.java
```

### 1️⃣ Observer Interface

```java
package com.designpatterns.observer.observer;

public interface Observer {

  public void update(double stockPrice);
}
```

### 2️⃣ Concrete Observers

📁 `EmailObserver.java`

```java
package com.designpatterns.observer.observer;

public class EmailObserver implements Observer {

  private final String email;

  public EmailObserver(String email) {
    this.email = email;
  }

  @Override
  public void update(double stockPrice) {
    System.out.println("Email sent to " + email
        + " with updated stock price: ₹" + stockPrice);
  }
}
```

📁 `MobileAppObserver.java`

```java
package com.designpatterns.observer.observer;

public class MobileAppObserver implements Observer {

  private final String username;

  public MobileAppObserver(String username) {
    this.username = username;
  }

  @Override
  public void update(double stockPrice) {
    System.out.println("Push notification sent to user: "
        + username + " | New Price: ₹" + stockPrice);
  }
}
```

📁 `SmsObserver.java`

```java
package com.designpatterns.observer.observer;

public class SmsObserver implements Observer {

  private final String phoneNumber;

  public SmsObserver(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public void update(double stockPrice) {
    System.out.println("SMS sent to " + phoneNumber +
        " | Updated Price: ₹" + stockPrice);
  }
}
```

### 3️⃣ Subject Interface

📁 `Subject.java`

```java
package com.designpatterns.observer.subject;

import com.designpatterns.observer.observer.Observer;

public interface Subject {

  public void registerObserver(Observer observer);

  public void removeObserver(Observer observer);

  public void notifyObservers();
}
```

### 4️⃣ Concrete Subject

📁 `StockPriceSubject.java`

```java
package com.designpatterns.observer.subject;

import com.designpatterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StockPriceSubject implements Subject {

  private final List<Observer> observers = new ArrayList<>();
  private double stockPrice;

  @Override
  public void registerObserver(Observer observer) {
    observers.add(Objects.requireNonNull(observer));
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(stockPrice);
    }
  }

  public void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
    notifyObservers();
  }
}
```

### 5️⃣ Client

📁 `Application.java`

```java
package com.designpatterns.observer;

import com.designpatterns.observer.observer.EmailObserver;
import com.designpatterns.observer.observer.MobileAppObserver;
import com.designpatterns.observer.observer.SmsObserver;
import com.designpatterns.observer.subject.StockPriceSubject;

public class ObserverApplication {
  public static void main(String[] args) {
    StockPriceSubject stockPriceSubject = new StockPriceSubject();

    // Register observers
    stockPriceSubject.registerObserver(new EmailObserver("ripan@gmail.com"));
    stockPriceSubject.registerObserver(new MobileAppObserver("ripan_user"));
    stockPriceSubject.registerObserver(new SmsObserver("1234567890"));

    // Change state
    stockPriceSubject.setStockPrice(1500.00);

    System.out.println("----- Price Updated Again -----");
    stockPriceSubject.setStockPrice(2000.00);
  }
}
```

### Output

```
Email sent to ripan@gmail.com with updated stock price: ₹1500.0
Push notification sent to user: ripan_user | New Price: ₹1500.0
SMS sent to 1234567890 | Updated Price: ₹1500.0
----- Price Updated Again -----
Email sent to ripan@gmail.com with updated stock price: ₹2000.0
Push notification sent to user: ripan_user | New Price: ₹2000.0
SMS sent to 1234567890 | Updated Price: ₹2000.0
```

## Pattern Participants 🏗

| Role              | In Our Example                                      |
| ----------------- | --------------------------------------------------- |
| Subject           | `StockPriceSubject`                                 |
| Observer          | `Observer`                                          |
| Concrete Observer | `EmailObserver`, `MobileAppObserver`, `SmsObserver` |
| Client            | `Application`                                       |

## 🧠 Push vs Pull Model (Advanced Concept)

**Push Model**: Subject pushes full data to observers (we used this).

**Pull Model**: Observer asks subject for data after notification.

Interviewers LOVE this difference.

## ⚖️ Pros and Cons

### ✅ Advantages

| 🌟 Advantage                     | 💡 Explanation                         |
| -------------------------------- | -------------------------------------- |
| 🔗 Loose coupling                | Subject doesn’t know concrete observer |
| 📢 Automatic notification        | State changes propagate automatically  |
| ➕ Easy to add new observers     | No modification in subject             |
| 🧩 Follows Open/Closed Principle | Extensible design                      |
| ⚡ Great for event systems       | Reactive architecture                  |

### ❌ Disadvantages

| ⚠ Drawback                       | 💡 Explanation                         |
| -------------------------------- | -------------------------------------- |
| 🧠 Can cause memory leaks        | If observers not removed properly      |
| 🔄 Notification chain complexity | Hard to debug large systems            |
| 🐢 Performance issue             | Too many observers can slow system     |
| ⚠ Unexpected updates             | Observers may receive frequent updates |

## 🚀 Real-World Examples

- Java `EventListener`
- Swing event model
- Spring Application Events
- Kafka consumers
- React state updates

## Conclusion 🎯

> Observer Pattern establishes a one-to-many relationship between objects so that when one object changes state, all its dependents are notified automatically. It enables loose coupling and event-driven design.

## Resources 📚

🔗 https://algomaster.io/learn/lld/observer <br>
