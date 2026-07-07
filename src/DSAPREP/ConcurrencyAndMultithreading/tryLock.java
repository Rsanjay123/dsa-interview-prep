package DSAPREP.ConcurrencyAndMultithreading;

import java.util.concurrent.locks.ReentrantLock;

public class tryLock {
  private static int count = 0;
  private static final ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) throws InterruptedException{
    Runnable task = () -> {
      for(int i = 0; i < 2000; i++) {
        incrementCount();
      }
    };
    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Final Count : " + count);
  }

  private static void incrementCount() {
    if(lock.tryLock()) {
      try {
        count++;
      } finally {
        lock.unlock();
      }
    } else {
      System.out.println("Lock is Busy");
    }
  }
}
