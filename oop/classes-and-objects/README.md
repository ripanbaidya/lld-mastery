# Classes and Objects 🚀

**Classes** and **Objects** are the foundation of **Object-Oriented Programming (OOP)**. They help us represent real-world entities in code.

## What is a Class?

A **class** is a blueprint or template used to create objects.

It defines:

- What data an object will have → **Attributes (Fields)**
- What actions an object can perform → **Methods**

Think of a class as a design plan.

### Defining a Class in Java

To define a class in Java, we use the `class` keyword followed by the class name.

```java
// Class definition (Blueprint)
class Car {

    // Attributes (Instance variables) -> define state
    private String name;
    private String color;

    // Constructor -> initializes object data
    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Method -> defines behavior
    public void start() {
        System.out.println(name + " has started.");
    }
}
```

⭐️ Here, You might be wondering what are `private`, `public`, `String`, `void`, etc. These are called **access modifiers** and **data types**.

⭐️ Here, will will discuss a bit about attributes, and methods. and the constructor part will be convered in detail in other sections.

🔹 **Attributes (State)**: These define the **state** of the object.

```java
private String name;
private String color;
```

🔹 **Constructor**: Special method that runs when object is created.

```java
public Car(String name, String color)
```

🔹 **Method (Behavior)**: Defines what the object can do.

```java
public void start()
```

## UML

```
+--------------------------+
| Car                      |
+--------------------------+
| - name: String           |
| - color: String          |
+--------------------------+
| + Car(name, color)       |
| + start(): void          |
+--------------------------+
```

**Note**: Don't worry about the symbols for now. We will discuss them in detail in other sections.

## What is an Object?

An **object** is a real entity created from a class.

👉 Object = Instance (both mean the same)

When you create an object:

- Memory is allocated in the heap
- Data is stored
- Methods are stored

### Creating Objects in Java

To create an object, we use the `new` keyword.

```java
public class Main {
    public static void main(String[] args) {

        // car1 and car2 are reference variables
        Car car1 = new Car("Toyota", "Red");
        Car car2 = new Car("Honda", "Blue");

        car1.start();
        car2.start();
    }
}
```

### What Happens Internally?

When you write:

```java
Car car1 = new Car("Toyota", "Red");
```

Three things happen:

1️⃣ **Instantiation**
`new` creates an object in heap memory.

2️⃣ **Initialization**
Constructor sets values (`Toyota`, `Red`).

3️⃣ **Reference Assignment**
`car1` stores the memory address of that object.

### 🧠 Memory Understanding (Very Important)

![image](/resources/images/oop/class-and-object.png)

### Think Like This:

```
Stack Memory                Heap Memory
-------------              -------------------
                            +---------------+
car1  -----------▶          | Car Object    |
                            | name = Toyota |
                            | color = Red   |
                            +---------------+
```

- ✔ The object lives in **heap memory**
- ✔ `car1` is a **reference** in stack memory
- ✔ The reference points to the object

## Summary

1️⃣ **Attributes**

Fields that define object state.
Example: `name`, `color`

2️⃣ **Methods**

Functions that define object behavior.
Example: `start()`

3️⃣ **Object**

The real entity created in heap memory.

Example:

```java
new Car("Toyota", "Red")
```

4️⃣ **Instance**

Same as object.
No difference in Java.

5️⃣ **Reference**

A variable that stores the address of an object.

Example:

```java
Car car1
```

👉 `car1` is NOT the object, It is a reference variable that points to the object.

### 🎯 The Most Confusing Line

```java
Car c1 = new Car("Toyota", "Red");
```

| Part           | Meaning            |
| -------------- | ------------------ |
| `Car`          | Type               |
| `c1`           | Reference variable |
| `new Car(...)` | Object creation    |
| Object         | Lives in heap      |
| c1             | Points to object   |


## Conclusion

## Resources

- https://www.geeksforgeeks.org/java/classes-objects-java/
- https://www.baeldung.com/java-classes-objects