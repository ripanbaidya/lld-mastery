# Strategy Pattern

<p align="right"><b>Last Updated: 27.02.2026</b></p>

## Introduction 🔥

Strategy Pattern is a **behavioral design pattern** that:

> Defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime.

It allows the algorithm to vary independently from the clients that use it.

## Real-Life Analogy 🎯

Think about **Google Maps**, when you select a route from:

> 🚗 Car <br> 🚲 Bike <br> 🚶 Walk <br>

The **navigation algorithm** changes, but the app remains the same.

👉 The routing logic is interchangeable. <br>
👉 The main system does not change. <br>
👉 You can switch behavior at runtime.

That is **Strategy Pattern**.

## Problem Statement 🧩

Imagine we are building a **E-Commerce Payment System** that supports multiple payment methods:

> 💳 **Credit Card**, 📱 **UPI**, 🏦 **PayPal** etc.

Each method has a different implementation.

### ❌ Problem Without Strategy Pattern

```java
if (paymentType.equals("CREDIT_CARD")) { ... }
else if (paymentType.equals("UPI")) { ... }
else if (paymentType.equals("PAYPAL")) { ... }
```

**Problems:**

- Violates Open/Closed Principle. ❌
- Hard to extend. ❌
- Difficult to test. ❌
- Tight coupling. ❌

### How Strategy Pattern Solves This Problem? 😎

Strategy pattern solves this problem by:

- Defining a family of algorithms.
- Encapsulating each one.
- Making them interchangeable at runtime.
- The main system does not change.
- The algorithm can vary independently from the clients that use it.

## Components ⚙️

| 🏷 Component                | 🎯 Role                 | 💡 Responsibility                |
| --------------------------- | ----------------------- | -------------------------------- |
| 🧠 **Strategy (Interface)** | Defines common contract | Declares method(s) for algorithm |
| 🏗 **Concrete Strategy**    | Implements algorithm    | Provides specific behavior       |
| 🎛 **Context**              | Uses Strategy           | Delegates execution to Strategy  |
| 👤 **Client**               | Chooses strategy        | Decides which strategy to use    |

🎯 **Easy Way To Remember**

🧠 **Strategy** = What to do <br>
🏗 **Concrete Strategy** = How to do <br>
🎛 **Context** = Uses it <br>
👤 **Client** = Chooses it <br>

## UML

![](/resources/images/patterns/behavioural/strategy-uml.png)

## Code

### **Project Structure** 📁

```
com.designpatterns.strategy
│
├── strategy
│   ├── PaymentStrategy.java
│   ├── CreditCardPaymentStrategy.java
│   ├── UpiPaymentStrategy.java
│   └── PaypalPaymentStrategy.java
│   │
│   ├── context
│   │   └── PaymentContext.java
│   │
│   └── factory
│       └── PaymentStrategyFactory.java
│
└── Application.java
```

### 1️⃣ Strategy Interface

```java
package com.designpatterns.strategy.strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {

  void pay(BigDecimal amount);
}
```

### 2️⃣ Concrete Strategy

```java
package com.designpatterns.strategy.strategy;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditCardPaymentStrategy implements PaymentStrategy {

  private final String cardNumber;
  private final String cardHolderName;

  public CreditCardPaymentStrategy(String cardNumber, String cardHolderName) {
    this.cardNumber = Objects.requireNonNull(cardNumber);
    this.cardHolderName = Objects.requireNonNull(cardHolderName);
  }

  @Override
  public void pay(BigDecimal amount) {
    System.out.println("Processing credit card payment...");
    System.out.println("Card Holder: " + cardHolderName);
    System.out.println("Amount Paid: ₹" + amount);
  }
}
```

```java
package com.designpatterns.strategy.strategy;

import java.math.BigDecimal;
import java.util.Objects;

public class UpiPaymentStrategy implements PaymentStrategy {

  private final String upiId;

  public UpiPaymentStrategy(String upiId) {
    this.upiId = Objects.requireNonNull(upiId);
  }

  @Override
  public void pay(BigDecimal amount) {
    System.out.println("Processing UPI payment...");
    System.out.println("UPI ID: " + upiId);
    System.out.println("Amount Paid: ₹" + amount);
  }
}
```

### 3️⃣ Context

```java
package com.designpatterns.strategy.context;

import com.designpatterns.strategy.strategy.PaymentStrategy;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentContext {

  private PaymentStrategy paymentStrategy;

  public PaymentContext(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = Objects.requireNonNull(paymentStrategy);
  }

  public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = Objects.requireNonNull(paymentStrategy);
  }

  public void executePayment(BigDecimal amount) {
    paymentStrategy.pay(amount);
  }
}
```

**Factory** 🏭

