/**
 * Demonstrates thread creation using the {@link Runnable} interface.
 * Implementing {@link Runnable} is generally preferred over extending
 * the {@link Thread} class because it separates the task logic from
 * the thread lifecycle, supports multiple inheritance, and is compatible
 * with modern functional programming patterns.
 */
public class RunnableExample implements Runnable {

  @Override
  public void run() {
    // Logic executed in the child thread
    for (int i = 0; i < 5; i++) {
      String currentThreadName = Thread.currentThread().getName();
      System.out.println("Thread " + currentThreadName + " is running..");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) {
    // Create the instance of Runnable
    RunnableExample runnable = new RunnableExample();

    // 2. Wrap the runnable in a Thread object.
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);

    // Creating Thread Using Lambda
    Thread t3 = new Thread(() -> {
      System.out.println("Thread Created using Lambda");
    });

    // 3. Start the thread
    t1.start();
    t2.start();
  }
}