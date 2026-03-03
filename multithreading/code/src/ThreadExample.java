/**
 * Demonstrates thread creation by extending the {@code Thread} class.
 * Note: While simple, this approach ties the task logic directly to the
 * Thread object, making it less flexible than implementing Runnable for
 * sharing resources or extending other classes.
 */
public class ThreadExample extends Thread {

  /**
   * The entry point for the thread's execution.
   * Overriding this method defines the specific work this thread will perform
   * once it is moved to the 'Running' state by the scheduler.
   */
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      String currentThreadName = Thread.currentThread().getName();
      System.out.println("Thread " + currentThreadName + " is running..");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) {
    // 1. Create thread instance
    ThreadExample t1 = new ThreadExample();
    ThreadExample t2 = new ThreadExample();

    /*
     * Calling run() directly results in sequential execution within the invoking thread,
     * without creating a new call stack or execution context.
     * We can call t1.run() any number of times bcz this would be normal method call.
     */
    // t1.run();

    /*
     * start() is a JVM-level thread creation mechanism that causes the run() method to
     * execute in a new concurrent execution context.
     * We can make the call only once, otherwise IllegalThreadStateException will occur
     */
    t1.start();
    // t1.start(); // java.lang.IllegalThreadStateException

    t2.start();
  }
}