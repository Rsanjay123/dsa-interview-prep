package DSAPREP;

import java.util.PriorityQueue;

public class SumoPower {
  public static void main(String[] args) {
    int[] arr = {2, 7, 4, 1, 8, 1};
    System.out.println(sumoPower(arr));
  }

  public static int sumoPower(int[] arr) {
    PriorityQueue<Integer> sumoPower = new PriorityQueue<>((a, b) -> b - a);
    for(int power: arr) {
      sumoPower.offer(power);
    }

    while(sumoPower.size() > 1) {
      int val1 = sumoPower.poll();
      int val2 = sumoPower.poll();
      if(val1 != val2) {
        sumoPower.offer(val1 - val2);
      }
    }
    return sumoPower.isEmpty() ? 0 : sumoPower.poll();
  }
}
