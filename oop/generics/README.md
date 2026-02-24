# Generics in Java ☕️

Generics means **parameterized types**. They allows us to write code that works with different data types using a single class, interface or method. Instead of creating separate versions for each type, we use **type parameters** (like `<T>`) to make the code `reusable` and `type-safe`.

> Generics allow you to write type-safe and reusable code.

👉 **Note:** Generics were introduced in **Java 5 (2004)**.

## Problem Before Generics & How Generics Solved It

### Before Generics (Type Safety Problem) ❌

```java
List list = new ArrayList();
list.add("Ripan");
list.add(10);   // allowed ❌

String name = (String) list.get(1); // Runtime error 💥
```

**Problems:**

↪️ No compile-time type checking <br>
↪️ Manual casting <br>
↪️ Runtime `ClassCastException`

### With Generics ✅

```java
List<String> list = new ArrayList<>();
list.add("Ripan");
// list.add(10); ❌ Compile-time error

String name = list.get(0); // No casting needed
```

**Now:**

↪️ Type-safe <br>
↪️ No casting <br>
↪️ Errors caught at compile time

## Common Type Parameter Names 🏷️

| Symbol | Meaning               |
| ------ | --------------------- |
| T      | Type                  |
| E      | Element (collections) |
| K      | Key                   |
| V      | Value                 |
| N      | Number                |

## Generic Class ⭐️

You define generics using angle brackets `<T>`.

```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

**Usage:**

```java
Box<String> stringBox = new Box<>();
stringBox.set("Hello");

Box<Integer> intBox = new Box<>();
intBox.set(100);
```

`T` is called **Type Parameter**.

## Generic Methods ⭐️

You can define generics at method level.

```java
class Utils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
```

Usage:

```java
Integer[] numbers = {1, 2, 3};
Utils.printArray(numbers);

String[] names = {"A", "B"};
Utils.printArray(names);
```

**Notice:**

`<T>` comes before return type.

## Bounded Type Parameters

You can restrict the type.

### 🔹 Upper Bound (`extends`)

```java
class Calculator<T extends Number> {
    public double square(T num) {
        return num.doubleValue() * num.doubleValue();
    }
}
```

Allowed:

```java
Calculator<Integer> c1;
Calculator<Double> c2;
```

Not allowed:

```java
Calculator<String> ❌
```

### 🔹 Multiple Bounds

```java
<T extends Number & Comparable<T>>
```

Only works with: **One class** & **Multiple interfaces**

## Wildcards in Generics

Wildcards are powerful and commonly asked in interviews.

### 🔹 1. Unbounded Wildcard `<?>`

```java
List<?> list;
```

Means:
"List of some unknown type"

You **cannot add** elements (except null).

### 🔹 2. Upper Bounded Wildcard `<? extends T>`

```java
List<? extends Number>
```

Means:
"List of Number or its subclass"

You can **read**, but cannot add.

Example:

```java
public void printNumbers(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n);
    }
}
```

### 🔹 3. Lower Bounded Wildcard `<? super T>`

```java
List<? super Integer>
```

Means:
"List of Integer or its superclass"

You can **add**, but reading is limited.

### 🔥 Golden Rule: **PECS Principle**

> **Producer → Extends** <br>
> **Consumer → Super**

If the list produces data → use `extends` <br>
If it consumes data → use `super`

## Type Erasure (VERY IMPORTANT) ⭐️

Generics exist only at **compile time**. and at runtime, Java removes generic type information.

Example:

```java
List<String> list = new ArrayList<>();
```

At runtime:

```java
List list = new ArrayList();
```

This is called **Type Erasure**.

Because of this:

**You cannot:**

```java
if (list instanceof List<String>) ❌
new T(); ❌
T.class ❌
```

## Generics with Collections

Generics are heavily used in:

- `List<T>`
- `Set<T>`
- `Map<K, V>`
- `Optional<T>`
- `Comparator<T>`

Example:

```java
Map<String, Integer> marks = new HashMap<>();
marks.put("Ripan", 95);
```

## Generic Interface

```java
interface Repository<T> {
    void save(T entity);
    T findById(T id);
}
```

Implementation:

```java
class UserRepository implements Repository<User> {
    // implementation
}
```

Very common in backend architecture (you'll see this in Spring Boot).

## Raw Types (Avoid These)

```java
List list = new ArrayList(); // Raw type ❌
```

Why bad?

- No type safety
- Bypasses generics system

Always use:

```java
List<String> list = new ArrayList<>();
```

## Generics & Inheritance

This confuses many developers.

```java
List<Integer> ❌ is NOT a subtype of List<Number>
```

Even though:

```java
Integer extends Number
```

This is because generics are **invariant**.

To fix:

```java
List<? extends Number>
```

## Advantages of Generics

✅ Compile-time type safety <br>
✅ Eliminates casting <br>
✅ Code reusability <br>
✅ Cleaner APIs <br>
✅ Better maintainability <br>

## Common Interview Questions 👨‍💻

### 1️⃣ What is Type Erasure?

**Type Erasure** is the process by which Java removes generic type information at runtime.

Generics exist only at **compile time**. After compilation, the generic type parameters are replaced with their upper bounds (usually `Object` if no bound is specified).

Example:

```java
List<String> list = new ArrayList<>();
```

At runtime, it becomes:

```java
List list = new ArrayList();
```

Because of type erasure:

- You cannot check `instanceof List<String>`
- You cannot create `new T()`
- You cannot use `T.class`

Type erasure ensures backward compatibility with older Java versions that did not support generics.

### 2️⃣ What is the difference between `extends` and `super` in generics?

They are used with wildcards to define bounds.

#### `<? extends T>` — Upper Bounded Wildcard

- Accepts `T` or any subclass of `T`
- Used when you only need to **read (produce)** data
- You cannot safely add elements

Example:

```java
List<? extends Number>
```

#### `<? super T>` — Lower Bounded Wildcard

- Accepts `T` or any superclass of `T`
- Used when you need to **write (consume)** data
- You can add elements of type `T`

Example:

```java
List<? super Integer>
```

In short:

- `extends` → read only
- `super` → write allowed

### 3️⃣ Why can't we create `new T()`?

Because of **type erasure**.

At runtime, the JVM does not know what `T` actually represents. It only sees `Object` (or the upper bound). Since the exact type information is not available, Java cannot create an instance of `T`.

This is illegal:

```java
T obj = new T();  // Compile-time error
```

If you need to create instances, you must pass a `Class<T>` object:

```java
public class Factory<T> {
    private Class<T> type;

