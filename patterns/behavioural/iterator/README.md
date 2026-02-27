# Iterator Pattern

<p align="right"><b>Last Update: 27.02.2026</b></p>

## Introduction 🔥

The Iterator Pattern provides a way to access elements of a collection sequentially without exposing its internal structure.

👉 It belongs to **Behavioral Design Patterns**.

## 🧠 Real-Life Analogy

Think about a TV remote.

- You press Next → go to next channel.
- You press Previous → go back.
- You don’t know how channels are stored internally.
- You don’t care whether it’s stored in array, list, database, etc.

✅ **Remote = Iterator** <br>
👉 **TV Channels = Collection**

## Components ⚙️

1. **Iterator (interface)**: Declares the operations required to traverse a collection. At minimum, this includes `hasNext()` to check if more elements exist, and `next()` to retrieve the next element.

2. **ConcreteIterator**: Implements the Iterator interface for a specific collection. It maintains the current position within the collection and knows how to move to the next element.

3. **IterableCollection (interface)**: Declares a method for creating an iterator. Any class implementing this interface promises it can be iterated.

4. **ConcreteCollection**: Implements the IterableCollection interface. It stores elements and returns an appropriate iterator when asked.

5. **Client**: Uses the iterator to traverse the collection without knowing its internal structure.

## UML

<img src="/resources/images/patterns/behavioural/iterator-uml.png" height="350" width="550" style="display: block; margin: 0 auto;">

## Resources

🔗 https://algomaster.io/learn/lld/iterator <br>
🔗 https://codewitharyan.com/tech-blogs/iterator-design-pattern <br>
🎥 https://youtu.be/UrxdNL94Xfc <br>
