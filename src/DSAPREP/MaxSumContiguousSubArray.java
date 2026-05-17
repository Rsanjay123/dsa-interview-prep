package DSAPREP;

public class MaxSumContiguousSubArray {
  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(arr));
  }

  private static int maxSubArray(int[] arr) {
    int sum = 0;
    int val = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i];
      val = Math.max(sum, val);
      if(sum < 0) {
        sum = 0;
      }
    }
    return val;
  }

}
