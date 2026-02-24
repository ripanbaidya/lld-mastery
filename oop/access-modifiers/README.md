# Access Modifiers 🔐

Access modifiers in Java control who can access **classes**, **methods**, **variables**, and **constructors**.

They are extremely important in LLD, system design, and real-world backend development.

Before we begin, please note that a top-level class can only use `public` or `default` access modifiers. At the member level, we can use all four.

## Types of Access Modifiers 🔢

Simply put, there are **four access modifiers**: `public`, `private`, `protected`, and `default` (no keyword).

To understand access modifiers clearly, we will use the following project structure as a reference:

<img src="/resources/images/oop/project-structure-access-modifiers.png" alt="project structure of access modifiers" height="300" width="400"/>

Here, `main` and `utility` are two different packages which are located under the root directory `src`.

they have classess like - `Main`, `PublicExample`, `PrivateExample`, `ProtectedExample`, `DefaultExample`

## 1️⃣ Public 🌐

❇️ **Scope:** A public **class**, **method**, or **variable** is accessible from anywhere in the **application**, whether it’s within the **same package** or from a **different package**.

❇️ **Usage:** The public modifier is used when you want the element (class, method, or variable) to be **globally accessible**.

<u><b>Example</b></u>

📦 `utility/PublicExample.java`

```java
package utility;

public class PublicExample {

  public void display() {
    System.out.println("Greeting message from the Public");
  }
}
```

📦 `main/Main.java`

```java
package main;

import utility.PublicExample;

public class Main {
  public static void main(String[] args) {
    PublicExample example = new PublicExample();
    example.display();
  }
}
```

✅ **Why It Works**

- `display()` is `public`
- Public members are accessible from **any package**
- No inheritance required

✔ **Output**

```
Greeting message from the Public
```

## 2️⃣ Private 🔒

❇️ **Scope:** A private class member (method or variable) is accessible only within the same class. It cannot be accessed:

- From another class in the same package
- From a subclass
- From a different package

It is strictly limited to the class where it is declared.

❇️ **Usage:** The private modifier is used when you want an element (class, method, or variable) to be accessible only within the same class.

<u><b>Example</b></u>

📦 `utility/PrivateExample.java`

```java
package utility;

public class PrivateExample {

  private void display() {
    System.out.println("Greeting message from the Private");
  }
}
```

📦 `main/Main.java`

```java
package main;

import utility.PrivateExample;

public class Main {
  public static void main(String[] args) {
    PrivateExample example = new PrivateExample();
    example.display();   // ❌ Compile-time error
  }
}
```

❌ **Why It Fails**

- `display()` is `private`
- Private members are accessible **only inside the same class**
- Not accessible outside — even in same package
- Not accessible in subclass
- Not accessible in different package

❌ **Error**

```
display() has private access in utility.PrivateExample
```

## 3️⃣ Protected 🛡

❇️ **Scope:** The protected modifier allows access:

- Within the same package
- In subclasses (even if they are in different packages)

It is more restrictive than public, but less restrictive than private.

It supports controlled inheritance by allowing child classes to access and extend parent class functionality, while keeping it hidden from unrelated classes.

❇️ **Usage:**

Use protected when inheritance is part of your design.

- Define methods or fields in a superclass that should be reused or overridden by subclasses.
- Commonly used in frameworks and libraries to expose functionality to derived classes while restricting access from general external classes.

<u><b>Example</b></u>

📦 `utility/ProtectedExample.java`

```java
package utility;

public class ProtectedExample {

  protected void display() {
    System.out.println("Greeting message from the Protected");
  }
}
```

❌ **Case 1: Without Inheritance**

```java
package main;

import utility.ProtectedExample;

public class Main {
  public static void main(String[] args) {
    ProtectedExample example = new ProtectedExample();
    example.display();   // ❌ Compile-time error
  }
}
```

❌ **Why It Fails**

- Different package
- Not a subclass
- Protected does NOT allow direct access outside package

✅ **Case 2: With Inheritance**

```java
package main;

import utility.ProtectedExample;

public class Main extends ProtectedExample {
  public static void main(String[] args) {

    ProtectedExample example = new ProtectedExample();
    // example.display(); ❌ Still error

    Main main = new Main();
    main.display();   // ✅ Works
  }
}
```

⚠️ **Important Rule**

When subclass is in **different package**: Protected method can be accessed:

✔ Through subclass object <br>
❌ Not through parent class reference

That’s why this fails:

```java
ProtectedExample example = new ProtectedExample();
example.display();  // ❌
```

But this works:

```java
Main main = new Main();
main.display();     // ✅
```

✔ **Output**

```
Greeting message from the Protected
```

## 4️⃣ Default (Package-Private) 📂

❇️ **Scope:** If no access modifier is specified, the member gets default (package-private) access.

Such members are accessible:

✔ Within the same package <br>
❌ Not accessible from outside the package

This allows related classes in the same package to interact while keeping the functionality hidden from other parts of the application.

❇️ **Usage:** Use default access when you want to restrict visibility to package-level components.

- Ideal for internal helper classes, methods, or variables
- Useful for implementation details that should not be exposed outside the package
- Helps maintain modularity and proper encapsulation within a package

<u><b>Example</b></u>

📦 `utility/DefaultExample.java`

```java
package utility;

public class DefaultExample {

  void display() {
    System.out.println("Greeting message from the Default");
  }
}
```

❌ **Access From Different Package**

```java
package main;

import utility.DefaultExample;

public class Main {
  public static void main(String[] args) {
    DefaultExample example = new DefaultExample();
    example.display();   // ❌ Compile-time error
  }
}
```

❌ **Why It Fails**

- No modifier = package-private
- Accessible only inside same package

✅ **Access From Same Package**

```java
package utility;

public class Test {
  public static void main(String[] args) {
    DefaultExample example = new DefaultExample();
    example.display();   // ✅ Works
  }
}
```

✔ **Output**

```
Greeting message from the Default
```

## Comparison Table 📊

| Modifier    | Same Class | Same Package | Subclass (Diff Package)  | Other Package |
| ----------- | ---------- | ------------ | ------------------------ | ------------- |
| `private`   | ✅         | ❌           | ❌                       | ❌            |
| default     | ✅         | ✅           | ❌                       | ❌            |
| `protected` | ✅         | ✅           | ✅ (via subclass object) | ❌            |
| `public`    | ✅         | ✅           | ✅                       | ✅            |

## Conclusion 🎯

Access modifiers in Java define **how visible and accessible** classes, methods, and variables are within an application. They play a crucial role in enforcing **encapsulation, modularity, and clean design**.

- `private` → Restricts access strictly within the same class (maximum security).
- `default` (package-private) → Allows access only within the same package.
- `protected` → Allows access within the package and to subclasses in other packages.
- `public` → Allows access from anywhere.

Choosing the correct access modifier ensures:

- 🔐 Proper data hiding
- 🧩 Clear module boundaries
- 🏗️ Better maintainability
- 🎯 Controlled extensibility through inheritance

In short, always follow this best practice:

> **Start with the most restrictive access level and increase visibility only when necessary.**

## Resources 🔗

🕰️ Last Updated At: **23.02.2026**

- https://www.baeldung.com/java-access-modifiers
- https://www.geeksforgeeks.org/java/access-modifiers-java/
