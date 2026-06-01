package DSAPREP.ConcurrencyAndMultithreading;

public class SynchronisedUsage {
  public static void main(String[] args) {
    int[] arr = {10, 5, 40, 24, 27, 17, 8, 15, 12, 6};
    int count = 0;
    int result = calculateCount(count, arr);
    System.out.println(result);
  }

  synchronized public static int calculateCount(int count, int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] % 2 == 0) {
          count++;
      }
    }
    return count;
  }
}
