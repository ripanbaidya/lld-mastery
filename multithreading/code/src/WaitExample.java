class WaitExample {
  private static final Object lock = new Object();

  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      synchronized (lock) {
        System.out.println("Thread 1 waiting...");
        try {
          lock.wait();  // releases lock
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        System.out.println("Thread 1 resumed");
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (lock) {
        System.out.println("Thread 2 notifying...");
        lock.notify();
      }
    });

    t1.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    t2.start();
  }
}