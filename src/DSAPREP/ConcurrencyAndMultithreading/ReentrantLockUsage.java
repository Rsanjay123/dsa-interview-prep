package DSAPREP.ConcurrencyAndMultithreading;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUsage {
  public static int count = 0;
  public static final ReentrantLock lock = new ReentrantLock();

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

  public static void incrementCount() {
    lock.lock();
    try {
      count++;
    } finally {
      lock.unlock();
    }
  }

//  public static void main(String[] args) throws InterruptedException{
//    Thread t1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        for (int i = 0; i < 2000; i++) {
//          incrementCount();
//        }
//      }
//    });
//    Thread t2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        for(int i = 0; i < 2000; i++) {
//          incrementCount();
//        }
//      }
//    });
//    t1.start();
//    t2.start();
//    t1.join();
//    t2.join();
//    System.out.println("Final Count : " + count);
//  }
}
