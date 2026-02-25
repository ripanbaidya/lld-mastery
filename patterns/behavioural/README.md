![behavioural-design-pattern](/resources/images/patterns/behavioural/banner.png)

<p align="right"><b>Last Updated:</b> 25.02.2026</p>

## Introduction 🔥

The term **Behavioral Design Patterns** comes from the famous GoF book **Design Patterns: Elements of Reusable Object-Oriented Software**

These patterns focus on:

> **How objects communicate, assign responsibilities, and manage behavior dynamically.**

- Interaction between objects
- Decoupling responsibilities
- Reducing conditional complexity
- Runtime behavior changes

Unlike:

- **Creational** → how objects are created
- **Structural** → how objects are composed
- **Behavioral** → how objects behave & communicate

## 🧭 When to Use / Avoid

### ✅ Use When

- Multiple objects must communicate
- You need runtime behavior switching
- You want to remove large `if-else` blocks
- You need undo/redo
- You want event-driven architecture
- You process requests in pipelines
- Behavior depends on state

### ❌ Avoid When

- System is small/simple
- Behavior is stable
- It adds unnecessary abstraction
- It causes too many classes
- It harms readability

## 📦 Types of Behavioral Patterns (11 Total)

### 1️⃣ Strategy Pattern

**📌 Idea:** Encapsulate interchangeable algorithms.

**🔥 Interview Insight:**

Removes conditional complexity. <br>
Follows OCP.

### 2️⃣ Observer Pattern

**📌 Idea:** One-to-many dependency. Observers auto-notified.

**Example:**

- YouTube subscribers notified of new video
- Stock price update listeners

Used heavily in:

- Event-driven systems
- Spring events
- UI frameworks

### 3️⃣ Command Pattern

**📌 Idea:** Encapsulate a request as an object.

**Example:** Remote control button: Button → Command → Light On

**Useful for:**

- Undo/Redo
- Task queues
- Job scheduling

### 4️⃣ Chain of Responsibility

**📌 Idea:** Pass request through chain until handled.

**Example:** Backend request pipeline <br>
Auth → Logging → Validation → Controller

**Very common in:**

- Servlet Filters
- Spring Security filter chain

### 5️⃣ State Pattern

**📌 Idea:** Object changes behavior based on internal state.

**Example:**

ATM states: <br>
NoCard → HasCard → PinVerified

Instead of big conditionals, behavior delegated to state objects.

### 5️⃣ State Pattern

**📌 Idea:** Object changes behavior based on internal state.

**Example:**

ATM states: <br>
NoCard → HasCard → PinVerified

Instead of big conditionals, behavior delegated to state objects.

### 6️⃣ Template Method Pattern

**📌 Idea:** Define algorithm skeleton in parent class.

**Example:** <br>
Define algorithm skeleton in parent class. <br>
Subclasses override certain steps.

**Used in:**

- Spring’s `JdbcTemplate`
- Fixed workflow systems

### 7️⃣ Iterator Pattern

**📌 Idea:** Access collection sequentially without exposing internals.

**Example:**

```java
Iterator<String> it = list.iterator();
```

Built-in in Java Collections Framework.

### 8️⃣ Mediator Pattern

**📌 Idea:** Central object manages communication.

**Example:**

Air traffic controller coordinates planes. <br>
Reduces tight coupling between components.

### 9️⃣ Memento Pattern

**📌 Idea:** Capture & restore object state.

**Example:** <br>
Undo in text editor.

### 🔟 Visitor Pattern

**📌 Idea:** Add new operations without modifying object structure.

**Example:** <br>
Different tax rules for:

- Food
- Electronics
- Clothing

Useful when structure is stable but operations change.

## 1️⃣1️⃣ Interpreter Pattern

**📌 Idea:** Define grammar + interpreter for language.

**Example:** <br>
Mathematical expression evaluator.

**Used in:**

- Rule engines
- Query parsers

## 🎯 Quick Comparison Table

| Pattern     | Solves What?                |
| ----------- | --------------------------- |
| Strategy    | Runtime algorithm switching |
| Observer    | Event notification          |
| Command     | Encapsulated request        |
| Chain       | Processing pipeline         |
| State       | Behavior depends on state   |
| Template    | Fixed workflow              |
| Iterator    | Collection traversal        |
| Mediator    | Centralized communication   |
| Memento     | Undo / restore state        |
| Visitor     | Add new operations          |
| Interpreter | Custom language processing  |

## Resources 📚

🔗 https://codewitharyan.com/tech-blogs/behavioral-design-pattern <br>
