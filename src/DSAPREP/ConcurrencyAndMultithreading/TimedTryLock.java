package DSAPREP.ConcurrencyAndMultithreading;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimedTryLock {
  private static int count = 0;
  private static final ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) throws InterruptedException{
    Runnable task = () -> {
      for(int i = 0; i < 2000; i++) {
        try {
          incrementCount();
        } catch (InterruptedException e) {
          throw new RuntimeException();
        }
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

  private static void incrementCount() throws InterruptedException{
    if(lock.tryLock(5, TimeUnit.SECONDS)) {
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
