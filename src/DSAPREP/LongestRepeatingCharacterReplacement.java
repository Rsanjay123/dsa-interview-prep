package DSAPREP;
import java.util.*;

/**
 * Problem: Longest Repeating Character Replacement
 * 
 * Problem Statement:
 * You are given a string s and an integer k. You can choose any character of the string 
 * and change it to any other uppercase English letter. You can perform this operation 
 * at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can get 
 * after performing the above operations.
 * 
 * Example:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' to form "AABBBBA".
 *              The substring "BBBB" has length 4.
 * 
 * Approach:
 * Sliding window technique. Track frequency of each character and maximum frequency.
 * Window is valid if (window_size - maxFreq) <= k.
 * 
 * Algorithm:
 * 1. Use sliding window with frequency array
 * 2. Track maxFreq (most frequent character in current window)
 * 3. Expand right: update frequency and maxFreq
 * 4. Shrink left if window invalid: (window_size - maxFreq) > k
 * 5. Update maxLength
 * 
 * Key insight:
 * - We can replace (window_size - maxFreq) characters
 * - If this <= k, window is valid
 * - We want to maximize window_size
 * 
 * Note: Current implementation has a bug - should check (right-left+1 - maxFreq) > k
 * 
 * Example walkthrough:
 * s = "AABABBA", k = 1
 * right=0: 'A', freq[A]=1, maxFreq=1, window=1, valid, maxLength=1
 * right=1: 'A', freq[A]=2, maxFreq=2, window=2, valid (2-2=0<=1), maxLength=2
 * right=2: 'B', freq[B]=1, maxFreq=2, window=3, valid (3-2=1<=1), maxLength=3
 * right=3: 'A', freq[A]=3, maxFreq=3, window=4, valid (4-3=1<=1), maxLength=4
 * right=4: 'B', freq[B]=2, maxFreq=3, window=5, invalid (5-3=2>1)
 *   shrink: left=1, freq[A]=2, maxFreq=3, window=4, valid
 * ... continue
 * 
 * Time Complexity: O(n) - each character visited at most twice
 * Space Complexity: O(1) - fixed size frequency array (26)
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(longestRepeatingCharacterReplacement(s, k));
        System.out.println(longestRepeatingCharacterReplacement2(s, k));
    }

    /**
     * Approach 1: For loop
     * 
     * Note: This implementation has a bug. Should check:
     * (right - left + 1 - maxFreq) > k
     * instead of (right - left + 1) > k
     * 
     * @param s Input string
     * @param k Maximum replacements allowed
     * @return Length of longest substring
     */
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;  // Maximum frequency of any character in current window
        int maxLength = 0;
        
        for(right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // Update frequency
            freq[currentChar - 'A']++;
            // Update maximum frequency
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);
            
            // Bug: Should check (right - left + 1 - maxFreq) > k
            // Current check is incorrect
            while ((right - left + 1) > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    /**
     * Approach 2: While loop (has same bug)
     * 
     * @param s Input string
     * @param k Maximum replacements allowed
     * @return Length of longest substring
     */
    public static int longestRepeatingCharacterReplacement2(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        while(right < s.length()) {
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);
            
            // Bug: Should check (right - left + 1 - maxFreq) > k
            while((right - left + 1) > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
