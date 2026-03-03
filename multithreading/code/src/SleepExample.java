/**
 * sleep() makes the currently running thread sleep for the specified amount of time
 * without releasing locks
 * Thread.sleep() is a static method
 */
public class SleepExample {
  private static final Object lock = new Object();

  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      synchronized (lock) {
        System.out.println("Thread 1 acquires lock");
        try {
          // When thread-1 is sleeping its in : TIMED_WAITING state
          Thread.sleep(3000); // Thread 1 sleeps for 3 seconds
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        System.out.println("Thread 1 finished");
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (lock) {
        System.out.println("Thread 2 acquires lock");
        System.out.println("Thread 2 finished");
      }
    });

    t1.start();
    t2.start();
  }
}
