# IS-A vs HAS-A (Inheritance and Composition)

Understanding **IS-A** and **HAS-A** relationships is fundamental for writing clean object-oriented code.

## IS-A (Inheritance)

**IS-A** relationship is a type of relationship between two classes where one class is a specialized version of another class. It is a one-way relationship, meaning that the **subclass** is a specialized version of the **superclass**, but the **superclass** is not a specialized version of the **subclass**.

**Note:** 👉 IS-A means inheritance.

> Example: Dog 'is-a' Animal

**Code**

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {  // Dog IS-A Animal
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();   // inherited
        dog.bark();  // own method
    }
}
```

Here, Dog **extends** the Animal class, and represents the **IS-A** relationship.
<br> Dog class automatically gets all the non-private properties of Animal class and can override the behaviour.

📌 **Note:** The `inheritance` is also known as `Generalization` and In `UML` it is represented by a **solid line with a hollow, closed arrowhead** pointing from the more specific element (subclass/child) to the more general element (superclass/parent).

![Inheritance or Generalization UML](/resources/images/oop/relationships/inheritance-or-generalization-uml.png)

**<u>We use IS-A when</u>**

✔ There is a true hierarchical relationship <br>
✔ You can say "B is a type of A" <br>
✔ You want polymorphism

**Polymorphism example**

```java
Animal a = new Dog();  // Upcasting
a.eat();               // Runtime polymorphism
```

This is powerful and heavily used in frameworks.

## HAS-A (Composition)

The composition is another mechanism provided by OOP for reusing implementation.

In a nutshell, **composition allows us to model objects that are made up of other objects**, thus defining a “has-a” relationship between them.

Furthermore, **the composition is the strongest form of association, which means that the object(s) that compose or are contained by one object are destroyed too when that object is destroyed**.

**Note:** 👉 HAS-A means composition.

> Example: Car 'has-a' Engine

**Code**

```java
class Engine {
    void start() {
        System.out.println("Engine is starting");
    }
}

class Car {
    private Engine engine;  // Car HAS-A Engine

    public Car() {
        this.engine = new Engine();
    }

    void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }
}
```

Here, Car **has-a** Engine, and represents the **HAS-A** relationship.

📌 **Note:** In UML class diagrams, the symbol for composition is a **filled (black) diamond shape (◆)** placed on the association line at the end connected to the whole or container class.

![Composition UML](/resources/images/oop/relationships/composition-uml.png)

**<u>Use HAS-A When</u>**

✔ You want flexibility <br>
✔ Behavior may change <br>
✔ Components are reusable <br>
✔ You follow SOLID principles

## Difference between IS-A and HAS-A 🔥

| Feature              | IS-A        | HAS-A                   |
| -------------------- | ----------- | ----------------------- |
| Keyword              | `extends`   | Object reference        |
| Type                 | Inheritance | Composition/Aggregation |
| Coupling             | Tight       | Flexible                |
| Reusability          | Limited     | High                    |
| Design flexibility   | Less        | More                    |
| Overriding possible? | Yes         | No                      |

**✅ Now, The question is which one should you prefer?**

**Answer:** 👉 Prefer **HAS-A** (Composition) over **IS-A** (Inheritance) whenever possible.

**Because:**

- **Flexibility:** Composition provides more flexibility than inheritance.
- **Reusability:** Composition allows for greater code reuse than inheritance.
- **Maintainability:** Composition makes code easier to maintain than inheritance.
- **Testability:** Composition makes code easier to test than inheritance.

## Conclusion

## Resources

🕰️ **Last Updated At: 24.02.2026**

- https://www.baeldung.com/java-inheritance-composition
