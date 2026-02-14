package DSAPREP;
import java.util.*;
import java.util.stream.Stream;

/**
 * Problem: Longest Common Prefix
 * 
 * Problem Statement:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * This file contains two approaches:
 * 1. Horizontal scanning (compare prefix with each string)
 * 2. Functional/Stream approach (reduce operation)
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(strs));
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * Approach 1: Functional/Stream Approach (Reduce)
     * 
     * Algorithm:
     * 1. Use stream reduce to compare strings pairwise
     * 2. For each pair (s1, s2):
     *    - Find minimum length
     *    - Compare characters from start until mismatch
     *    - Return common prefix substring
     * 3. The reduce operation accumulates the common prefix across all strings
     * 
     * How reduce works:
     * - Start with first string as accumulator
     * - For each next string, find common prefix between accumulator and current string
     * - Update accumulator to be the common prefix
     * - Final accumulator is the longest common prefix
     * 
     * Example:
     * strs = ["flower","flow","flight"]
     * Step 1: compare "flower" and "flow" -> "flow"
     * Step 2: compare "flow" and "flight" -> "fl"
     * Result: "fl"
     * 
     * Time Complexity: O(S) where S is sum of all characters in all strings
     * Space Complexity: O(1) excluding the result string
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        
        // Use reduce to find common prefix across all strings
        return Arrays.stream(strs).reduce((s1, s2) -> {
            // Find minimum length to avoid index out of bounds
            int min = Math.min(s1.length(), s2.length());
            int i = 0;
            
            // Compare characters from start until mismatch
            while(i < min && s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            
            // Return common prefix substring
            return s1.substring(0, i);
        }).orElse(""); // Return empty string if no common prefix
    }

    /**
     * Approach 2: Horizontal Scanning
     * 
     * Algorithm:
     * 1. Start with first string as the prefix
     * 2. For each subsequent string:
     *    - Check if current prefix is a prefix of the string
     *    - If not, shorten prefix by removing last character
     *    - Repeat until prefix matches or becomes empty
     * 3. Return the final prefix
     * 
     * How it works:
     * - Start with prefix = strs[0] = "flower"
     * - Check if "flower" is prefix of "flow": No, shorten to "flowe", then "flow" ✓
     * - Check if "flow" is prefix of "flight": No, shorten to "flo", then "fl" ✓
     * - Result: "fl"
     * 
     * Why indexOf(prefix) != 0?
     * - indexOf returns the index where substring is found
     * - For a prefix, it should be at index 0
     * - If not at 0, it's not a prefix
     * 
     * Time Complexity: O(S) where S is sum of all characters
     * Space Complexity: O(1) excluding the result string
     * 
     * Advantage: More intuitive and easier to understand
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        
        // Start with first string as prefix
        String prefix = strs[0];
        
        // Compare prefix with each subsequent string
        for(int i = 1; i < strs.length; i++) {
            // While current prefix is not a prefix of strs[i]
            // indexOf returns 0 if prefix is at the start, -1 if not found
            while(strs[i].indexOf(prefix) != 0) {
                // Shorten prefix by removing last character
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, no common prefix exists
                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
