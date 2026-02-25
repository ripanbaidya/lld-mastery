# Design Patterns

![banner](/resources/images/patterns/banner.png)

<p align="right"><b>Last Updated:</b> 25.02.2026</p>

## Overview

Design patterns represent the best practices used by experienced object-oriented software developers.

Design patterns are solution to general problems that software developers faced during software development. These solutions were obtained by trail and error by numerous software developers over quite a substantial period of time.

**Characteristics** ✴️

- **Smart:** They are elegant solution that a novice developer would not come up with or think of immediately.

- **Generic:** They are normally not dependent on a specific system type, programming language or application domains. They are generic in nature.

- **Well-proved:** They have been identified from real, object oriented systems. They are not result or simple paper work, by they have been successfully tested in many systems.

- **Simple:** They are usually quite simple, involving small number of classes. The complex systems are built using different design patterns and there combinations.

- **Reusable:** They are not one-off solutions. They are reusable in many different systems.

- **Object-oriented:** They are built with the basic `OO` mechanisms such as `class`, `objects`, `interface`, `generalization`, `polymorphism` etc based on object-oriented principles.

## What is Gang of Four (GoF)

In `1994`, four authors `Erich Gamma`, `Richard Helm`, `Ralph Johnson`, and `John Vlissides` published a book called "Design Patterns: Elements of Reusable Object-Oriented Software" which introduced the concept of design patterns in the software development community.

These authors are collectively known as the "Gang of Four" (GoF). According to these authors design patterns are primarily based on the following principles of object oriented design:

- Program to an interface, not an implementation.
- Favor object composition over inheritance.

## Usage of Design Patterns

➡️ Usage of design patterns -

Design patterns have two main usage in software development:

1. Common platform for software development.
2. Best Practices

Let's discuss each of them in detail.

1. **Common platform for software development:**

Design patterns provide a standard terminology and are specific to particular scenario.

For example, a `singleton design pattern` signifies the use of single object so all developers familiar with `singleton design pattern` will make use of single object and they can tell each other that programs is following a singleton pattern.

2. **Best Practices:**

Design patterns have been evolved over a long period of time and they provide best solutions to certain problems faced during software development.

Learning these patterns help unexperienced developers to learn software design in an easy and fast way.

## Types of Design Patterns

As per the design pattern reference book `Design Patterns: Elements of Reusable Object-Oriented Software`, there are 23 design patterns which can be classified into three main categories:

- Creational
- Structural
- Behavioral

We will also discuss another category of design pattern:

- J2EE

---

### Creational Design Patterns

➡️ Introduction:

These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using the `new` keyword. This gives more flexibility to the system to change the object creation logic without affecting the client code.

➡️ Types of Creational Design Patterns:

1. **Abstract Factory**
2. **Builder**
3. **Factory**
4. **Prototype**
5. **Singleton**

---

### Structural Design Patterns

➡️ Introduction:

These design patterns concern class and object composition. Concepts of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities.

➡️ Types of Structural Design Patterns:

1. **Adapter**
2. **Bridge**
3. **Composite**
4. **Decorator**
5. **Facade**
6. **Flyweight**
7. **Proxy**

---

### Behavioral Design Patterns

➡️ Introduction:

These design patterns are specifically concerned with the interaction and communication between objects.

➡️ Types of Behavioral Design Patterns:

1. **Chain of Responsibility**
2. **Command**
3. **Interpreter**
4. **Iterator**
5. **Mediator**
6. **Memento**
7. **Observer**
8. **State**
9. **Strategy**
10. **Template Method**
11. **Visitor**

---

### J2EE Design Patterns

➡️ Introduction:

J2EE design patterns are specific to Java 2 Enterprise Edition (J2EE) platform. These design patterns are specifically concerned with the presentation tier of J2EE applications. These patterns are identified by Sun Java Center.

➡️ Types of J2EE Design Patterns:

1. **MVC (Model-View-Controller)**

## Benefits and Drawbacks of Design Patterns

### Benefits

- Increase developer productivity.
- Promote reuse of developement efforts.
- Describe proven solution to common problems.
- Increase the consistency between application.
- Potentially better than reusable code. Since, the system platfroms make the reusable code difficult to use.

### Drawbacks

- Insist the developer to learn a larger number of patterns.
- NIH (Not Invented Here) Syndrome can get in the way.
- Many developers are not willing to accept the work of others.
- It is very hard to accept to reuse the ideas, since each problem is unique.
- Pattern is quickly becomming a buzzword by marketing people rather than its intend.

## Resources 🔗

🔗 https://refactoring.guru/design-patterns/what-is-pattern <br>
