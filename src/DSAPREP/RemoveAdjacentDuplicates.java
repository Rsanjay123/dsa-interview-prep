package DSAPREP;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
  public static void main(String[] args) {
    String s = "abbade";
    System.out.println(removeDuplicates(s));
  }

  private static String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();
    char[] arr = s.toCharArray();
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < arr.length; i++) {
      if(!stack.isEmpty() && stack.peek().equals(arr[i])) {
        stack.pop();
        continue;
      }
      stack.push(arr[i]);
    }
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    return result.toString();
  }
}
