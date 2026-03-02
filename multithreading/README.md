# Multithreading & Concurrency 🚀

## Table of Contents 📚

**1. Basics**

- Introduction
- Program, Process & Thread
- Multitasking, Multithreading, Multiprocessing
- Time Slicing
- Context Switching

**2. Creating Thread in Java**

- Extending Thread
- Implementing Runnable
- Callable vs Runnable
- Thread lifecycle (NEW → RUNNABLE → BLOCKED → WAITING → TIMED_WAITING → TERMINATED)

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

### Program

A program is a passive set of instructions stored on secondary storage (disk) that becomes a process when executed.

👉 It's just a code, not running and never consume CPU. <br>
👉 It Stored on disk, Static in nature, It has no runtime state. <br>

**Example** - A Java class file stored on disk is a program.

### Process

A process is an instance of a program in execution, with its own independent memory space and system resources managed by the operating system.

🧠 When you start/execute a program, the OS:

- Loads it into memory
- Allocates heap and stack
- Assigns a Process ID (PID)
- Creates a Process Control Block (PCB)

Now it is a **process**.

**Example** - When you open Chrome browser, it becomes a process.

### Thread

A thread is the smallest unit of CPU execution within a process that shares the process's resources but maintains its own execution context.

❇️ **Note:** A process can have multiple threads.

Each thread:

- Executes instructions independently
- Shares heap memory with other threads in same process
- Has its own stack and registers

**Example** - When you open Chrome browser, it becomes a process. Inside Chrome, there are multiple threads for UI, network, tabs, etc.

**Concept Map for Program, Process & Thread** 🔥

| Term    | What It Is                    | Memory      | Isolation | Lightweight |
| ------- | ----------------------------- | ----------- | --------- | ----------- |
| Program | Static code                   | Disk        | N/A       | N/A         |
| Process | Running program               | Separate    | Yes       | Heavy       |
| Thread  | Execution unit inside process | Shared heap | No        | Lightweight |

---

### Multitasking

Multitasking is the **operating system’s** ability to execute multiple tasks (processes) concurrently by rapidly **switching the CPU** between them.

🧠 When you run multiple applications(Like, Chrome, Spotify, VS Code) on your computer, the OS switches CPU time between them.

👉 On a single-core system:

- Only one runs at a time
- Switching happens very fast

❇️ **Note:** Multitasking usually refers to process-level concurrency.

### Multithreading

Multithreading is the ability of a **process** to execute multiple threads concurrently within the same address space.

🧠 Instead of creating multiple processes, we create multiple threads inside one process.

This is:

- More memory-efficient
- Faster communication (shared memory)

❇️ **Note:** Since **memory** is **shared**, **Race conditions** can occur and **Synchronization** is required.

### Multiprocessing

Multiprocessing is a computing technique in which two or more independent processes execute simultaneously using multiple CPU cores, each process having its own separate memory space managed by the operating system.

### Time Slicing

Time slicing is a CPU scheduling mechanism where the processor allocates a fixed time quantum to each runnable process or thread in a cyclic manner.

🧠 Concept - If 3 threads are ready:

**CPU** gives:

Thread A → 5ms <br>
Thread B → 5ms <br>
Thread C → 5ms <br>

Then repeats.

👉 This creates the illusion of parallelism.

### Context Switching

A context switch is the process of saving the execution state of a currently running thread or process and restoring the state of another to allow CPU sharing.

🧠 Concept - When CPU switches from: <br>

> Thread A → Thread B

It must:

- Save registers
- Save program counter
- Save stack pointer
- Load new thread’s state

👉 This overhead reduces performance.
