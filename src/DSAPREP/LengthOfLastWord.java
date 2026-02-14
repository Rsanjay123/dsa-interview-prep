package DSAPREP;
import java.util.*;

/**
 * Problem: Length of Last Word
 * 
 * Problem Statement:
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Example:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * Approach:
 * Trim the string and split by spaces, then return length of last word.
 * 
 * Algorithm:
 * 1. Trim leading and trailing spaces
 * 2. Split by spaces (one or more)
 * 3. Return length of last element in array
 * 
 * Why trim()?
 * - Removes leading/trailing spaces that could cause issues
 * 
 * Why split(" ")?
 * - Splits by single space, but multiple spaces create empty strings
 * - Better: split("\\s+") to handle multiple spaces
 * 
 * Example walkthrough:
 * s = "Hello World"
 * After trim: "Hello World"
 * After split: ["Hello", "World"]
 * Last word: "World", length = 5 ✓
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(n) for the words array
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    /**
     * Finds the length of the last word in a string
     * 
     * @param s Input string with words and spaces
     * @return Length of the last word
     */
    public static int lengthOfLastWord(String s) {
        // Remove leading and trailing spaces
        s = s.trim();
        
        // Split by spaces
        // Note: split(" ") creates empty strings for multiple spaces
        // Better approach: split("\\s+") to handle multiple spaces correctly
        String[] words = s.split(" ");
        
        // Get the last word
        int n = words.length - 1;
        return words[n].length();
    }
}
