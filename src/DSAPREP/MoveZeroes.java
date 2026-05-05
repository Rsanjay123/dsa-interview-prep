package DSAPREP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveZeroes {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(List.of(0, 1, 0, 3, 12));
    ArrayList<Integer> result = moveZeroes(list);
    ArrayList<Integer> result2 = moveZerosByList(list);
    System.out.println(result);
    System.out.println(result2);
  }

  private static ArrayList<Integer> moveZeroes(ArrayList<Integer> list) {
    int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
    int p = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[p] = arr[i];
        p++;
      }
    }
    while (p < arr.length) {
      arr[p] = 0;
      p++;
    }
    return Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  private static ArrayList<Integer> moveZerosByList(ArrayList<Integer> list) {
    int p = 0;
    for(int i = 0; i < list.size(); i++) {
      if(list.get(i) != 0) {
        list.set(p, list.get(i));
        p++;
      }
    }
    while(p < list.size()){
      list.set(p, 0);
      p++;
    }
    return list;
  }
}
