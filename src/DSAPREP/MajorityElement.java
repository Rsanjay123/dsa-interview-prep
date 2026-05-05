package DSAPREP;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
  public static void main(String[] args) {
    int[] arr = {2, 2, 1, 1, 1, 1, 1};
    System.out.println(majorityElement(arr));
  }

  private static int majorityElement(int[] arr) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if(map.get(num) > n/2) {
        return num;
      }
    }
    return -1;
  }
}
