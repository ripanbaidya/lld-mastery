# YAGNI (You Aren't Gonna Need It) Principle

<p align="right"><b>Last Updated:</b> 24.02.2026</p>

<img src="/resources/images/principles/yagni.png" height="300px" width="500px" align="center" style="border-radius: 10px;"><br>

**YAGNI** stands for **"You Aren't Gonna Need It"**. It is a principle in software development that suggests developers should only implement features that are necessary for the current requirements and not add any additional functionality that might be needed in the future.

❇️ This principle is based on the idea that adding unnecessary features can lead to **increased complexity, longer development times, and potentially more bugs**.

❇️ The **YAGNI principle** is closely related to the **"KISS" principle ("Keep It Simple, Stupid")**, which advocates for **simplicity in design and avoiding unnecessary complexity**. Both principles encourage developers to focus on delivering the simplest solution that meets current requirements, rather than trying to anticipate and accommodate potential future needs.

### ✅ **Why a developer should follow the YAGNI principle?**

The developer should follow YAGNI principles for the following reasons:

1️⃣ _**Cost of Building**_: The cost of build is the amount of time, effort, and resources spent on creating a feature or solution. It includes everything from planning and coding to testing. <br>

2️⃣ _**Cost of Delay**_: The cost of delay is the missed opportunity or economic impact of not delivering a feature or solution promptly. <br>

3️⃣ _**Cost of Carry**_: When a feature adds complexity, it can make it harder to work on other parts of the software, leading to additional time and effort. <br>

4️⃣ _**Cost of Repair**_: The cost of repair, also known as technical debt, is the ongoing cost associated with fixing mistakes, bugs, or poor choices made during the development of a feature.

## Example

Imagine you are building a simple User Registration System. and your **Current requirement** is **Register user and save to database**

But you think: **“In future we might need SMS, Email verification, OAuth, Role system…”**

So you write this:

**<u>Without YAGNI</u>** ❌

```java
class UserService {

    public void register(User user) {
        validate(user);
        saveToDatabase(user);
        sendEmail(user);
        sendSMS(user);
        assignDefaultRole(user);
    }

    private void validate(User user) { }
    private void saveToDatabase(User user) { }
    private void sendEmail(User user) { }
    private void sendSMS(User user) { }
    private void assignDefaultRole(User user) { }
}
```

🚨 **Problem here:**

SMS not required ❌<br>
Roles not required ❌<br>
Email not required ❌

You just added unnecessary complexity. <br>**That’s a violation of YAGNI.**

**<u>With YAGNI</u>** ✅

```java
class UserService {

    public void register(User user) {
        validate(user);
        saveToDatabase(user);
    }

    private void validate(User user) { }
    private void saveToDatabase(User user) { }
}
```

Later, if the client says: **“We need email verification.”** <br>
Then you add it.

## **Steps to follow YAGNI Principle** 📝

![](/resources/images/principles/yagni-flow-diagram.png)

To use YAGNI as a developer, it's like having a practical guide to keep your work focused and efficient.

1️⃣ **Get the Necessary Requirements :** All the things your project needs and sort them into "must-haves" and "can wait."

2️⃣ **Discuss with Your Team :** After that, it's time to talk with your team. Share your plans and goals with them. This makes sure everyone is on the same page and understands what needs to be done.

3️⃣ **Analyze a Simple Plan for the Solution** : Now, when it comes to planning the actual work, keep it simple. Break down your big goals into smaller tasks. This helps you avoid getting overwhelmed and ensures you're focusing on what really matters.

4️⃣ **Refuse If It Doesn't Fit for the Solution** : Sometimes, your team might come up with new ideas or want to add extra things. While these ideas might be cool, you've got to be ready to say "no" unless it's a tiny improvement. Saying "no" can be tough, but it keeps you from getting off track and missing deadlines.

5️⃣ **Have a Record of Your Progress** : Keep a record of what you've done. It's like keeping score in a game. This helps you see how far you've come and if you're heading in the right direction.

## Advantages & Disadvantages of YAGNI

### ✅ Advantages

1. **Faster Development** – Focus only on current requirements, reducing unnecessary work.
2. **Simplicity** – Keeps the codebase clean, readable, and easier to maintain.
3. **Cost Savings** – Saves time and resources by avoiding unused features.
4. **User Focus** – Ensures effort is spent on delivering real user value.

### ❌ Disadvantages

1. **Incomplete Solutions** – Minimal implementation may cause technical debt later.
2. **Estimation Challenges** – Future requirements are hard to predict accurately.
3. **Refactoring Overhead** – Adding features later may require major changes.
4. **Team Misalignment** – Different views on what is “necessary” can create conflict.

## Resources 🔗

🔗 https://codewitharyan.com/tech-blogs/yagni-priniciple <br>
🔗 https://www.geeksforgeeks.org/software-engineering/what-is-yagni-principle-you-arent-gonna-need-it/
