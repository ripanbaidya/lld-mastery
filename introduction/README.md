# Introduction to Low Level Design

## What is Low Level Design ?

When preparing for software engineering interviews, you'll often hear about two types of design rounds: **High-Level Design (HLD)** and **Low-Level Design (LLD)**.

While **HLD** focuses on system architecture, components, and how they interact at a macro level, **LLD** zooms in on the details of individual components.

Think of it this way:

- **HLD** answers: "What components do we need and how do they communicate?"
- **LLD** answers: "How do we actually implement each component?"

### <u>Definition</u>

**Low-Level Design (LLD)** is the process of translating high-level components into working code structure. It bridges the gap between architecture and implementation.

It is about answering the `“how”` of implementation. It moves beyond the "what" and dives into the granular details of the code structure. It defines the classes, interfaces, methods, and their relationships that implement a specific functionality.

Example:

- **High-Level Design (HLD)** says: "We need a `Notification Service`."
- **Low-Level Design (LLD)** says: "We’ll use an interface `NotificationSender` with concrete classes like `EmailSender`, `SmsSender`, `PushNotificationSender`, all managed by a `NotificationManager`."

### ➡️ Core Components of LLD

**1. Classes & Objects:**

The foundation of LLD involves identifying the primary entities and defining their structure. This includes:

- **Responsibilities:** Determining the specific role of each class.
- **Attributes (State):** The data or properties the class holds (e.g., `id`, `name`).
- **Methods (Behavior):** The actions or logic the class performs (e.g., `save()`, `validate()`).

**Example**: Food Delivery Application Initial modeling identifies classes like `User`, `Restaurant`, `Order`, and `Payment`. A `User` class might define:

- **Attributes:** `userId`, `email`, `phoneNumber`.
- **Methods:** `browseMenu()`, `placeOrder()`, `trackStatus()`.

**2. Interfaces & Abstraction :**

Interfaces define contracts between components. They are critical to ensure loose coupling, allowing multiple components to interact without depending on each other's internal implementation details.

**3. Relationship between classes :**

Classes dont exist in isolation, they are related to each other in some way and LLD define these relationships clearly and precisely.

Some of the Key-Relationships include:

- **Association**: A general "uses-a" relationship. A Doctor uses a Stethoscope.
- **Aggregation(Week has-A)**: An object contains other objects, but they can exist independently. A Department has Professors. If the department is closed, the professors still exist.
- **Composition(Strong has-A)**: An object is composed of other objects, and their lifecycles are tied. A House is composed of Rooms. If you demolish the house, the rooms are destroyed with it.
- **Inheritance(is-A)**: A class inherits properties and behaviors from a parent. A Car is a Vehicle.

⭐️ We can also define cardinality to specify the number of instances involved in a relationship.

1️⃣ **One-to-One**: One instance of A is linked to one instance of B. <br>
**Example**: Each User has one Profile.

2️⃣ **One-to-Many**: One instance of A is linked to multiple instances of B. <br>
**Example**: A Customer can have multiple Orders.

3️⃣ **Many-to-Many**: Multiple instances of A relate to multiple instances of B. <br>
**Example**: A Student can enroll in multiple Courses, and each Course can have multiple Students.

**4. Method signature :**

Once your classes and relationships are defined, the next step is deciding how they behave using methods. A well-designed method signature is self-documenting and intuitive.

You’ll need to decide:

- What methods should each class expose?
- What are the method's input parameters, and return types?
- Should the method be public, private, or protected?
- What exceptions might they throw?
- Is it synchronous or asynchronous?

Consistency, readability, and clarity in method signatures make your code intuitive and easier to maintain.

- **Bad**: void sendMsg(String str)
- **Good**: void sendNotification(Message message)

By designing expressive methods, you make your system intuitive to use and easy to extend, for example, adding new message types without rewriting existing code.

**5. Design patterns :**

LLD is also the stage where you apply proven solutions to common design problems using design patterns. These patterns provide reusable templates that bring structure, robustness, and maintainability to your code.

To know more about design patterns, check out the [Introduction to Design Patterns](/design-patterns/README.md) section

**6. Data structures :**

Data structures are the building blocks of LLD. They define how data is stored, retrieved, and manipulated. Common data structures include arrays, linked lists, stacks, queues, trees, and graphs.

