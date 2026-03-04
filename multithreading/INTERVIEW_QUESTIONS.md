# Interview Questions on Multithreading 🧬

### 1. What is the difference between start() and run() methods?

The **start()** method begins **thread execution** and calls the **run()** method, while the **run()** method simply contains the code to be executed. Directly calling **run()** won't create a new thread; it will execute in the current thread. 🔄

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}
public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();  // Starts a new thread

        MyThread t2 = new MyThread();
        t2.run();   // Runs in the main thread
    }
}
```

### 2. Can we call the start() method twice on the same Thread object?

**No**, calling **start()** twice on the same **Thread object** will throw an **IllegalThreadStateException**. A thread that has completed execution cannot be restarted. ⚠️

```java
public class Main extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        Main t = new Main();
        t.start(); // Works fine
        t.start(); // Throws IllegalThreadStateException
    }
}
```

### 3. What is thread safety and how can it be achieved?

**Thread safety** refers to code that functions correctly during simultaneous execution by **multiple threads**. It can be achieved through **synchronization**, **immutable objects**, **concurrent collections**, **atomic variables**, and **thread-local variables**.

### 4. What happens if an exception occurs in a thread's run method?

If an exception occurs in a thread’s **run()** method and it is **not caught**, the thread **terminates** and the JVM invokes the **UncaughtExceptionHandler**. Other threads continue executing normally. ❌

```java
class MyThread extends Thread {
    public void run() {
        try {
            int x = 10 / 0;   // ArithmeticException
        } catch (Exception e) {
            System.out.println("Exception handled inside thread");
        }

        System.out.println("Thread continues running");
    }
}
```

### 5. What is the difference between sleep() and wait() methods?

**sleep()** causes the current thread to pause for a specified time without releasing locks, while **wait()** causes the current thread to wait until another thread invokes **notify()** or **notifyAll()** on the same object, and it releases the lock on the object. 😴

**Difference** ♻️

| Feature                     | `sleep()`                     | `wait()`                             |
| --------------------------- | ----------------------------- | ------------------------------------ |
| Class                       | `Thread`                      | `Object`                             |
| Purpose                     | Pause thread for a fixed time | Coordinate between threads           |
| Lock release                | ❌ Does NOT release lock      | ✅ Releases lock                     |
| Requires synchronized block | ❌ No                         | ✅ Yes                               |
| Wake-up mechanism           | Time completion               | `notify()` / `notifyAll()` / timeout |
| Thread state                | `TIMED_WAITING`               | `WAITING` or `TIMED_WAITING`         |

**Sleep Example** 😴

```java
class Main {
    public static void main(String[] args) {
        System.out.println("Thread is going to sleep...");
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread woke up after sleeping.");
    }
}
```

**Output**

```
Thread is going to sleep...
(After 2 seconds of 😴)
Thread woke up after sleeping.
```

**Wait Example** 🫷

```java
class SharedResource {
  synchronized void waitExample() {
    System.out.println(Thread.currentThread().getName() + " is waiting...");
    try {
      wait(); // Releases the lock and waits
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println(Thread.currentThread().getName() + " resumed after notify.");
  }


  synchronized void notifyExample() {
    System.out.println("Notifying a waiting thread...");
    notify(); // Wakes up one waiting thread
  }
}


public class Main {
  public static void main(String[] args) {
    SharedResource shared = new SharedResource();
    // Thread 1 (Waits)
    Thread t1 = new Thread(shared::waitExample, "Thread-1");

    // Thread 2 (Notifies after 2 seconds)
    Thread t2 = new Thread(() -> {
      try {
        Thread.sleep(2000); // Ensure Thread-1 goes to wait state
        shared.notifyExample();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }, "Thread-2");


    t1.start();
    t2.start();
  }
}
```

**Output**

```
Thread-1 is waiting...
Notifying a waiting thread...
Thread-1 resumed after notify.
```

### 6. What is the Callable interface, and how does it differ from Runnable?

**Callable** is a functional interface introduced in **Java 5** as part of the concurrency utilities. The key differences from Runnable are:

- Callable's call() method can return a result (it's a parameterized type), while Runnable's run() method returns void
- Callable's call() method can throw checked exceptions, while Runnable's run() method cannot
- Callable works with Future objects to handle the results asynchronously
