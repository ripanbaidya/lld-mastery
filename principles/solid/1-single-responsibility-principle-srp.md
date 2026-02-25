# SOLID Principles

![srp-banner](/resources/images/principles/solid-srp-banner.png)

<p align="right"><b>Last Updated:</b> 25.02.2026</p>

**Single-responsibility Principle (SRP)** states:

> A class should have one and **only one reason to change**, meaning that a class should have **only one job**.

👉 **It means one responsibility = one reason to change.**

**<u>Example</u>** ✴️

### ❌ Bad Example (SRP Violation)

Let’s say we’re building a simple User Registration system.

```java
public class UserService {

    public void registerUser(String name, String email) {
        // 1. Validate user
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        // 2. Save to database
        System.out.println("Saving user to database");

        // 3. Send email
        System.out.println("Sending welcome email");

        // 4. Log activity
        System.out.println("User registered successfully");
    }
}
```

Here, The `UserService` class has **multiple responsibilities**, like - 

1. Validate user
2. Save to database
3. Send email
4. Log activity

This Class might change at many reasons, like - 

1. If email format or logic changes
2. If database changes (MySql -> PostgreSql)
3. If logging mechanism changes (File -> Database)

This violates the SRP 🔥

### ✅ Good Example (SRP Followed)

To Solve the above problem, we can break down the `UserService` class into multiple classes, each with a single responsibility.

1️⃣ **Validation Class**

```java
public class UserValidator {

    public void validate(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}
```

Now, If validation logic changes, only `UserValidator` class will change. 🔥

2️⃣ **Database Class**

```java
public class UserRepository {

    public void save(String name, String email) {
        System.out.println("Saving user to database");
    }
}
```

Now, If database logic changes, only `UserRepository` class will change. 🔥

3️⃣ **Email Class**

```java
public class EmailService {

    public void send(String email) {
        System.out.println("Sending welcome email");
    }
}
```

Now, If email logic changes, only `EmailService` class will change. 🔥

4️⃣ **Logging Class**

```java
public class LoggingService {

    public void log(String message) {
        System.out.println(message);
    }
}
```

Now, If logging logic changes, only `LoggingService` class will change. 🔥

5️⃣ **Now Main Service (Coordinator Only)**

```java
public class UserService {

    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final LoggingService loggingService;

    public UserService(UserValidator userValidator, UserRepository userRepository, 
                        EmailService emailService, LoggingService loggingService
    ) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.loggingService = loggingService;
    }

    public void registerUser(String name, String email) {
        userValidator.validate(email);
        userRepository.save(name, email);
        emailService.send(email);
        loggingService.log("User registered successfully");
    }
}
```
Now, We can see that each handling having single responsibility, so it is easy to understand, test, maintain, modify, debug, reuse, extend, refactor, deploy and scale. 🔥

## 🎯 Benefits of SRP

| Without SRP       | With SRP              |
| ----------------- | --------------------- |
| Large messy class | Small focused classes |
| Hard to test      | Easy to test          |
| Tight coupling    | Loose coupling        |
| High risk of bugs | Low risk              |

## Benefits of SRP

1. **Easy to understand** - Each class has a single responsibility, making it easy to understand.
2. **Easy to test** - Each class can be tested independently.
3. **Easy to maintain** - Each class can be maintained independently.
4. **Easy to modify** - Each class can be modified independently.
5. **Easy to debug** - Each class can be debugged independently.
6. **Easy to reuse** - Each class can be reused in other projects.
7. **Easy to extend** - Each class can be extended independently.
8. **Easy to scale** - Each class can be scaled independently.

## Resources 🔗

🔗 https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#single-responsibility-principle