### 💡 Importance of LLD in Software Development

A good LLD bridges the gap between idea and execution. It turns broad architectural concepts into practical, working software components that can evolve and scale over time.

1. **Scalability and Performance** – LLD ensures the system can handle growth efficiently without major code changes.
2. **Maintainability** – Well-structured classes make the code easy to understand, modify, and debug.
3. **Testability** – Proper abstraction enables isolated unit testing of individual components.
4. **Collaboration** – Clear design allows multiple developers to work in parallel without conflicts.
5. **Reusability** – Modular components can be reused across features and projects.
6. **Cost-effectiveness** – Good design reduces long-term development and maintenance costs.
7. **Flexibility and Adaptability** – LLD makes it easy to extend functionality without breaking existing code.

### 🚀 Importance of LLD in Interviews

LLD interviews go beyond writing compilable code. They evaluate how you think, how you design software, and how well your solutions scale and evolve over time.

1. **Problem Solving** – Ability to break down vague requirements into well-defined components.
2. **Object-Oriented Principles** – Understanding of abstraction, encapsulation, inheritance, and polymorphism.
3. **Design Patterns** – Applying the right pattern to solve recurring design problems cleanly.
4. **Data Structures** – Choosing appropriate data structures to support efficient operations.
5. **Clean Code** – Writing readable, maintainable, and well-structured code.
6. **Communication** – Clearly explaining design decisions and reasoning to the interviewer.
7. **Trade-offs** – Evaluating multiple design choices and justifying the best one.

## LLD vs HLD

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20240105160803/High-Level-Design-vs-Low-Level-Design-banner-(1).jpg" height="300" width="850"/>

In software engineering, building a complex system is like constructing a city.

You wouldn't start by laying bricks for a single house without a city plan. You first need to decide where the residential areas, commercial zones, power grids, and roads will go.

This city plan is your High-Level Design (HLD).

Once the city plan is approved, an architect takes a single plot of land in a residential zone and designs the detailed blueprint for a house specifying the number of rooms, the plumbing, the electrical wiring, and the materials to be used.

This detailed house blueprint is your Low-Level Design (LLD).

Both are essential, but they operate at different levels of abstraction and serve different purposes.

### <u>High Level Design (HLD)</u>

High-Level Design (HLD) defines the architecture of the system.

It answers the question:

> “How should the system be structured, and how will its major components interact?”

The focus here is on the `what`, not the `how`.

It answers questions like:

- **What are the major components or microservices?** (e.g., User Service, Payment Service, Notification Service, Product Catalog).
- **How will these components communicate?** (e.g., via REST APIs, gRPC, or a message queue like RabbitMQ or Kafka).
- **What technology stack will be used?** (e.g., Java vs. Python, SQL vs. NoSQL database).
- **How will the system handle scalability, reliability, and availability?** (e.g., using load balancers, database replication, CDNs).
- **What are the third-party integrations?** (e.g., Stripe for payments, AWS S3 for storage).
  The output of HLD is a set of architectural diagrams, data flow diagrams, and technology choices that define the system's skeleton.

The output of HLD is a set of architectural diagrams, data flow diagrams, and technology choices that define the system's skeleton.

**Example: 📍**

**HLD of a Ride-Hailing App**

- Services: Passenger Service, Driver Service, Matching Service, Billing Service.
- Communication: Matching Service uses a message queue to broadcast ride requests. Passenger and Driver services communicate via WebSockets for real-time location updates.
- Database: A NoSQL database for location data and a relational SQL database for user and billing information.
- Infrastructure: Load balancers to distribute traffic, with services deployed as containers on Kubernetes for scalability.

### <u>Low Level Design (LLD)</u>

LLD zooms in on a single component or module and translates the abstract architectural concepts into concrete, implementable details that developers can code directly.

It’s where you decide the internal structure of a service — the classes, methods, data models, design patterns, and relationships.

For a single module, it answers questions like:

- **What are the specific classes, and what are their responsibilities?**
- **What are the attributes and methods of each class?**
- **How do these classes relate to each other (inheritance, composition)?**
- **What design patterns are most suitable (e.g., Factory, Singleton, Strategy)?**
- **What are the specific method signatures, including parameters, return types, and exceptions?**

**✅ Example:**

**LLD of the Billing Service from the Ride-Hailing App**

