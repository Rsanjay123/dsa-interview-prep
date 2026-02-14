package DSAPREP;
import java.util.*;

/**
 * Problem: Longest Substring with Same Character
 * 
 * Problem Statement:
 * Find the length of the longest substring where all characters are the same.
 * 
 * Example:
 * Input: s = "aaabbccddeee"
 * Output: 3
 * Explanation: Longest substring with same character is "aaa" or "eee" (length 3).
 * 
 * Approach:
 * Traverse string and track current consecutive same character length.
 * 
 * Algorithm:
 * 1. Initialize maxLength = 1, currentLength = 1
 * 2. For each character starting from index 1:
 *    - If same as previous: increment currentLength
 *    - Else: update maxLength, reset currentLength to 1
 * 3. Update maxLength one final time (for last sequence)
 * 
 * Example walkthrough:
 * s = "aaabbccddeee"
 * i=1: 'a' == 'a', currentLength=2, maxLength=2
 * i=2: 'a' == 'a', currentLength=3, maxLength=3
 * i=3: 'b' != 'a', maxLength=3, currentLength=1
 * i=4: 'b' == 'b', currentLength=2, maxLength=3
 * ... continue
 * Final: maxLength=3 ✓
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - only using constant extra space
 */
public class LongestSubstringSameCharacter {
    public static void main(String[] args) {
        String s = "aaabbccddeee";
        System.out.println(longestSubstring(s));
        System.out.println(longestSubstring2(s));
    }

    /**
     * Approach 1: Update maxLength when character changes
     * 
     * Updates maxLength when we encounter a different character
     * 
     * @param s Input string
     * @return Length of longest substring with same character
     */
    public static int longestSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                // Same character, increment current length
                currentLength++;
            } else {
                // Different character, update maxLength and reset
                maxLength = Math.max(currentLength, maxLength);
                currentLength = 1;
            }
        }
        
        // Update maxLength one final time for the last sequence
        maxLength = Math.max(currentLength, maxLength);
        return maxLength;
    }

    /**
     * Approach 2: Update maxLength continuously
     * 
     * Updates maxLength every time currentLength increases
     * 
     * @param s Input string
     * @return Length of longest substring with same character
     */
    public static int longestSubstring2(String s) {
        int maxLength = 1;
        int currentLength = 1;
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                // Same character, increment and update maxLength
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                // Different character, reset current length
                currentLength = 1;
            }
        }
        
        return maxLength;
    }
}
