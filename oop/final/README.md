# "final" keyword

While **inheritance** enables us to reuse existing code, sometimes we do need to set limitations on extensibility for various reasons; the **final** keyword allows us to do exactly that.

In this article, we’ll take a look at what the **final** keyword means for:
**classes**, **methods**, and **variables**.

## 1️⃣ final class

Classes marked as **final** can’t be extended. If we look at the code of Java core libraries, we’ll find many **final** classes there. One example is the `String` class.

**Example**

```java
final class Vehicle {
}

class Car extends Vehicle { // ❌ Compilation Error
}
```

Real example from Java - `String`, `Integer`, `Double` etc. are final

> **Why?** 🤔 Because of immutability and security.

## 2️⃣ final method

A method declared **final** cannot be **overridden** in a **subclass**.

```java
class Parent {
    final void show() {
        System.out.println("This cannot be overridden");
    }
}

class Child extends Parent {

    @Override
    void show() { // ❌ Compilation Error
    }
}
```

**👉 Why use it?**

✅ To prevent modification of important behavior. <br>
✅ Used in security-sensitive logic.

## 3️⃣ final variables

When a variable is declared **final**, its value cannot be changed once assigned.

### 3️⃣·1️⃣ final primitive variables

Let’s declare a primitive final variable `i`, then assign 1 to it.

And let’s try to assign a value of 2 to it:

```java
public void whenFinalVariableAssign_thenOnlyOnce() {
    final int i = 1;
    //...
    i=2;
}
```

The compiler says:

```
The final local variable i may already have been assigned
```

### 3️⃣·2️⃣ final reference variables

If we have a **final reference variable**, we can’t **reassign** it either. But this doesn’t mean that the object it refers to is immutable. We can change the properties of this object freely.

To demonstrate this, let’s declare the final reference variable `cat` and initialize it:

```java
final Cat cat = new Cat();
```

If we try to reassign it we’ll see a compiler error:

```
The final local variable cat cannot be assigned. It must be blank and not using a compound assignment
```

But we can change the properties of Cat instance:

```java
cat.setWeight(5);
assertEquals(5, cat.getWeight());
```

### 3️⃣·3️⃣ final static variables

```java
class AppConfig {
    static final double PI = 3.14159;
}
```

👉 **Convention:** Use `UPPER_CASE` for static final constants.

### 3️⃣·4️⃣ final parameters

The final keyword is also legal to put before method parameters. A final parameter can’t be changed inside a method:

```java
public void methodWithFinalArguments(final int x) {
    x=1;
}
```

The above assignment causes the compiler error:

```
The final local variable x cannot be assigned. It must be blank and not using a compound assignment
```

## 🎯 Quick Summary

👉 final variable → cannot reassign <br>
👉 final method → cannot override <br>
👉 final class → cannot inherit <br>
👉 final reference → reference fixed, object mutable

## Conclusion

In this article, we learned what the final keyword means for classes, methods, and variables. Although we may not use the final keyword often in our internal code, it may be a good design solution.

## Resources

🕰️ **Last Updated At: 24.02.2026**

- https://www.baeldung.com/java-final
