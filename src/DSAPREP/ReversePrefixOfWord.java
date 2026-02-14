package DSAPREP;
import java.util.*;

/**
 * Problem: Reverse Prefix of Word
 * 
 * Problem Statement:
 * Given a 0-indexed string word and a character ch, reverse the segment of word 
 * that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). 
 * If the character ch does not exist in word, do nothing.
 * 
 * Example:
 * Input: word = "abcdefd", ch = "d"
 * Output: "dcbaefd"
 * Explanation: The first occurrence of "d" is at index 3. 
 *              Reverse the part of word from 0 to 3 (inclusive), 
 *              the resulting string is "dcbaefd".
 * 
 * Approach:
 * Find first occurrence of ch, reverse prefix up to that index, append suffix.
 * 
 * Algorithm:
 * 1. Find index of first occurrence of ch
 * 2. If not found, return original string
 * 3. Split string into prefix (0 to index) and suffix (index+1 to end)
 * 4. Reverse prefix and concatenate with suffix
 * 
 * Example walkthrough:
 * word = "abcdefd", ch = 'd'
 * index = 3 (first 'd' at position 3)
 * prefix = "abcd" (indices 0-3)
 * suffix = "efd" (indices 4-6)
 * Reverse prefix: "dcba"
 * Result: "dcba" + "efd" = "dcbaefd" ✓
 * 
 * Time Complexity: O(n) where n is length of word
 * Space Complexity: O(n) for the strings and StringBuilder
 */
public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    /**
     * Reverses the prefix of word up to first occurrence of ch
     * 
     * @param words Input string
     * @param ch Character to find
     * @return String with prefix reversed, or original if ch not found
     */
    public static String reversePrefix(String words, char ch) {
        // Find first occurrence of ch
        int index = words.indexOf(ch);
        
        // If ch not found, return original string
        if(index == -1) {
            return words;
        }
        
        // Split into prefix (including ch) and suffix
        String prefix = words.substring(0, index + 1);
        String suffix = words.substring(index + 1);
        
        // Reverse prefix and concatenate with suffix
        StringBuilder sb = new StringBuilder(prefix);
        sb.reverse();
        sb.append(suffix);
        
        return sb.toString();
    }
}
