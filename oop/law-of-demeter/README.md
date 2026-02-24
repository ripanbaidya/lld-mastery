# Law of Demeter (LoD) – “Don’t Talk to Strangers”

Only talk to your **immediate friends**.

The **Law of Demeter** is a design principle in **Object-Oriented Programming** that says:

> A class should only communicate with its **direct dependencies**, not with objects returned by them.

It helps reduce **tight coupling**, improves **maintainability**, and makes systems easier to refactor.

## Simple Meaning 🔎

A method of a class should only call methods of:

1. Itself
2. Its fields (instance variables)
3. Objects passed as parameters
4. Objects it creates

❌ It should NOT call methods on objects returned by other objects.

### ❌ Violating Law of Demeter (Bad Example)

**Code**

```java
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine = new Engine();

    public Engine getEngine() {
        return engine;
    }
}

class Driver {
    public void drive(Car car) {
        car.getEngine().start();   // ❌ LoD violation
    }
}
```

### ❌ What’s wrong?

`Driver` talks to: `Car` and `Car`’s internal `Engine` <br>
So `Driver` depends on `Engine` too. <br>
This creates **tight coupling**: <br>
If `Car` changes its internal structure, `Driver` might break.

### ✅ Following Law of Demeter (Good Example)

```java
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine = new Engine();

    public void start() {
        engine.start();   // Car handles its internal logic
    }
}

class Driver {
    public void drive(Car car) {
        car.start();   // ✅ Only talks to Car
    }
}
```

### ✅ Why is this better?

- `Driver` only depends on `Car`
- Internal implementation of `Car` can change
- Low coupling
- Better encapsulation

## 🧠 Real-World Analogy

Imagine you order food at a restaurant:

You talk to the **waiter**, not:

- The chef
- The kitchen staff
- The supplier

The waiter handles everything internally.

👉 That’s Law of Demeter.

## 🔥 Another Example (Classic Interview Pattern)

### ❌ Deep Method Chaining (Bad)

```java
order.getCustomer().getAddress().getCity();
```

This means:

- Order knows Customer
- Customer knows Address
- Address knows City

If `Address` changes → everything breaks.

### ✅ Better Design

```java
class Order {
    private Customer customer;

    public String getCustomerCity() {
        return customer.getCity();
    }
}
```

Now you call:

```java
order.getCustomerCity();
```

Only talking to `Order`.

## 🎯 Why LoD Important

LoD matters because:

- It reduces **ripple effects**
- Improves **encapsulation**
- Supports **Clean Architecture**
- Works well with **Dependency Injection**
- Makes unit testing easier

Interviewers love when you mention:

> “To reduce coupling, we follow Law of Demeter.”

## 📊 Quick Summary

| Without LoD       | With LoD             |
| ----------------- | -------------------- |
| Tight coupling    | Loose coupling       |
| Hard to refactor  | Easy to change       |
| Exposes internals | Strong encapsulation |
| Fragile design    | Clean architecture   |

## Exception to the Law of Demeter 🚨

**Chained calls** usually signal a `violation` of the Law of Demeter, but there are exceptions. For example, the **builder pattern doesn’t violate the Law of Demeter** if the builder is instantiated locally. One of the rules states that **“Method X of class C should only invoke the methods of an object created by X“**

Additionally, there are chained calls in **Fluent APIs**. Fluent APIs don’t violate the Law of Demeter if the chained calls **are on locally created objects**. But when the chained calls are on a **non-locally instantiated object** or returns a different object, then it violates the Law of Demeter.

Also, there are cases where we could violate the Law of Demeter when **dealing with data structures**. The typical data structure usage, like instantiating, mutating, and accessing them locally, doesn’t violate the Law of Demeter. In a case where we’re calling a method on an object obtained from a data structure, then the Law of Demeter may be violated.

**🚀 One-Line Definition for Interviews**

> The Law of Demeter states that a class should only talk to its immediate dependencies and not to the internal objects of those dependencies.

## Conclusion 📌

In summary, the Law of Demeter is a simple but powerful principle that helps you write cleaner, more maintainable code. By following the rule of "don't talk to strangers," you can reduce coupling, improve encapsulation, and make your systems easier to refactor.

## Resources 🔗

🕰️ **Last Updated At: 24.02.2026**

🔗 https://www.baeldung.com/java-demeter-law <br>
