# Constructor

- A constructor is a **method** whose name is same as that of the **classname**
- A constructor would not have a **return type**.
- Constructors gets called during the **creation of an object**
- Constructors are normally used to give meaningful value to the **instance variables** of the class.

**Note**: In a class, if we don't write any constructor only then compiler will add **default consturctor** to our class.

- Default constructor would not supply any meaningful values to the instance variables of the class.

- To supply meaningful values to the instance variables, we need to write **Parameterized constructor**.

**Code**

```java
class Student {
  // Instance variables
  String name;
  int age;
  float height;

  // Constructor
  Student(String name, int age, float height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }
}

class Test {
  public static void main(String[] args) {

    Student std = new Student("sachin", 49, 5.5f);

    System.out.println("Name is :: " + std.name);
    System.out.println("Age is :: " + std.age);
    System.out.println("Height is :: " + std.height);
  }
}
```

**Output**

```
Name is :: sachin
Age is :: 49
Height is :: 5.5
```

---

𝐐. **Can a Constructor be Overloaded?**

**Ans**. Yes, it is possible to Overload a constructor, but it is not a good practise to write zero argument constructor with a logic of **"initialization"**.

**Code**

```java
class Student {
  String name;
  int age;
  float height;

  Student(String name, int age, float height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }

  Student() {
    name = "dhoni";
    age = 41;
    height = 5.6f;
  }
}
```

---

𝐐. **Can we have normal method with the name same as classname and also constructor?**

**Ans**. yes, it is possible, but the constructor will be called during the creation of object where as normal method should be called by the
programmer explicitly.

**Code**

```java
class Student {
  String name;
  int age;
  float height;

  // Parameterized constructor
  Student(String name, int age, float height) {
    System.out.println("Calling the Constructor");
    this.name = name;
    this.age = age;
    this.height = height;
  }

  // Normal method
  void Student() {
    System.out.println("Calling the normal method");
  }
}
```

---

𝐐. **Can we Overload main()?**

**Ans**. yes we can overload main(),but jvm will always call main() with the following signature

```java
public static void main(String[] args)
```

**Code**

```java
class Test {
  public static void main(String[] args) {
    System.out.println("Inside String[] args");
  }

  public static void main(int arg) {
    System.out.println("Inside int arg");
  }

  public static void main() {
    System.out.println("Inside zero argument");
  }
}
```

## ⭐️ Types of Constructor

Constuctor can be brodly categorized into the following types -

### 1️⃣ Default Constructor

When No Constructor Is Defined **(Implicit Default Constructor)**

> ‍ If you do not explicitly create any constructor for a class, Java automatically provides a default constructor.

This constructor initializes instance variables to their default values based on the data type.

**Default Values:**

```
int → 0
double → 0.0
boolean → false
Object → null
```

‍
**Code**

```java
class Movie {
  private String title; // Default: null
  private int duration; // Default: 0

  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}

public class Main {
  public static void main(String[] args) {
    Movie movie = new Movie(); // Implicit default constructor is called
    movie.displayDetails(); // Displays default values
  }
}
```

**Output**

```
Title: null, Duration: 0 mins
```

**Explicitly Defining a Default Constructor with Custom Values** :

> You can define your own default constructor to set custom default values for the class fields instead of relying on Java's implicit default values.

**Code**

```java
class Movie {
  private String title;
  private int duration;

  // Explicitly defined default constructor
  Movie() {
    title = "Unknown Movie";
    duration = 90;
  }

  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}

public class Main {
  public static void main(String[] args) {
    Movie movie = new Movie(); // Calls the explicitly defined default constructor
    movie.displayDetails();
  }
}
```

**Output**

```
Title: Unknown Movie, Duration: 90 mins
```

By explicitly defining a default constructor, you gain control over how objects are initialized, ensuring that they start with meaningful default values that match the application's requirements.

### 2️⃣ Parameterized Constructor

A parameterized constructor takes arguments to initialize the object with specific values.
‍
**Code**

```java
class Movie {
  private String title;
  private int duration;

  // Parameterized constructor
  Movie(String title, int duration) {
    this.title = title;
    this.duration = duration;
  }

  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}

public class Main {
  public static void main(String[] args) {
    Movie movie1 = new Movie("The Matrix", 136); // Calls parameterized constructor
    Movie movie2 = new Movie("Inception", 148);

    movie1.displayDetails();
    movie2.displayDetails();
  }
}
```

**Output**

```
Title: The Matrix, Duration: 136 mins
Title: Inception, Duration: 148 mins
```

### 3️⃣ Copy Constructor

A copy constructor initializes an object using another object of the same class.

**Code**

```java
class Movie {
  private String title;
  private int duration;

  // Parameterized constructor
  Movie(String title, int duration) {
    this.title = title;
    this.duration = duration;
  }

  // Copy constructor
  Movie(Movie other) {
    this.title = other.title;
    this.duration = other.duration;
  }

  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}

public class Main {
  public static void main(String[] args) {
    Movie movie1 = new Movie("The Matrix", 136);
    Movie movie2 = new Movie(movie1); // Calls copy constructor

    movie1.displayDetails();
    movie2.displayDetails();
  }
}
```

**Output**

```
Title: The Matrix, Duration: 136 mins
Title: The Matrix, Duration: 136 mins
```

### 4️⃣ Private Constructor