```java
package com.designpatterns.strategy.factory;

import com.designpatterns.strategy.strategy.CreditCardPaymentStrategy;
import com.designpatterns.strategy.strategy.PaymentStrategy;
import com.designpatterns.strategy.strategy.PaypalPaymentStrategy;
import com.designpatterns.strategy.strategy.UpiPaymentStrategy;

public final class PaymentStrategyFactory {

  private PaymentStrategyFactory() {
  }

  public static PaymentStrategy createCreditCardStrategy(String cardNumber,
                                                         String cardHolderName) {
    return new CreditCardPaymentStrategy(cardNumber, cardHolderName);
  }

  public static PaymentStrategy createUpiStrategy(String upiId) {
    return new UpiPaymentStrategy(upiId);
  }

  public static PaymentStrategy createPaypalStrategy(String email) {
    return new PaypalPaymentStrategy(email);
  }
}
```

### 4️⃣ Client

```java
package com.designpatterns.strategy;

import com.designpatterns.strategy.context.PaymentContext;
import com.designpatterns.strategy.factory.PaymentStrategyFactory;
import com.designpatterns.strategy.strategy.PaymentStrategy;

import java.math.BigDecimal;

public class StrategyApplication {
  public static void main(String[] args) {

    // Create Credit Card Strategy
    PaymentStrategy creditCardStrategy = PaymentStrategyFactory
        .createCreditCardStrategy("1234-5678-9012-3456", "Ripan Baidya");

    PaymentContext paymentContext = new PaymentContext(creditCardStrategy);
    paymentContext.executePayment(BigDecimal.valueOf(1500));

    System.out.println("----- Switching Payment Method -----");

    PaymentStrategy upiStrategy = PaymentStrategyFactory.createUpiStrategy("ripan@upi");

    paymentContext.setPaymentStrategy(upiStrategy);
    paymentContext.executePayment(BigDecimal.valueOf(750));
  }
}
```

### Output

```
Processing credit card payment...
Card Holder: Ripan Baidya
Amount Paid: ₹1500
----- Switching Payment Method -----
Processing UPI payment...
UPI ID: ripan@upi
Amount Paid: ₹750
```

## Pattern Participants 🏗

| Role              | In Our Example                                                             |
| ----------------- | -------------------------------------------------------------------------- |
| Strategy          | `PaymentStrategy`                                                          |
| Concrete Strategy | `CreditCardPaymentStrategy`, `UpiPaymentStrategy`, `PaypalPaymentStrategy` |
| Context           | `PaymentContext`                                                           |
| Client            | `Application`                                                              |

## When To Use Strategy Pattern and When not to use it

### 📌 When To Use Strategy Pattern

| ✅ Situation                       | 🚀 Why Strategy Helps                            |
| ---------------------------------- | ------------------------------------------------ |
| Multiple ways to perform a task    | Encapsulates each algorithm separately           |
| Large `if-else` or `switch` blocks | Removes conditional complexity                   |
| Need runtime behavior change       | Can swap strategy dynamically                    |
| Follow Open/Closed Principle       | Add new strategy without modifying existing code |
| Algorithms evolve frequently       | Changes are isolated in separate classes         |
| Better unit testing required       | Strategies can be mocked easily                  |

### 🚫 When NOT To Use Strategy Pattern

| ❌ Situation                                    | ⚠ Why Avoid It                         |
| ----------------------------------------------- | -------------------------------------- |
| Only 1 or 2 simple algorithms                   | Over-engineering                       |
| Algorithm rarely changes                        | Adds unnecessary abstraction           |
| Behavior tightly coupled to context             | Strategy separation may not make sense |
| Performance-critical path with very small logic | Extra object creation overhead         |
| Small project / quick prototype                 | Adds too many classes                  |

## ⚖️ Pros and Cons of Strategy Pattern

### ✅ Advantages

| 🌟 Advantage                     | 💡 Explanation                                   |
| -------------------------------- | ------------------------------------------------ |
| 🔓 Follows Open/Closed Principle | Add new strategy without modifying existing code |
| 🔄 Runtime flexibility           | Behavior can change dynamically                  |
| 🧹 Cleaner code                  | Removes `if-else` chains                         |
| 🧪 Better testability            | Mock strategy independently                      |
| 🧩 Promotes composition          | Prefers composition over inheritance             |
| 📦 Separation of concerns        | Algorithm separated from context                 |

### ❌ Disadvantages

| ⚠ Drawback                                 | 💡 Explanation                       |
| ------------------------------------------ | ------------------------------------ |
| 📁 More classes                            | Each strategy becomes a new class    |
| 🧠 Slightly harder to understand initially | Extra abstraction layer              |
| 👤 Client must know strategy differences   | Client chooses which strategy to use |
| 🔄 Can increase object creation            | Each strategy is a separate object   |

## Interview Tips 🧠 

> Strategy Pattern has four main components — Strategy interface, Concrete Strategies, Context, and Client. The Context delegates behavior to the Strategy, and the Client decides which Strategy to use.

> Strategy Pattern reduces conditional complexity and promotes composition over inheritance, but it increases the number of classes. It is ideal when algorithms vary independently and need runtime flexibility.

## Resources 📚

🔗 https://algomaster.io/learn/lld/strategy <br>
🔗 https://codewitharyan.com/tech-blogs/strategy-design-pattern <br>
