# State Pattern

<p align="right"><b>Last Updated: 28.02.2026</b></p>

## Introduction ❇️

The **State Design Pattern** is a type of **Behavioral Design Pattern** that allows an **object** to **change its behavior when its internal state changes**. The object will appear to **change its class**.

Instead of writing large `if-else` or `switch` statements based on state, we **encapsulate each state into a separate class** and delegate behavior to the current state object.

## Real-Life Intuition 🚦

### 🚦 Traffic Light System

A traffic light behaves differently depending on its current state:

- Red → Stop
- Green → Go
- Yellow → Slow down

Instead of:

```java
if(state == RED) { ... }
else if(state == GREEN) { ... }
else if(state == YELLOW) { ... }
```

We create:

- `RedState`
- `GreenState`
- `YellowState`

And the `TrafficLight` delegates behavior to the current state object.

## 🧩 Problem Statement

### 🎮 Online Order Processing System

You are building an **e-commerce order system**.

An order can be in the following states:

- CREATED
- PAID
- SHIPPED
- DELIVERED
- CANCELLED

Operations:

- pay()
- ship()
- deliver()
- cancel()

Rules:

- You cannot ship before payment.
- You cannot cancel after shipping.
- You cannot deliver before shipping.
- You cannot pay twice.

---

# ❌ Without State Pattern (The Problem)

```java
public class Order {

    private String state; // "CREATED", "PAID", etc.

    public void pay() {
        if ("CREATED".equals(state)) {
            state = "PAID";
        } else {
            throw new IllegalStateException("Cannot pay in state: " + state);
        }
    }

    public void ship() {
        if ("PAID".equals(state)) {
            state = "SHIPPED";
        } else {
            throw new IllegalStateException("Cannot ship in state: " + state);
        }
    }

    // More if-else everywhere...
}
```

### 🚨 Problems

1. ❌ Massive `if-else` blocks
2. ❌ Violates Open/Closed Principle
3. ❌ Hard to add new states
4. ❌ Hard to test
5. ❌ Business logic tightly coupled
6. ❌ High cyclomatic complexity

In interviews, this is called **“State Explosion” problem**.

---

# ✅ With State Design Pattern (Clean Solution)

---

# 📦 Components of State Design Pattern (VERY IMPORTANT FOR INTERVIEW)

| Component                  | Responsibility                                 |
| -------------------------- | ---------------------------------------------- |
| **Context**                | Maintains current state and delegates behavior |
| **State (Interface)**      | Defines common behavior for all states         |
| **ConcreteState**          | Implements behavior for a particular state     |
| **State Transition Logic** | Decides when to change state                   |

---

# 🏗 Production-Ready Java Example

### 📁 Suggested Package Structure

```
com.company.ordermanagement
 ├── context
 │     └── Order.java
 ├── state
 │     ├── OrderState.java
 │     ├── CreatedState.java
 │     ├── PaidState.java
 │     ├── ShippedState.java
 │     ├── DeliveredState.java
 │     └── CancelledState.java
 └── Main.java
```

---

## 1️⃣ State Interface

```java
package com.company.ordermanagement.state;

import com.company.ordermanagement.context.Order;

public interface OrderState {

    void pay(Order order);

    void ship(Order order);

    void deliver(Order order);

    void cancel(Order order);

    String getName();
}
```

---

## 2️⃣ Context Class

```java
package com.company.ordermanagement.context;

import com.company.ordermanagement.state.*;

public class Order {

    private OrderState currentState;

    public Order() {
        this.currentState = new CreatedState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void pay() {
        currentState.pay(this);
    }

    public void ship() {
        currentState.ship(this);
    }

    public void deliver() {
        currentState.deliver(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public String getCurrentState() {
        return currentState.getName();
    }
}
```

---

## 3️⃣ Concrete States

### CreatedState

```java
package com.company.ordermanagement.state;

import com.company.ordermanagement.context.Order;

public class CreatedState implements OrderState {

    @Override
    public void pay(Order order) {
        order.setState(new PaidState());
    }

    @Override
    public void ship(Order order) {
        throw new IllegalStateException("Cannot ship before payment.");
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver before shipping.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
    }

    @Override
    public String getName() {
        return "CREATED";
    }
}
```

---

### PaidState

```java
public class PaidState implements OrderState {

    @Override
    public void pay(Order order) {
        throw new IllegalStateException("Order already paid.");
    }

    @Override
    public void ship(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver before shipping.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
    }

    @Override
    public String getName() {
        return "PAID";
    }
}
```

---

### ShippedState

```java
public class ShippedState implements OrderState {

    @Override
    public void pay(Order order) {
        throw new IllegalStateException("Already paid.");
    }

    @Override
    public void ship(Order order) {
        throw new IllegalStateException("Already shipped.");
    }

    @Override
    public void deliver(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order) {
        throw new IllegalStateException("Cannot cancel after shipping.");
    }

    @Override
    public String getName() {
        return "SHIPPED";
    }
}
```

---

### DeliveredState & CancelledState

Terminal states — all operations throw exceptions.

---

# 🎯 What Interviewers Expect You to Say

### Definition:

> State pattern allows an object to change its behavior when its internal state changes by delegating state-specific behavior to separate classes.

### Key Benefit:

- Eliminates conditional complexity
- Follows Open/Closed Principle
- Single Responsibility Principle

---

# 🚀 Where State Pattern is Used in Real Systems

1. ATM machines
2. Media players (Play, Pause, Stop)
3. Document workflow systems
4. Order management systems
5. TCP connection states
6. Game character behavior
7. Payment lifecycle
8. Workflow engines

Example:

- Spring State Machine framework
- Workflow engines like Camunda

---

# ❌ When NOT to Use It

- When there are only 2 simple states
- When transitions are unlikely to grow
- When logic is trivial
- If simple enum + switch is enough

---

# ⚖️ Advantages

✔ Removes large conditionals
✔ Better maintainability
✔ Extensible
✔ Improves testability
✔ Follows SOLID

---

# ⚠️ Disadvantages

❌ More classes
❌ Slightly higher complexity
❌ Overkill for small systems

---

# 🧠 Interview Deep-Dive Questions

1. Difference between State and Strategy?
   - Strategy = behavior chosen by client
   - State = behavior changes internally

2. Can states share data?
   - Yes, via context.

3. Who controls state transition?
   - Usually ConcreteState.

4. How to make states reusable?
   - Make them stateless + singleton.

---

# 🎤 Real Interview Scenario

**Design an ATM machine**

States:

- IdleState
- HasCardState
- AuthenticatedState
- DispensingCashState

Without state pattern → huge switch statements.
With state pattern → each state controls allowed operations.

---

# 🔥 Final Interview Summary (Memorize This)

> The State Pattern encapsulates varying behavior for the same object based on its internal state. It replaces conditional state logic with polymorphism by representing each state as a separate class and delegating behavior to the current state object.

---

If you want, next I can:

- Compare **State vs Strategy vs Template Method**
- Give you a **low-level design interview question**
- Or give you a **machine coding round problem** on State pattern 🚀