> A private constructor is used to restrict object creation from outside the class. It is commonly used in Singleton Design Pattern.

**Code**

```java
class Singleton {
  private static Singleton instance;

  // Private constructor
  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

public class Main {
  public static void main(String[] args) {
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println(s1 == s2); // Output: true, as both references point to the same instance
  }
}
```

## Constructor Chaining

Constructor chaining is a technique in object-oriented programming where one constructor calls another constructor within the same class or in the superclass. This is achieved using the `this()` and `super()` keywords.

### 1️⃣ Constructor Chaining Using "this()"

👉 Calls another constructor within the same class <br>
👉 Must be the first statement

**Code**

```java
class Movie {
  private String title;
  private int duration;

  // Constructor 1
  Movie(String title) {
    System.out.println("Single parameter constructor");
    this.title = title;
  }

  // Constructor 2
  Movie(String title, int duration) {
    this(title); // Must be first statement
    System.out.println("Two parameter constructor");
    this.title = title;
    this.duration = duration;
  }

  /*
  Movie(String title, int duration) {
    System.out.println("Two parameter constructor");
    this(title); // Invalid Order
    this.title = title;
    this.duration = duration;
  }
  */

  public void displayDetails() {
    System.out.println(title + " " + duration);
  }
}

public class Main {
  public static void main(String[] args) {
    Movie movie = new Movie("The Matrix", 136);

    movie1.displayDetails();
  }
}
```

**Output**

```
Single parameter constructor
Two parameter constructor
The Matrix 136
```

### 2️⃣ Constructor Chaining Using "super()"

👉 Calls parent class constructor <br>
👉 Must be first statement <br>
👉 Compiler inserts super() automatically if not written

**Code**

```java
class Animal {
  String type;

  Animal(String type) {
    System.out.println("Animal constructor");
    this.type = type;
  }
}

class Dog extends Animal {
  String breed;

  Dog(String type, String breed) {
    // Must be first statement
    super(type); // calling parent constructor
    System.out.println("Dog constructor");
    this.breed = breed;
  }

  void display() {
    System.out.println(type + " - " + breed);
  }
}

class Main {
  public static void main(String[] args) {
    Dog d = new Dog("pet", "labrador");
    d.display();
  }
}
```

**Output**

```
Animal constructor
Dog constructor
pet - labrador
```

**Execution Order:** **When creating child object**:

1. Parent constructor executes
2. Child constructor executes

> Always top → down hierarchy.

## Interview Questions 🧑‍🏫

### 𝐐. Can a constructor be final, static, or abstract? Why or why not?

✅ **final** - Not Allowed ❌, Reason<br>

➡ `final` prevents overriding. <br>
➡ Constructors are **not inherited**, so they cannot be overridden. <br>
➡ Therefore `final` makes no sense.

```java
class A {
    final A() {}   // Compile error
}
```

✅ **static** → Not Allowed ❌, Reason<br>

➡ `static` belongs to class. <br>
➡ Constructor belongs to object. <br>
➡ Constructor is used to create instance → cannot be static. <br>

```java
class A {
    static A() {}   // Compile error
}
```

✅ **abstract** → NOT allowed ❌, Reason<br>

➡ `abstract` means incomplete method. <br>
➡ Constructor must fully initialize object. <br>
➡ Abstract constructor makes no logical sense.

```java
abstract class A {
    abstract A();  // Compile error
}
```

### 𝐐. What happens if you explicitly define a constructor with arguments but no default constructor?

👉 Compiler `DOES NOT` generate default constructor.

**Code**

```java
class A {
    A(int x) {}
}

public class Test {
    public static void main(String[] args) {
        A obj = new A();   // Compile error
    }
}
```

**Error:**

```
constructor A in class A cannot be applied to given types
```

### 𝐐. What happens if you create an object of a subclass? Which constructor is called first?

👉 Parent constructor is called first <br>
👉 Then child constructor executes

**Code**

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }

    public static void main(String[] args) {
        new Child();
    }
}
```

**Output:**

```
Parent constructor
Child constructor
```

**Why?** becuase, Compiler inserts: `super()`. <br>

🔥 **Rule**: Constructor execution goes from top of hierarchy → bottom.

### 𝐐. What happens if a constructor is synchronized?

NOT allowed, Reason:

➡ `synchronized` is used for thread control. <br>
➡ Constructor is called during object creation. <br>
➡ Locking constructor has no meaning because object isn’t fully constructed yet. <br>

```java
class A {
    synchronized A() {} // modifier synchronized not allowed here
}
```

### 𝐐. Can a constructor be inherited?

No, Constructors are NOT inherited.

**Code**

```java
class A {
    A() {
        System.out.println("A constructor");
    }
}

class B extends A {
}
```

Even though `B` doesn’t inherit constructor, it can call it using `super()`.

If you try:

```java
B obj = new B();
```

Compiler inserts `super()` automatically.

### 𝐐. Can a constructor have a return statement?

YES (but without value)

```java
class A {
    A() {
        System.out.println("Constructor");
        return;   // allowed
    }
}
```

✔ Allowed <br>
✔ Just exits constructor early

❌ Cannot return value

```java
class A {
    A() {
        return 10;  // ❌ Compile error
    }
}
```

**Why?** because, Constructors do not have return type.


## Conclusion

## Resources

- https://www.geeksforgeeks.org/java/constructors-in-java/
