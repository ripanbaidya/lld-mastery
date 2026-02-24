# Enums

Enums (short for enumerations) are a powerful yet underappreciated feature in **object-oriented programming**. Enums allow us to define a fixed set of named constants that improve **clarity**, **type safety**, and **maintainability** in our system.

Used correctly, enums can make our code more **expressive**, **self-documenting**, and **resilient to errors**.

## What is an Enum ?

An enum is a special data type that defines a collection of constant values under a single name. Unlike primitive constants or string literals, enums are type-safe, which means you can’t assign just any value to a variable declared as an enum type.

👉 They ensure that a variable can only take one out of a predefined set of valid options.

**In short**: If a value can only be one of a predefined set of options, use an enum.

## Why use Enums ?

Enums provide several key advantages over plain constants or strings:

- **Avoid “magic values”**: No more scattered strings or integers like "PENDING" or 3 in your code.

- **Improve readability**: Enums make your intent clear — OrderStatus.SHIPPED is far more descriptive than 3.
- **Enable compiler checks**: The compiler validates enum usage, catching typos and invalid assignments early.
- **Support IDE features**: Most IDEs provide auto-completion and refactoring tools for enum values.
- **Reduce bugs**: You can’t accidentally assign a random string or number that doesn’t belong to enum.

## Example

Enums are perfect for defining categories or states that rarely change.

✅ Order States (e.g., PENDING, IN_PROGRESS, COMPLETED) <br>
✅ User Roles (e.g., ADMIN, CUSTOMER, DRIVER) <br>
✅ Vehicle Types (e.g., CAR, BIKE, TRUCK) <br>
✅ Directions (e.g., NORTH, SOUTH, EAST, WEST)

By using enums instead of raw strings, you make your system easier to understand and harder to misuse.

## Code Example

### Example 1

Let’s start with a simple example representing the status of an order in an e-commerce application.

```java
public enum OrderStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED;
}
```

This enum defines a finite set of valid states an order can have. Nothing else is allowed.

```java
OrderStatus status = OrderStatus.SHIPPED;

if (status == OrderStatus.SHIPPED) {
    System.out.println("Your package is on the way!");
}
```

### Example 2 - Enums with Properties and Methods

Enums can have additional data and even behavior. This makes them even more powerful.

Let’s consider a Coin enum that represents U.S. coins and their denominations.

```java
public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

```java
Coin coin = Coin.DIME;
System.out.println("The value of " + coin + " is " + coin.getValue());
```

This is far more elegant and safe than using integers directly.

## Conclusion 📌

Enums help you define a fixed set of well-known values, giving structure and clarity to your data. But what if you want to define a common set of behaviors that different classes can implement in their own way?

That’s where Interfaces come in. In the next chapter, we'll dive into interfaces.

---

## Resources 🔗

🕰️ **Last Updated At: 24.02.2026**

🔗 https://www.baeldung.com/a-guide-to-java-enums <br>
🔗 https://algomaster.io/learn/lld/enums <br>
🎥 https://youtu.be/BIOxWAfaAgw?si=Cq9PwV2vJA8F2r-p
