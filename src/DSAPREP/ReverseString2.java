package DSAPREP;

import java.util.Stack;

public class ReverseString2 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String n = "abc";
        System.out.println(reverseString3(n));
        System.out.println(reverseString2(n));
        System.out.println(reverseString(s, k));
    }

  private static String reverseString(String s, int k) {
      if(s.isEmpty() || s.length() == 1) {
        return s;
      }
      char[] arr = s.toCharArray();
      for(int i = 0; i < arr.length; i += 2 * k) {
        int left = i;
        int right = Math.min(i + (k - 1), arr.length - 1);
        while(left < right) {
          char temp = arr[left];
          arr[left] = arr[right];
          arr[right] = temp;
          left++;
          right--;
        }
      }
      return new String(arr);
  }

  private static String reverseString2(String s) {
      char[] words = s.toCharArray();
      StringBuilder result = new StringBuilder();
      for(int i = words.length - 1; i >= 0; i--) {
        result.append(words[i]);
      }
      return result.toString();
  }

  private static String reverseString3(String s) {
      char[] words = s.toCharArray();
      Stack<Character> stack = new Stack<>();
      for(int i = 0; i < words.length; i++) {
        stack.push(words[i]);
      }
      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      return sb.toString();
  }
}
