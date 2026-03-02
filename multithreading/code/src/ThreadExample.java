/**
 * Demonstrates thread creation by extending the {@code Thread} class.
 * * Note: While simple, this approach ties the task logic directly to the
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
    // Logic executed in the child thread
    System.out.println("Child thread is executing logic...");
  }

  public static void main(String[] args) {
    System.out.println("*------- Thread: Thread class -------*");
    
    // 1. Instantiate the custom thread.
    // At this point, the thread is in the 'New' state.
    ThreadExample t1 = new ThreadExample();

    /* 2. Transition the thread to the 'Runnable' state.
     * The JVM's Thread Scheduler will decide when to actually execute the run() method.
     * WARNING: Never call t1.run() directly; that would just run the code
     * synchronously in the main thread!
     */
    t1.start();

    // 3. Identify the execution context of the main method
    System.out.println("Main method running in: " + Thread.currentThread().getName());
  }
}