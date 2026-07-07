package DSAPREP.ConcurrencyAndMultithreading;

public class DeadLockExample {
  private static String lock1 = "LOCK1";
  private static String lock2 = "LOCK2";

  public static void main(String[] args) throws InterruptedException{
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock1) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException();
          }
          System.out.println("Thread 1: Holding lock1...");
          synchronized (lock2) {
            System.out.println("Thread 1: Holding lock1 and lock2...");
          }
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock2) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException();
          }
          System.out.println("Thread 2: Holding lock2...");
          synchronized (lock1) {
            System.out.println("Thread 2: Holding lock1 and lock2...");
          }
        }
      }
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Lock is Released");
  }
}
