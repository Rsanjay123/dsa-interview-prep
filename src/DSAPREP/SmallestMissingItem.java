package DSAPREP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SmallestMissingItem {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }
    int m = scan.nextInt();
    int[] arr2 = new int[m];
    for(int i = 0; i < m; i++) {
      arr2[i] = scan.nextInt();
    }

    Set<Integer> set = new HashSet<>();
    for(int item: arr2) {
      set.add(item);
    }
    for(int item: arr) {
      if(!set.contains(item)) {
        System.out.println(item);
        return;
      }
    }
    System.out.println("All items received");
  }
}
