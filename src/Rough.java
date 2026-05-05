import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rough {
  public static void main(String[] args) {
    System.out.println(reverseInteger(123));
    System.out.println(plusOne(new ArrayList<>(List.of(9, 9, 9))));
    System.out.println(findSuperstarDishes(List.of(2L, 2L, 1L, 1L, 1L, 2L), 6));
  }
  public int removeDuplicates(ArrayList<Integer> a) {
    a.clear();
    a.addAll(a.stream().distinct().collect(Collectors.toList()));
    return a.size();
  }

  public static int reverseInteger(int x) {
    boolean negative = x < 0;
    String intValue = Integer.toString(Math.abs(x));
    String revValue = new StringBuilder(intValue).reverse().toString();
    try {
      int reversedInteger = Integer.valueOf(revValue);
      reversedInteger = negative ? -reversedInteger : reversedInteger;
      return reversedInteger;
    } catch(NumberFormatException e) {
      return 0;
    }
  }

  public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    String numStr = A.stream().map(String::valueOf).collect(Collectors.joining());
    String plusOnestr = String.valueOf(Long.parseLong(numStr) + 1);

    ArrayList<Integer> result = new ArrayList<>();
    for(char c: plusOnestr.toCharArray()){
      result.add(Character.getNumericValue(c));
    }
    return result;
  }

  public static List<Long> findSuperstarDishes(List<Long> a, int n) {
    // write your code here
    List<Long> result = new ArrayList<>();
    long[] arr = a.stream().mapToLong(Long::longValue).toArray();
    Map<Long, Long> map = new HashMap<>();
    for(int i = 0; i< arr.length; i++) {
      if(!map.containsKey(arr[i])) {
        map.put(arr[i], 1L);
      } else {
        map.replace(arr[i], map.get(arr[i]) + 1L);
      }
    }
    for(Map.Entry<Long, Long> entry:map.entrySet()) {
      if(entry.getValue() > n/3) {
        result.add(entry.getKey());
      }
    }
    return result;
  }
}
