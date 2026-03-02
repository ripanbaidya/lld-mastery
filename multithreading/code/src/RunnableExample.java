/**
 * Demonstrates thread creation using the {@link Runnable} interface.
 * Implementing {@link Runnable} is generally preferred over extending
 * the {@link Thread} class because it separates the task logic from
 * the thread lifecycle, supports multiple inheritance, and is compatible
 * with modern functional programming patterns.
 */
public class RunnableExample implements Runnable {

  /**
   * Defines the task to be executed by the thread.
   * This is the entry point for the thread's execution.
   */
  @Override
  public void run() {
    System.out.println("Thread is running.");
  }

  public static void main(String[] args) {
    System.out.println("*------- Thread: Runnable interface -------*");

    // 1. Instantiate the task logic.
    RunnableExample task = new RunnableExample();

    // 2. Wrap the task in a Thread object.
    // The Thread class acts as the execution manager for the provided Runnable.
    Thread thread = new Thread(task);

    // 3. Initiate the thread.
    // This causes the JVM to call the run() method in a separate call stack.
    thread.start();
  }
}