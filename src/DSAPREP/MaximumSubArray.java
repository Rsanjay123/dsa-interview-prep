package DSAPREP;

import java.util.ArrayList;

public class MaximumSubArray {
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int[] arr1 = {1, 2, 5, -7, 2, 3};
    System.out.println(maxNonNegativeSubArray(arr1));
    System.out.println(maxSubArray(arr));
  }

  private static int maxSubArray(int[] arr) {
    int sum = 0;
    int val = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i];
      val = Math.max(val,sum);
      if(sum < 0) {
        sum = 0;
      }
    }
    return val;
  }

  private static ArrayList<Integer> maxNonNegativeSubArray(int[] arr) {
    int sum = 0;
    int val = Integer.MIN_VALUE;
    ArrayList<Integer> result = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] >= 0) {
        sum += arr[i];
        temp.add(arr[i]);
      } else {
        if(sum > val) {
          val = sum;
          result.clear();
          result.addAll(temp);
        }
        sum = 0;
        temp.clear();
      }
    }
    if(sum > val) {
      result.clear();
      result.addAll(temp);
    }
    return result;
  }
}
