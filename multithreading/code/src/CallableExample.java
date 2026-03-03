import java.util.concurrent.*;

public class CallableExample implements Callable<String> {
  private final String name;

  public CallableExample(String name) {
    this.name = name;
  }

  /**
   * Overrides the call method from the Callable interface
   */
  @Override
  public String call() throws Exception {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 5; i++) {
      sb.append("Callable").append(name).append("is running")
          .append(" - ").append(i).append("\n");
      Thread.sleep(500);
    }
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    // Create ExecutorService with a fixed thread pool
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    // Create Callable instance
    Callable<String> callable = new CallableExample("Task1");
    Callable<String> callable2 = new CallableExample("Task1");

    try {
      // Submit callable task to the executor service and get Future Object
      Future<String> future = executorService.submit(callable);
      Future<String> future2 = executorService.submit(callable2);

      // Get result from Future object
      System.out.println("Result from first task: ");
      System.out.println(future.get());

      System.out.println("Result from second task: ");
      System.out.println(future2.get());

    } catch (InterruptedException | ExecutionException e) {
      Thread.currentThread().interrupt();
    } finally {
      executorService.shutdown();
    }
  }
}