package DSAPREP.ConcurrencyAndMultithreading;

public class SynchronisedUsage {
  public static void main(String[] args) {
    int[] arr = {10, 31, 46, 38, 53, 57, 78, 76, 90};
    int count = 0;
    System.out.println(finalCount(arr, count));
  }

  synchronized public static int finalCount(int[] arr, int count) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] % 2 == 0) {
        count++;
      }
    }
    return count;
  }
}
