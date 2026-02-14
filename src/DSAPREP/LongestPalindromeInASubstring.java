package DSAPREP;
import java.util.*;

/**
 * Problem: Longest Palindromic Substring
 * 
 * Problem Statement:
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example:
 * Input: s = "babad"
 * Output: "bab" or "aba" (both are valid)
 * 
 * Approach:
 * Expand around center - check both odd-length and even-length palindromes.
 * 
 * Algorithm:
 * 1. For each position i in string:
 *    - Expand around center (i, i) for odd-length palindromes
 *    - Expand around center (i, i+1) for even-length palindromes
 *    - Track the longest palindrome found
 * 2. Return the longest palindrome substring
 * 
 * Why two expansions?
 * - Odd-length palindromes: center is a single character (e.g., "aba")
 * - Even-length palindromes: center is between two characters (e.g., "abba")
 * 
 * How expandFromCentre works:
 * - Start with left and right pointers at or around center
 * - Expand outward while characters match
 * - Return length of palindrome found
 * 
 * Example walkthrough:
 * s = "babad"
 * i=0: expand(0,0) -> "b" (len=1), expand(0,1) -> "" (len=0), max="b"
 * i=1: expand(1,1) -> "aba" (len=3), expand(1,2) -> "" (len=0), max="aba"
 * i=2: expand(2,2) -> "a" (len=1), expand(2,3) -> "" (len=0)
 * ... continue
 * Result: "aba"
 * 
 * Time Complexity: O(n²) - for each position, expand takes O(n)
 * Space Complexity: O(1) - only using constant extra space
 */
public class LongestPalindromeInASubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    /**
     * Finds the longest palindromic substring
     * 
     * @param s Input string
     * @return Longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }
        
        int start = 0;  // Start index of longest palindrome
        int end = 0;    // End index of longest palindrome
        
        // Check each position as potential center
        for(int i = 0; i < s.length(); i++) {
            // Expand for odd-length palindrome (center at i)
            int len1 = expandFromCentre(s, i, i);
            
            // Expand for even-length palindrome (center between i and i+1)
            int len2 = expandFromCentre(s, i, i+1);
            
            // Take the longer of the two
            int len = Math.max(len1, len2);
            
            // Update start and end if we found a longer palindrome
            if(len > end - start) {
                // Calculate start and end indices based on center and length
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    /**
     * Expands around center to find palindrome length
     * 
     * @param s Input string
     * @param left Left pointer (start position)
     * @param right Right pointer (start position)
     * @return Length of palindrome found
     */
    public static int expandFromCentre(String s, int left, int right) {
        // Expand outward while characters match and within bounds
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Return length: (right - left - 1)
        // Example: "aba", left goes to -1, right goes to 3, length = 3 - (-1) - 1 = 3
        return right - left - 1;
    }
}
