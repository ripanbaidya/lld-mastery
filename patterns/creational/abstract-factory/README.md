# Abstract Factory Pattern

<p align="right"><b>Last updated: 26.02.2026</b></p>

![abstract-factory-banner](/resources/images/patterns/creational/abstract-factory-banner.png)

## Introduction 🔥

The **Abstract Factory pattern** is a **creational design pattern** that provides an interface for creating families of related or dependent objects without specifying their concrete classes. 

It is particularly useful when a system needs to be independent of how its products are created, composed, and represented.

## 🚨 Problem Statement

Let's say we are building an **E-commerce** system that supports multiple payment providers like:

- Stripe
- Razorpay

Each provider requires a family of related components:

- PaymentProcessor
- RefundProcessor
- WebhookHandler

❌ What can go wrong?

If we don’t use Abstract Factory:

```java
PaymentProcessor processor = new StripePaymentProcessor();
RefundProcessor refund = new RazorpayRefundProcessor();  // ❌ Wrong combination
```

Now:

- Payment is processed via Stripe
- Refund is attempted via Razorpay
- System becomes inconsistent
- Real production bug 🚨

## 🧠 Solution

We must ensure:

- If **Stripe** is selected → ALL Stripe components are used
- If **Razorpay** is selected → ALL Razorpay components are used

This requirement of creating consistent families of related objects is exactly why we use Abstract Factory Pattern.

## UML

![](/resources/images/patterns/creational/abstract-factory-uml.png)

## 🧑‍💻 Code Implementation

### Folder Structure

```text
├── product
│   ├── PaymentProcessor.java
│   ├── RefundProcessor.java
│   └── WebhookHandler.java
│
├── stripe
│   ├── StripePaymentProcessor.java
│   ├── StripeRefundProcessor.java
│   └── StripeWebhookHandler.java
│
├── razorpay
│   ├── RazorpayPaymentProcessor.java
│   ├── RazorpayRefundProcessor.java
│   └── RazorpayWebhookHandler.java
│
├── factory
│   ├── PaymentGatewayFactory.java
│   ├── StripePaymentGatewayFactory.java
│   └── RazorpayPaymentGatewayFactory.java
│
└── client
    └── Application.java
```

### STEP 1 — Abstract Products

1️⃣ **PaymentProcessor**

```java
public interface PaymentProcessor {
 
    void processPayment(double amount);
}
```

2️⃣ **RefundProcessor**

```java
public interface RefundProcessor {

    void processRefund(String transactionId);
}
```

3️⃣ **WebhookHandler**

```java
public interface WebhookHandler {

    void handleWebhook(String payload);
}
```

### STEP 2 — Stripe Family Implementation: Concrete Product A

**StripePaymentProcessor**

```java
public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Stripe: ₹" + amount);
    }
}
```

**StripeRefundProcessor**

```java
public class StripeRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(String transactionId) {
        System.out.println("Processing refund via Stripe for transaction: " + transactionId);
    }
}
```

**StripeWebhookHandler**

```java
public class StripeWebhookHandler implements WebhookHandler {

    @Override
    public void handleWebhook(String payload) {
        System.out.println("Handling Stripe webhook: " + payload);
    }
}
```

### STEP 3 — Razorpay Family Implementation: Concrete Product B

**RazorpayPaymentProcessor**

```java
public class RazorpayPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Razorpay: ₹" + amount);
    }
}
```

**RazorpayRefundProcessor**

```java
public class RazorpayRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(String transactionId) {
        System.out.println("Processing refund via Razorpay for transaction: " + transactionId);
    }
}
```

**RazorpayWebhookHandler**

```java
public class RazorpayWebhookHandler implements WebhookHandler {

    @Override
    public void handleWebhook(String payload) {
        System.out.println("Handling Razorpay webhook: " + payload);
    }
}
```

### STEP 4 — Abstract Factory

```java
public interface PaymentGatewayFactory {

    PaymentProcessor createPaymentProcessor();

    RefundProcessor createRefundProcessor();

    WebhookHandler createWebhookHandler();
}
```

### STEP 5 — Concrete Factories

**Stripe Factory**

```java
public class StripePaymentGatewayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new StripePaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new StripeRefundProcessor();
    }

    @Override
    public WebhookHandler createWebhookHandler() {
        return new StripeWebhookHandler();
    }
}
```

**Razorpay Factory**

```java
public class RazorpayPaymentGatewayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new RazorpayPaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new RazorpayRefundProcessor();
    }

    @Override
    public WebhookHandler createWebhookHandler() {
        return new RazorpayWebhookHandler();
    }
}
```

### STEP 6 — Client Code

```java
public class EcommerceApplication {

    public static void main(String[] args) {

        // Choose payment provider
        PaymentGatewayFactory factory = new StripePaymentGatewayFactory();

        PaymentProcessor paymentProcessor = factory.createPaymentProcessor();
        RefundProcessor refundProcessor = factory.createRefundProcessor();
        WebhookHandler webhookHandler = factory.createWebhookHandler();

        paymentProcessor.processPayment(5000);
        refundProcessor.processRefund("TXN12345");
        webhookHandler.handleWebhook("payment_success_event");
    }
}
```

## Output

```
Processing payment via Stripe: ₹5000.0
Processing refund via Stripe for transaction: TXN12345
Handling Stripe webhook: payment_success_event
```

## 📝 Real life example

1. **Payment gateway providers** Stripe / Razorpay / PayPal
2. **UI Themes**
3. **Database Drivers** - MySqlFactory, PostgreSql Factory, They created Connection, QueryExecutor, TransactionManager

## 🤔 When to Use 

1. **You Need Families of Related Objects**
2. **Objects Must Be Used Together** They are designed to work as a group.
3. **You Want to Enforce Consistency:** Prevent mixing incompatible implementations.
4. **You Want System-Level Switching:** Switch provider by changing just one line.
5. **You Want High-Level Decoupling:** Client should not know:
    - Concrete classes
    - How objects are created
    - How they relate internally

## 🤕 When not to use

1. Only one product exists
2. Only one implementation exists
3. Products are unrelated
4. Simpler Factory Method is sufficient

## ⚖️ Pros & Cons

### Pros ✅

1. **Ensures Product Compatibility:** Prevents mixing unrelated components.
2. **Strong Abstraction:** Client depends only on interfaces.
3.  **Open/Closed Principle:** Add new provider without modifying existing code.
4. **Easy Environment Switching:** Change factory → whole system switches.
5. **Clean Architecture:** Separates object creation and business logic.

### Cons ❌

1. **More Classes:** More interfaces and classes.
2. **Difficult to Extend:** Adding new products requires modifying all factories.
3. **Tight Coupling:** Products are tightly coupled to their factory.
4. **Not Suitable for Simple Systems:** Overkill for simple object creation.

## 🎤 Interview One-Liner

Abstract Factory is used when we need to **create families of releated objects** that must work together. It ensures **consistency** and prevents mixing incompatible implementations. In our payment gateway example, it guarantees that Stripe payment, refund, and webhook components are always used together.

## 📚 Resources

🔗 https://algomaster.io/learn/lld/abstract-factory <br>
🔗 https://refactoring.guru/design-patterns/abstract-factory <br>
🔗 https://codewitharyan.com/tech-blogs/abstract-factory-pattern <br>
🎥 https://www.youtube.com/watch?v=or1wpvH2Yps
