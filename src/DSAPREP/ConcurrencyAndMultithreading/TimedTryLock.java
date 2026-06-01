package DSAPREP.ConcurrencyAndMultithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimedTryLock {
  private static int count = 0;
  private static final ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          try {
            incrementCount();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          try {
            incrementCount();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Final Count: " + count);
  }

  synchronized private static void incrementCount() throws InterruptedException {
    if(lock.tryLock(5, TimeUnit.SECONDS)) {
      try {
        count++;
      } finally {
        lock.unlock();
      }
    } else {
      System.out.println("lock is busy even after 5 seconds");
    }
  }
}
