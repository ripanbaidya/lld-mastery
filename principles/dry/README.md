# DRY (Don’t Repeat Yourself) Principle

<p align="right"><b>Last Updated - </b> 24.02.2026</p>

<img src="/Users/ripanbaidya/Documents/system-design/low-level-design/resources/images/principles/dry.png" height="300px" width="500px" align="center" style="border-radius: 10px;"><br>

**DRY (Don’t Repeat Yourself)** is a principle in programming that means you should avoid writing the same piece of code multiple times.

If you find the same code written in many places, it means you are not following the DRY rule.

Instead of repeating code, you can put it inside a method and call that method whenever you need it. This way, your code becomes **shorter**, **cleaner**, and **easier to maintain**. It also makes the code **reusable**.

**Importance of DRY Principle** 🔥

1. Reduces code duplication & Increases code readability
2. Makes programs easier to read and maintain
3. Encourages reusability
4. Reduce the development time
5. Consistency

## Example

### Implementation - Without DRY Principle ❌

```java
public class StudentMarks {

    // Method 1: Print marks for Math
    public void mathMarks() {
        System.out.println("Subject: Math");
        System.out.println("Marks: 90");
    }

    // Method 2: Print marks for Science
    public void scienceMarks() {
        System.out.println("Subject: Science");
        System.out.println("Marks: 85");
    }

    // Main method
    public static void main(String[] args) {
        // Creating object of class
        StudentMarks s = new StudentMarks();

        // Calling methods one by one
        s.mathMarks();
        s.scienceMarks();
    }
}
```

### Output:

```
Subject: Math
Marks: 90
Subject: Science
Marks: 85
```

**What’s wrong here?**

- We repeated the same printing logic `System.out.println("Subject: ...");` and `System.out.println("Marks: ...");` in every method.

- This **violates** the DRY principle because the same type of code is scattered in multiple places.

### Implementation - With DRY Principle ✅

```java
public class StudentMarks {

    // Single method to print subject and marks
    public void printMarks(String subject, int marks) {
        System.out.println("Subject: " + subject);
        System.out.println("Marks: " + marks);
    }

    // Main method
    public static void main(String[] args) {
        // Creating object of class
        StudentMarks s = new StudentMarks();

        // Reusing the same method for all subjects
        s.printMarks("Math", 90);
        s.printMarks("Science", 85);
    }
}
```

### Output

```
Subject: Math
Marks: 90
Subject: Science
Marks: 85
```

**Why this is better (DRY):**

- **No code duplication** – we have only one method for printing.
- **Reusable** – just pass subject name and marks.
- **Easier to maintain** – if we change how marks are displayed, we edit only one method.

## Advantages & Disadvantages

### Adtantages 😎

1️⃣ **Efficiency:** Reduces the amount of code written, saving development time. <br>
2️⃣ **Maintainability:** Changes in logic or functionality only need to be applied once, reducing the risk of introducing errors. <br>
3️⃣ **Scalability:** Modular and reusable code makes it easier to extend the application. <br>
4️⃣ **Consistency:** Ensures uniform behavior across the application. <br>
5️⃣ **Collaboration:** Clean, organized code improves teamwork and reduces onboarding time for new developers. <br>

### Disadvantages 🤕

1️⃣ **Over-Abstraction Risks:** Too much abstraction can make code harder to read and debug. <br>
2️⃣ **Initial Time Investment:** Writing reusable code often requires more upfront planning and effort. <br>
3️⃣ **Misuse:** Applying DRY inappropriately to unrelated functionalities can lead to tight coupling and reduced flexibility. <br>
4️⃣ **Complex Refactoring:** Refactoring legacy code to adhere to DRY can be time-consuming and error-prone. <br>

## Resources

🔗 https://www.baeldung.com/cs/dry-software-design-principle <br>
🔗 https://codewitharyan.com/tech-blogs/dry-principle <br>
🎥 https://youtu.be/uxe_0RFgT7A [Video]<br>
