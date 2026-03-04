# Multithreading & Concurrency 🚀

## Table of Contents 📚

**1. Basics**

- [Introduction](#basics)
- [Program, Process & Thread](#program-process--thread)
- [Multitasking, Multithreading, Multiprocessing](#multitasking-multithreading--multiprocessing)
- [Time Slicing](#time-slicing)
- [Context Switching](#context-switching)

**2. Creating Thread in Java**

- [Multiple ways to create thread](#creating-thread-in-java)
  - [Extending Thread](#1-extending-thread-class)
  - [Implementing Runnable](#2-implementing-runnable-interface)
  - [Implementing Callable](#3-implementing-callable-interface-with-executorservice)
  - [Callable vs Runnable](#difference-between-runnable-and-callable)
- [Thread lifecycle]()

**3. Thread Methods**

- start(), run(), sleep(), join(), interrupt(), wait(), notify(), notifyAll(), yield()

**4. Race Condition**

- Shared resource example
- Counter increment example
- Why it happens

**5. Synchronization**

- synchronized method
- synchronized block
- Object-level lock
- Class-level lock

**6. Intrinsic Lock / Monitor Lock** <br>
**7. Stack vs Heap** <br>
**8. volatile Keyword** <br>

**9. Advanced Synchronization Tools**

- ReentrantLock
- ReadWriteLock
- Semaphore
- CyclicBarrier
- CountDownLatch

**10. Thread Pool**

- Introduction
- Problem with Creating Thread Manually
- ExecutorService - newFixedThreadPool, newCachedThreadPool, submit(), shutdown()
- ThreadPoolExecutor - corePoolSize, maxPoolSize, queue, rejection policy

**11. Futures & Async Programming**

- Future - get(), blocking problem
- CompletableFuture (Important) - supplyAsync(), thenApply(), thenCombine(), exception handling

👉 For **SD1**: basic chaining understanding is enough.

**12. Concurrent Collection**

- ConcurrentHashMap
- BlockingQueue
  - ArrayBlockingQueue
  - LinkedBlockingQueue
-
- CopyOnWriteArrayList

**13. Classic Interview Problems**

- Thread-Safe Counter (Fix Race Condition)

- Producer–Consumer (Bounded Blocking Queue) <br>
  🔗 https://leetcode.com/problems/bounded-blocking-queue/

- Print in Order <br>
  🔗 https://leetcode.com/problems/print-in-order/

- Print FooBar Alternately <br>
  🔗 https://leetcode.com/problems/print-foobar-alternately/

- Print Zero Even Odd <br>
  🔗 https://leetcode.com/problems/print-zero-even-odd/

- FizzBuzz Multithreaded <br>
  🔗 https://leetcode.com/problems/fizzbuzz-multithreaded/

- Dining Philosophers <br>
  🔗 https://leetcode.com/problems/the-dining-philosophers/

- Thread-Safe Singleton <br>
  🔗 https://leetcode.com/problems/the-dining-philosophers/

- Design a Basic Rate Limiter <br>
  🔗 https://leetcode.com/problems/design-a-basic-rate-limiter/

- Deadlock Example + Fix
  - Create a deadlock using two locks.
  - Fix it using: Lock ordering, tryLock(), Timeout mechanism

---

## Basics

### Introduction 🚀

Multithreading is a programming and operating system capability that allows multiple threads of execution to exist within a single process, sharing the same memory space and resources, while executing concurrently.

🧠 Why Multithreading Exists

A single-threaded program:

- Executes one task at a time
- Blocks when waiting (I/O, network, database)

Example:

1. Receive request
2. Call database
3. Wait 200ms
4. Send response

During that 200ms wait → **CPU is idle**.

This wastes resources, so we use multithreading and Multithreading solves this by:

> Allowing other tasks to execute while one thread is waiting.

---

### Program, Process & Thread

1️⃣ **Program**

A program is a passive set of instructions stored on secondary storage (disk) that becomes a process when executed.

👉 It's just a code, not running and never consume CPU. <br>
👉 It Stored on disk, Static in nature, It has no runtime state. <br>

**Example** - A Java class file stored on disk is a program.

2️⃣ **Process**

A process is an instance of a program in execution, with its own independent memory space and system resources managed by the operating system.

🧠 When you start/execute a program, the OS:

- Loads it into memory
- Allocates heap and stack
- Assigns a Process ID (PID)
- Creates a Process Control Block (PCB)

Now it is a **process**.

**Example** - When you open Chrome browser, it becomes a process.

3️⃣ **Thread**

A thread is the smallest unit of CPU execution within a process that shares the process's resources but maintains its own execution context.

❇️ **Note:** A process can have multiple threads.

Each thread:

- Executes instructions independently
- Shares heap memory with other threads in same process
- Has its own stack and registers

**Example** - When you open Chrome browser, it becomes a process. Inside Chrome, there are multiple threads for UI, network, tabs, etc.

🔷 **Difference between Process and Thread** ❓

![Process vs Thread](/resources/images/multithreading/process-vs-thread.png)

🔷 **Use Processes When**

- You need strong isolation between different parts of an application
- Running completely independent tasks
- Leveraging multiple CPU cores for separate computational tasks

🔷 **Use Threads When**

- You need to perform multiple tasks within the same application
- Tasks need to share common data quickly
- You want to improve responsiveness and performance of a single application

**Key Features of Thread** 🔑

- **Concurrent Execution**: Multiple threads can run simultaneously, allowing programs to perform multiple tasks at once. 🔄,
- **Resource Sharing**: Threads within the same process share memory and resources, making communication between threads efficient. 🤝
- **Lightweight**: Threads require fewer resources compared to creating multiple processes. 🪶

---

### Multitasking, Multithreading & Multiprocessing

1️⃣ **Multitasking**

Multitasking is the **operating system’s** ability to execute multiple tasks (processes) concurrently by rapidly **switching the CPU** between them.

🧠 When you run multiple applications(Like, Chrome, Spotify, VS Code) on your computer, the OS switches CPU time between them.

👉 On a single-core system:

- Only one runs at a time
- Switching happens very fast

❇️ **Note:** Multitasking usually refers to process-level concurrency.

2️⃣ **Multithreading**

Multithreading is the ability of a **process** to execute multiple threads concurrently within the same address space.

🧠 Instead of creating multiple processes, we create multiple threads inside one process.

This is:

- More memory-efficient
- Faster communication (shared memory)

❇️ **Note:** Since **memory** is **shared**, **Race conditions** can occur and **Synchronization** is required.

3️⃣ **Multiprocessing**

Multiprocessing is a computing technique in which two or more independent processes execute simultaneously using multiple CPU cores, each process having its own separate memory space managed by the operating system.

---

### Time Slicing ⏳

Time slicing is a CPU scheduling mechanism where the processor allocates a fixed time quantum to each runnable process or thread in a cyclic manner.

🧠 Concept - If 3 threads are ready:

**CPU** gives:

Thread A → 5ms <br>
Thread B → 5ms <br>
Thread C → 5ms <br>

Then repeats.

👉 This creates the illusion of parallelism.

### Context Switching 🔄

A context switch is the process of saving the execution state of a currently running thread or process and restoring the state of another to allow CPU sharing.

🧠 Concept - When CPU switches from: <br>

> Thread A → Thread B

It must:

- Save registers
- Save program counter
- Save stack pointer
- Load new thread’s state

👉 This overhead reduces performance.

## Creating Thread in Java

There are **three practical** ways to define concurrent tasks in Java:

1. Extending Thread Class
2. Implementing Runnable Interface
3. Implementing Callable Interface (with ExecutorService)

But before that — one important **mental model** 🧠:

👉 A Thread is a worker. <br>
👉 A Runnable/Callable is the work. <br>
👉 ExecutorService is the manager. <br>

Modern Java prefers separating **task from thread**.

### 1. Extending Thread Class

```java
class MyThread extends Thread {
  public void run() {
    System.out.println("Thread is running");
  }
}

public class Main {
  public static void main(String[] args) {
    MyThread t1 = new MyThread();
    t1.start();
  }
}
```

**Explanation** 🧠

1. **MyThread extends Thread** - We inherit from Thread class.
2. **run()** - This is where the thread logic goes.
3. **start()** - Creates a new thread and calls run() inside it.

**Why this is not recommended?** ❌

- Java doesn't support multiple inheritance.
- If your class already extends something, you can't extend Thread.

**Important: `start()` vs `run()`** ⚠️

- **`t1.run()`**: Does **not** create a new thread. It executes the method in the current thread (e.g., `main`) like a standard method call. It can be called multiple times.

- **`t1.start()`**: Creates a **new thread** and then executes the `run()` method within that new context.

- **Single Use**: A thread object can only be started **once**. Calling `start()` a second time will throw `IllegalThreadStateException`.

📝 **Note** - We mostly never use this approach in production, Mostly educational purpose.

### 2. Implementing Runnable Interface

```java
class MyRunnable implements Runnable {
  public void run() {
    System.out.println("Thread is running");
  }
}

public class Main {
  public static void main(String[] args) {
    // Step 1: Create a Runnable object
    MyRunnable r1 = new MyRunnable();

    // Step 2: Create a Thread object and pass our Runnable to it.
    Thread t1 = new Thread(r1);

    // Step 3: Starts the thread.
    t1.start();
  }
}
```

**Create Thread using Runnable - State Diagram** 📊

![State Diagram](/resources/images/multithreading/create-thread-using-runnable-state-diagram.png)

**Explanation** 🧠

1. **MyRunnable implements Runnable** - We implement the Runnable interface.
2. **run()** - Same as before.
3. **new Thread(r1)** - We create a Thread object and pass our Runnable to it.
4. **start()** - Starts the thread.

**Why this is better?** ✅

- No multiple inheritance issue.
- Cleaner separation of concerns.

**Limitation of Runnable** ❌

- Cannot **return a value**.
- Cannot throw **checked exceptions**.

### 3. Implementing Callable Interface (with ExecutorService)

```java
import java.util.concurrent.*;

class MyCallable implements Callable<String> {
  public String call() throws Exception {
    return "Thread is running";
  }
}

public class Main {
  public static void main(String[] args) {
    // Create a thread pool with a single thread.
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // Create the instance of Callable.
    MyCallable c1 = new MyCallable();
    // Sumbit the task and store the result in Future object.
    Future<String> future = executor.submit(c1);
    // Get the result from Future object.
    String result = future.get();
    System.out.println(result);
    // Shutdown the executor.
    executor.shutdown();
  }
}
```

**Explanation** 🧠

1. **MyCallable implements Callable<String>** - We implement Callable interface.
2. **call()** - Returns a value (String in this case).
3. **ExecutorService** - Manages the thread pool.
4. **Future** - Holds the result.

**Why this is the best?** ✅

- Returns a value.
- Can throw checked exceptions.
- Better resource management.

### Difference between Runnable and Callable

![Thread vs Runnable vs Callable](/resources/images/multithreading/thread-vs-runnable-vs-callable.png)

### Thread Lifecycle

There are **5 states** in the **life cycle of a thread**. A thread passes through these five states throughout its lifetime.

👉 In Java, the life cycle of a thread is controlled by **JVM**.

![Thread Lifecycle](/resources/images/multithreading/thread-lifecycle.png)

Whenever we create a thread in Java, it goes through different states in its life cycle. <br>
Java provides a **Thread.State enum** for this, which contains the main states.

1️⃣ <u>**New**</u>

👉 When we create an object of Thread class, but the `start()` method is not called, then the thread is in **New** state. <br>
👉 In this state thread exists only as object.

Example:

```java
Thread t = new Thread(); // New state
```

2️⃣ <u>**Runnable**</u>

👉 When we call the `start()` method, the thread goes into **Runnable** state. <br>
👉 It means that the thread is ready to be executed by the **CPU**, but the scheduler cannot give it CPU yet. <br>
👉 Here thread stays in **ready queue**.

Example:

```java
t.start(); // Runnable state
```

3️⃣ <u>**Running**</u>

👉 When the **CPU scheduler** selects a thread and gives it **CPU**, then the thread is in the **Running** state. <br>
👉 At this time the thread executes its `run()` method. <br>
👉 Note: Only one thread can be running at a time, all others remain in runnable state.

🛑 **Note**

- In official **JVM states**, there is **NO separate RUNNING** state.
- **Running** is a subset of **RUNNABLE**.

✴️ **Important:**

In diagram, `Running ---> yield() ---> Runnable` <br>
Means, `Thread.yield()` hints scheduler: “I am willing to pause; let others run.” But, It's not guaranteed ⚠️

4️⃣ <u>**Waiting / Blocked / Timed Waiting State**</u>

Sometimes the thread has to wait for some time or needs some resource, then it goes into waiting state or blocked state.

- **a. Waiting State** 🫸
  - When a thread waits for a signal from another thread (like the `wait()` method), it enters the waiting state.
  - From this stage, the thread is not exited until the second thread `notify() or notifyAll()` is done to it.

- **b. Timed Waiting State** 🥱
  - When we tell a thread to wait for some time (like `sleep(1000)`, `join(500)`, `wait(2000)`), then it goes into Timed waiting state.
  - When the specified time is completed, the thread returns to its runnable state.

- **c. Blocked State** 🛌
  - When a thread wants a resource that is already being used by another thread, it goes into the blocked state.
  - Eg: Waiting for resource lock in synchronized block.

5️⃣ <u>**Terminated**</u>

👉 When a thread completes its task or its execution ends, it goes into dead state. <br>
👉 Once a thread is dead, it cannot be restarted. <br>
👉 If we call `start()` on dead thread then `IllegalThreadStateException` is thrown. <br>