- **Classes:** Ride, Invoice, PaymentStrategy, CreditCardPayment, WalletPayment.
- **Interfaces:** An interface IPaymentStrategy with a method processPayment(amount). CreditCardPayment and WalletPayment would implement this interface.
- **Relationships:** The Invoice class "has-a" Ride object (Composition).
- **Design Pattern:** The Strategy Pattern is used to allow the user to switch between different payment methods seamlessly.

### Difference between HLD and LLD

| Aspect      | HLD                                                                                    | LLD                                                                                                                   |
| ----------- | -------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| Focus       | What components exist                                                                  | How each component is built                                                                                           |
| Audience    | Architects, stakeholders                                                               | Engineers, developers                                                                                                 |
| Abstraction | System-level                                                                           | Module/class-level                                                                                                    |
| Artifacts   | System architecture diagrams                                                           | Class diagrams                                                                                                        |
| Example     | "We’ll use a microservices architecture with services for users, orders, and payments" | "The OrderService will use a PaymentProcessor interface with two implementations": StripeProcessor RazorpayProcessor" |

### 🔃 How HLD and LLD Work together ?

![](/resources/images/introdunction/how-lld-and-hld-work-together.png)

**Flow:**

1. **Requirement:** The client provides a high-level requirement, such as "We need a ride-hailing app with user authentication, ride booking, and payment processing."
2. **HLD:** The architect designs the system architecture, including the services, communication protocols, and technology stack.
3. **LLD:** The engineer designs the internal structure of each service, including the classes, methods, and relationships.
4. **Code:** The engineer implements the LLD, creating the actual code for each service.

## 📚 Types of LLD Interviews

Companies evaluate LLD skills in very different ways. What works for a whiteboard OOD round at Amazon won't help you in a machine coding round at Flipkart or a concurrency round at Uber.

Here are the five common formats of LLD interviews you should be aware of:

1. **Whiteboard OOD:** You design classes, relationships, and interactions on a whiteboard to demonstrate object modeling and design thinking without focusing on syntax.
2. **Machine Coding:** You implement a working solution with proper class design, clean code, and basic testability within a limited time.
3. **Concurrency:** You design thread-safe components and handle synchronization, race conditions, or shared resources correctly.
4. **API Design:** You define clear interfaces, method signatures, and request/response models that are easy to use and extend.
5. **Schema Design:** You design database tables, relationships, and constraints that support the application’s data and access patterns.

### 1️⃣ Object Oriented Design (OOD)

- Most common LLD format at big tech (Google, Amazon, Meta, Microsoft).
- Identify classes, attributes, methods, and relationships.
- Focus is on _design thinking_, not writing runnable code.
- Typically done on a whiteboard or doc with skeleton classes.
- Evaluates OOP fundamentals, SOLID, patterns, communication, and trade-offs.

### 2️⃣ Machine Coding

- You write **complete working code** that compiles and runs.
- Popular in Indian product companies and startups.
- Assessed on code quality, correctness, testing, project structure, and edge cases under time pressure.
- Minimal back-and-forth with interviewer.

### 3️⃣ Concurrency Design

- Focuses on thread-safety and handling concurrent access.
- Involves race conditions, synchronization (locks, semaphores), deadlock prevention, and performance.
- Often requires writing thread-safe designs/code.

### 4️⃣ API Design

- Design clear, usable interfaces for modules/services.
- Focus is on method signatures, contracts, error handling, and usability.
- Doesn’t dive into full implementation details.
- Typically part of both LLD and broader design interviews.

### 5️⃣ Schema Design

- Involves **data modeling** for databases: tables, relationships, constraints, and indexes.
- Focus is on how data should be structured to support queries efficiently.
- Often asked alongside OOD or in system design rounds rather than as a stand-alone LLD coding round.

## Quick Notes for Interview Prep

- **Ask your recruiter** which format you’ll face (whiteboard vs IDE).
- **Large US tech** tends to emphasize OOD.
- **Startups/Indian tech** may emphasize machine coding.
- **Performance-critical domains** (finance, backend infra) may include concurrency topics.

## Conclusion 📌

## Resources 🔗

🕰️ **Last Updated At: 22.02.2026**

🔗 https://codewitharyan.com/tech-blogs/what-is-low-level-system-design <br>
🔗 https://algomaster.io/learn/lld/what-is-lld <br>
