package DSAPREP;
import java.util.*;

/**
 * Problem: Reverse Words in a String
 * 
 * Problem Statement:
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be 
 * separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. 
 * The returned string should only have a single space separating the words. 
 * Do not include any extra spaces.
 * 
 * Example:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * 
 * This file contains two approaches:
 * 1. Manual reversal with StringBuilder
 * 2. Using Collections.reverse() and String.join()
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "  hello world  ";
        char[] s2 = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        reverseString(s2);
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }

  private static void reverseString(char[] s2) {
      int left = 0;
      int right = s2.length - 1;
      while(left < right) {
        char temp = s2[left];
        s2[left] = s2[right];
        s2[right] = temp;
        left++;
        right--;
      }
      System.out.println(Arrays.toString(s2));
  }

  /**
     * Approach 1: Manual Reversal with StringBuilder
     * 
     * Algorithm:
     * 1. Trim leading/trailing spaces
     * 2. Split by one or more whitespace characters (\\s+)
     * 3. Iterate from end to start, appending words
     * 4. Add single space between words (except after last word)
     * 
     * Why trim()?
     * - Removes leading and trailing spaces
     * 
     * Why "\\s+"?
     * - \\s matches any whitespace character (space, tab, newline)
     * - + means one or more occurrences
     * - This handles multiple spaces between words
     * 
     * Example:
     * s = "  hello world  "
     * After trim: "hello world"
     * After split: ["hello", "world"]
     * Reverse: "world hello"
     * 
     * Time Complexity: O(n) where n is length of string
     * Space Complexity: O(n) for the words array and StringBuilder
     * 
     * @param s Input string with words to reverse
     * @return String with words in reverse order
     */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
          sb.append(words[i]);
          if(i > 0) {
            sb.append(" ");
          }
        }
        return sb.toString();
    }

    /**
     * Approach 2: Using Collections.reverse() and String.join()
     * 
     * Algorithm:
     * 1. Trim and split string into words array
     * 2. Convert array to List (Arrays.asList creates a view)
     * 3. Reverse the list in-place
     * 4. Join words with single space
     * 
     * Note: Arrays.asList() returns a fixed-size list backed by the array.
     * Collections.reverse() modifies this list, which also modifies the original array.
     * 
     * Advantage: More concise code
     * 
     * Time Complexity: O(n) where n is length of string
     * Space Complexity: O(n) for the words array
     * 
     * @param s Input string with words to reverse
     * @return String with words in reverse order
     */
    public static String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
