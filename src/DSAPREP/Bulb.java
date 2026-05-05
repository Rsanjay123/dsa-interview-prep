package DSAPREP;

public class Bulb {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 1};
    System.out.println(turnBulbsOn(arr));
  }

  private static int turnBulbsOn(int[] arr) {
    int count = 0;
    for(int i = 0; i< arr.length; i++) {
      if (arr[i] == 0) {
        count++;
        for (int j = i; j < arr.length; j++) {
          arr[j] = arr[j] == 0 ? 1 : 0;
        }
      }
    }
    return count;
  }

  private static int turnBulbOnOptimises(int[] arr) {
    int count = 0;
    int flips = 0;
    for(int i = 0; i < arr.length; i++) {
      int current = (arr[i] + flips) % 2;
      if(current == 0) {
        flips++;
        count++;
      }

    }
    return count;
  }
}

