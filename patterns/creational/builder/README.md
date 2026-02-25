# Builder Pattern

<p align="right"><b>Last Updated: 25.02.2026</b></p>

## Introduction 🔥

In our journey through **software development**, we often encounter scenarios where creating objects with numerous properties becomes intimidating. Cluttering our constructors is making our code **less readable**. This is precisely where the **Builder Pattern** shines.

The **Builder Pattern** is a **creational design pattern** that separates the **construction** of complex objects from their **representation**, offering a **cleaner and more flexible approach** to object creation.

## Problems

Imagine, You are builder the backend of a **blog** application. and You need to crate a **Post** object. and it may Contains fields like - `title(required)`, `content(required)`, `author(required)`, `image(optional)`, `category(optional)`, `visibility(optional)`, `publishedDate(optional)` and etc.

Now, imagine you are creating object like this way -

```java
Post(String title, String content, String author)
Post(String title, String content, String author, String category)
Post(String title, String content, String author, String category, String image)
Post(String title, String content, String author, String category, String image, String visibility)
```

With this apporach we will encounter **telescoping constructor** problem.

Code will become **error-prone**, **hard to maintain**, **readability** will be decreased.

But, What we actually need so that we dont face the above problems. **We need**

- Clean object creation
- Optional parameters support
- Readable code
- Immutable object
- Validation before creation

### **Solution:** Builder Pattern 💡

Builder lets us:

- Build object step-by-step
- Set only required fields
- Add optional fields when needed
- Call `build()` at the end

## Components

1️⃣ **Product**

- The complex object we want to create.
- It has private fields
- Constructor is private
- Object is Immutable(final fields)

So, `Post = Product`

2️⃣ **Builder**

- Static inner class
- Contains same fields
- Provides step-by-step setter methods
- Returns this for method chaining
- Has build() method

**Note:** In modern Java, we usually don’t separate `Builder` interface and `ConcreteBuilder` unless needed.

So, `Post.Builder = Builder + Concrete Builder (combined)`

3️⃣ **Director (Optional)**

The **Director** part is optional, as In modern java we usually let the client control the construction process directly.

4️⃣ **Client**

- Uses the Builder to create the product.

## UML

![](/resources/images/patterns/creational/builder-uml.png)

## Implementation

### ✅ Classic Builder Pattern

```java
// Product
public class Post {

  // Private fields (Immutable)
  private final String title;
  private final String text;
  private final String category;

  // Private constructor
  private Post(Builder builder) {
    this.title = builder.title;
    this.text = builder.text;
    this.category = builder.category;
  }

  // Getters

  public String getTitle() {
    return title;
  }

  public String getText() {
    return text;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "Post{" +
        "title='" + title + '\'' +
        ", text='" + text + '\'' +
        ", category='" + category + '\'' +
        '}';
  }

  // Builder
  public static class Builder {
    private String title;
    private String text;
    private String category;

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder category(String category) {
      this.category = category;
      return this;
    }

    // Build method
    public Post build() {
      return new Post(this);
    }
  }
}
```

### 😎 Client

```java
public class Main {
  public static void main(String[] args) {
    
    // Creating object using builder
    Post post = new Post.Builder()
        .title("Builder Pattern")
        .text("Builder Pattern is a creational design pattern")
        .category("Design Pattern")
        .build();

    System.out.println(post);
  }
}
```

### 💻 Output

```
Post{title='Builder Pattern', text='Builder Pattern is a creational design pattern', category='Design Pattern'}
```

## When to use 🤔

- Object has many optional parameters
- Constructor becomes too long
- Object should be immutable
- Object creation requires validation
- Step-by-step construction needed

## When not to use 🚫

- Object has only 2–3 fields
- No optional parameters
- Object creation is simple

## Real World Example

- HttpRequest
- User Profile Creation
- Building a Car

## Resources

🔗 https://algomaster.io/learn/lld/builder <br>
🔗 https://www.baeldung.com/java-builder-pattern <br>
🔗 https://codewitharyan.com/tech-blogs/builder-design-pattern <br>
🎥 https://www.youtube.com/watch?v=j-U1xJ_PaDs <br>
