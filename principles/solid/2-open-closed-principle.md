# SOLID Principles

<p align="right"><b>Last Updated:</b> 25.02.2026</p>

![ocp-banner](/resources/images/principles/solid-ocp-banner.png)

**Open-closed Principle (OCP) states:**

> Objects or entities should be open for extension but closed for modification.

👉 **Open for Extension** <br>
👉 **Closed for Modification**

_This means that:_

✅ You should be able to **add new behavior** <br>
❌ Without changing existing working code

## 🧠 Why OCP Is Important

In real companies:

- Features keep changing
- New business rules come
- Payment providers change
- New user roles are added

If every new feature forces you to edit old code → you break existing logic.

That’s dangerous in production systems.

## Example

### ❌ Bad Example (OCP Violation)

Let’s say we are building a payment system.

```java
public class PaymentService {

    public void processPayment(String type) {

        if (type.equals("CREDIT_CARD")) {
            System.out.println("Processing credit card payment");
        }
        else if (type.equals("UPI")) {
            System.out.println("Processing UPI payment");
        }
    }
}
```

❌ **Problem** - Now business says: Add **PayPal**, Add **Crypto**, Add **Net Banking** <br>
**Every time you must:**

1. Modify this class
2. Add another `else if`
3. Retest everything

🔥 **This violates OCP because:**

- Class is NOT closed for modification
- You must change it to add new behavior

---

### ✅ Correct Approach (Following OCP)

Instead of modifying existing class, we extend behavior.

👉 **Step 1: Create an Interface**

```java
public interface PaymentMethod {
    void pay();
}
```

👉 **Step 2: Create Implementations**

```java
public class CreditCardPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing credit card payment");
    }
}
```

```java
public class UpiPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing UPI payment");
    }
}
```

👉 **Step 3: Modify PaymentService (Only Once)**

```java
public class PaymentService {

    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.pay();
    }
}
```

👉 **Step 4: Usage**

```java
PaymentService service = new PaymentService();

service.processPayment(new CreditCardPayment());
service.processPayment(new UpiPayment());
```

👉 **Now What Happens If the requirement comes to add new payment method?**

> We can add new class without modifying existing class by extending the PaymentMethod interface. 

❇️ Let's say, we want to add **PayPal Payment** method.

```java
public class PaypalPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing PayPal payment");
    }
}
``` 

👉 We DO NOT modify `PaymentService`, Rather we just **extend** system.

🔥 **_That is OCP._**


## 🧪 Interview Deep Insight

🗣️ **Interviewer may ask:** **“How does OCP relate to Strategy Pattern?”** <br>
🧑‍💻 **Answer**: **OCP** is a principle and **Strategy** is a design pattern that helps implement **OCP**

## ⚡ Important Rule

If you see:

```java
if(type == X)
else if(type == Y)
else if(type == Z)
```

⚠️ 80% chance **OCP** is being violated.

## 📊 Before vs After

| Without OCP    | With OCP       |
| -------------- | -------------- |
| if-else chain  | Polymorphism   |
| Hard to scale  | Easy to extend |
| Risky changes  | Stable core    |
| Tight coupling | Loose coupling |


## Conclusion 🎯 

Open Closed Principle means:

✔ Open for extension <br>
✔ Closed for modification <br>
✔ Use interfaces <br>
✔ Use polymorphism <br>
✔ Avoid modifying stable code <br>
✔ Extend behavior instead <br>

## Resources 🔗

🔗 https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#open-closed-principle