# Dependency

Dependency is a **directed relationship** which is used to show that some **UML** element or a set of elements requires, needs or depends on other model elements for specification or implementation. Because of this, dependency is called a <u>**supplier - client relationship**</u>, where **supplier** provides something to the **client**, and thus the **client** is in some sense incomplete while semantically or structurally dependent on the **supplier** element(s). Modification of the **supplier** may impact the **client** elements.

Dependency is a relationship between named elements, which in **UML** includes a lot of different elements, e.g. **classes**, **interfaces**, **components**, **artifacts**, **packages**, etc. There are several kinds of dependencies shown on the diagram below.

In simple terms, **dependency** is a relationship between two elements where one element (the client) depends on the other element (the supplier). This means that the client element requires the supplier element to function correctly.

📌 **Note:** A dependency is generally shown as a dashed arrow pointing from the client (dependent) at the tail to the supplier (provider) at the arrowhead.

```
    +-------------+        +-------------+
    | Client      |------->| Supplier    |
    +-------------+        +-------------+
```

✅ Here, Right side (Client) depends on Left side (Supplier).

**Example**

![dependency java example](/resources/images/oop/relationships/dependency-java-example-1.png)

## Why dependency matters

**Dependency** defines how **flexible** our system is, how easy it is to **test**, **change** or **extend** it.

| Poorely Managed dependency creates | Well Managed dependency creates |
| ---------------------------------- | ----------------------------- |
| Tight coupling                     | Loose coupling                |
| Hard to test                       | Easy to test                  |
| Hard to change                     | Easy to change                |
| Hard to extend                     | Easy to extend                |

## Types of dependency

There are several types of dependency, which are shown on the diagram below.

### 1️⃣ Dependency via Object Creation (Strongest form)

```java
class Car {
    private Engine engine = new Engine();
}
```

Here, 
<br> ➡ Car creates Engine
<br> ➡ Car controls the lifecycle of Engine
<br> ➡ Car is tightly coupled to Engine
<br> ➡ Car cannot use any other type of engine

### 2️⃣ Dependency via Constructor

```java
class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

Here, 
<br> ➡ Car does not create Engine
<br> ➡ Engine is provided externally

This is the healthier relationship

### 2️⃣ Dependency via Method Parameter

```java
class Car {
    public void drive(Engine engine) {
        engine.start();
    }
}
```

Here, 
<br> This is temporary dependency

## Dependency in Real Backend System

In modern Java backend frameworks like: `Spring framework`, `Spring Boot`

Dependencies are automatically injected by the **IoC container**.

**Example**

```java
@Service
class OrderService {

    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

**The framework:**

Creates objects <br>
Injects dependencies <br>
Manages lifecycle <br>

This is **Inversion of Control (IoC)**.

🔥 <u>**Dependy Graph in Typical Backend Application**</u>

![dependency graph](/resources/images/oop/relationships/dependency-graph-backend-app.png)

## Misatess Should avoid ❌

❌ Creating objects using new inside business classes <br>
❌ Depending on concrete classes <br>
❌ Circular dependencies <br>
❌ Using static dependencies everywhere <br>
❌ Hiding dependencies (field injection) <br>

## Conclusion



## Resources

🕰️ **Last Updated At:** **24.02.2026**

- https://www.uml-diagrams.org/dependency.html
