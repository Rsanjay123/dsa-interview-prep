package DSAPREP;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SecondHighestDigitInAString {
  public static void main(String[] args) {
    String s = "dfa12321afd";
    System.out.println(secondHighest(s));
  }

  public static int secondHighest(String s) {
    char[] arr = s.toCharArray();
    Set<Integer> set = new TreeSet<>();
    for(int i = 0; i < arr.length; i++) {
      if(Character.isDigit(arr[i])) {
        String charValue = String.valueOf(arr[i]);
        int value = Integer.valueOf(charValue);
        set.add(value);
      }
    }
    return set.size() < 2 ? -1 : set.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
  }
}
