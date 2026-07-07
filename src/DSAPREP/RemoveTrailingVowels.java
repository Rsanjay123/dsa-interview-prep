package DSAPREP;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RemoveTrailingVowels {
  public static void main(String[] args) {
    String s = "hellooo";
    System.out.println(removeTrailingVowels(s));
  }

  public static String removeTrailingVowels(String s) {
    StringBuilder sb = new StringBuilder();
    char[] arr = s.toCharArray();
    int i = arr.length - 1;
    while(i >= 0 && isVowel(arr[i])) {
      i--;
    }
    for(int j = 0; j < i; j++) {
      sb.append(arr[j]);
    }
    return sb.toString();
  }

  private static boolean isVowel(char s) {
    String vowels = "aeiou";
    char[] arr = vowels.toCharArray();
    Set<Character> set = new HashSet<>();
    for(char c : arr) {
      set.add(c);
    }
    if(set.contains(s)) {
      return true;
    }
    return false;
  }
}