    public Factory(Class<T> type) {
        this.type = type;
    }

    public T createInstance() throws Exception {
        return type.getDeclaredConstructor().newInstance();
    }
}
```

### 4️⃣ Why is `List<Integer>` not a subtype of `List<Number>`?

Generics in Java are **invariant**.

Even though:

```java
Integer extends Number
```

This does NOT mean:

```java
List<Integer> extends List<Number>
```

If Java allowed that, this would break type safety:

```java
List<Integer> intList = new ArrayList<>();
List<Number> numList = intList;  // Imagine this was allowed
numList.add(3.14);               // Adding Double
```

Now the `intList` would contain a `Double`, which is unsafe.

To solve this, we use wildcards:

```java
List<? extends Number>
```

### 5️⃣ What is the PECS Principle?

PECS stands for:

> **Producer Extends, Consumer Super**

- If a collection **produces** data → use `extends`
- If a collection **consumes** data → use `super`

Example:

```java
// Producer (read-only)
void print(List<? extends Number> list)

// Consumer (write allowed)
void addNumbers(List<? super Integer> list)
```

This principle helps you decide when to use `extends` and `super`.

### 6️⃣ What are raw types?

Raw types are generic classes or interfaces used **without specifying a type parameter**.

Example:

```java
List list = new ArrayList();  // Raw type
```

Problems with raw types:

- No compile-time type safety
- Requires casting
- Can cause runtime `ClassCastException`

Correct usage:

```java
List<String> list = new ArrayList<>();
```

Raw types should be avoided in modern Java code.

### 7️⃣ Can we use primitives in generics?

No, Java generics work only with **reference types**, not primitive types.

This is invalid:

```java
List<int> list;   // ❌ Not allowed
```

Instead, use wrapper classes:

```java
List<Integer> list;
List<Double> list;
```

Java provides wrapper classes:

- `int` → `Integer`
- `double` → `Double`
- `char` → `Character`
- etc.

This works because generics require objects, and primitives are not objects.

## Conclusion 🧠

Generics are a powerful feature in Java that allow you to write type-safe code. They are used heavily in collections and other parts of the Java ecosystem. Understanding generics is essential for writing clean, maintainable, and type-safe code.

| Concept      | Key Idea                         |
| ------------ | -------------------------------- |
| `<T>`        | Type parameter                   |
| `extends`    | Upper bound                      |
| `super`      | Lower bound                      |
| `<?>`        | Unknown type                     |
| Type Erasure | Generics removed at runtime      |
| PECS         | Producer Extends, Consumer Super |

## Resources

🕰️ **Last Updated At: 24.02.2026**

🔗 https://codewitharyan.com/tech-blogs/generics-and-wildcards <br>
🔗 https://docs.oracle.com/javase/tutorial/java/generics/types.html <br>
