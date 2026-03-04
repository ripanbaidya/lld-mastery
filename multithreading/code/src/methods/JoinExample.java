package methods;

/**
 * Thread.join()
 * join() is a method of the Thread class that makes the current thread wait until another
 * thread finishes execution.
 * In simple terms: Thread main calls t.join() → Thread main pauses until Thread t completes.
 *
 */
public class JoinExample extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Child thread: " + i);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    JoinExample thread = new JoinExample();

    thread.start();

    // Make the main thread wait until the Child thread completes it execution
    thread.join();
    // Internal process -
    // 1. Current thread checks if target thread is alive.
    // 2. If alive → current thread enters WAITING state
    // 3. When the target thread terminates, JVM wakes the waiting thread.

    System.out.println("Main thread finished.");
  }
}
