package DSAPREP.ConcurrencyAndMultithreading;
import java.util.*;
import java.util.concurrent.*;

public class ExecutorServiceExample {
  public static void main(String[] args) throws InterruptedException, ExecutionException{
    ExecutorService executors = Executors.newFixedThreadPool(5);
    try {
      List<Future<Integer>> futures = new ArrayList<>();
      for (int i = 0; i <= 10; i++) {
        final int n = i;
        Future<Integer> f = executors.submit(() -> squares(n));
        futures.add(f);
      }
      int total = 0;
      for (Future<Integer> num: futures) {
        total += num.get();
      }
      System.out.println("The sum of all squares : " + total);
    } finally {
      shutDownGracefully(executors);
    }
  }

  synchronized private static int squares(int n) throws InterruptedException{
    Thread.sleep(100);
    return n * n;
  }

  private static void shutDownGracefully(ExecutorService executors) throws InterruptedException {
    executors.shutdown();
    if(!executors.awaitTermination(3, TimeUnit.SECONDS)) {
      executors.shutdownNow();
      if(!executors.awaitTermination(3, TimeUnit.SECONDS)) {
        System.out.println("Shutdown failed");
      }
    }
  }
}
