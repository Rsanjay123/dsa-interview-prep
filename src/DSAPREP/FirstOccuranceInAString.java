package DSAPREP;
import java.util.*;

/**
 * Problem: Find the Index of the First Occurrence in a String
 * 
 * Problem Statement:
 * Given two strings needle and haystack, return the index of the first occurrence 
 * of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Explanation: "ll" is found at index 2 in "hello".
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Explanation: "bba" is not found in "aaaaa".
 * 
 * Approach:
 * Brute force string matching - check each position in haystack as potential start.
 * 
 * Algorithm:
 * 1. If needle is empty, return 0
 * 2. For each position i in haystack where needle could start (0 to n-m):
 *    - Check if substring starting at i matches needle
 *    - Compare characters one by one
 *    - If all match, return i
 * 3. If no match found, return -1
 * 
 * Optimization note:
 * - This is O(n*m) brute force approach
 * - For better performance, use KMP algorithm (O(n+m))
 * 
 * Example walkthrough:
 * haystack = "hello", needle = "ll"
 * i=0: compare "he" with "ll" -> no match
 * i=1: compare "el" with "ll" -> no match
 * i=2: compare "ll" with "ll" -> match! Return 2 ✓
 * 
 * Time Complexity: O(n*m) where n=haystack.length(), m=needle.length()
 * Space Complexity: O(1) - only using constant extra space
 */
public class FirstOccuranceInAString {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * Finds the first occurrence of needle in haystack
     * 
     * @param haystack String to search in
     * @param needle String to search for
     * @return Index of first occurrence, or -1 if not found
     */
    public static int strStr(String haystack, String needle) {
        // Edge case: empty needle
        if(needle.isEmpty()) {
            return 0;
        }
        
        int n = haystack.length();
        int m = needle.length();
        
        // Check each position where needle could start
        // We only need to check up to n-m because after that, needle won't fit
        for(int i = 0; i <= n - m; i++) {
            int j = 0;
            
            // Compare characters starting from position i
            while(j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            // If we matched all characters in needle, found it!
            if(j == m) {
                return i;
            }
        }
        
        // Needle not found
        return -1;
    }
}
