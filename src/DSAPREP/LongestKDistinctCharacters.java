package DSAPREP;
import java.util.*;

/**
 * Problem: Longest Substring with At Most K Distinct Characters
 * 
 * Problem Statement:
 * Given a string s and an integer k, return the length of the longest substring 
 * that contains at most k distinct characters.
 * 
 * Example:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring "ece" has length 3 and contains 2 distinct characters.
 * 
 * Approach:
 * Sliding window technique with HashMap to track character frequencies.
 * 
 * Algorithm:
 * 1. Use two pointers (left, right) for sliding window
 * 2. Use HashMap to track character frequencies in current window
 * 3. Expand right pointer: add character to map
 * 4. While distinct characters > k: shrink window from left
 * 5. Update maxLength after each valid window
 * 
 * Key insight:
 * - When map.size() > k, we have too many distinct characters
 * - Remove characters from left until map.size() <= k
 * - Remove character from map only when its count reaches 0
 * 
 * Example walkthrough:
 * s = "eceba", k = 2
 * right=0: 'e', map={e:1}, size=1<=2, maxLength=1
 * right=1: 'c', map={e:1,c:1}, size=2<=2, maxLength=2
 * right=2: 'e', map={e:2,c:1}, size=2<=2, maxLength=3
 * right=3: 'b', map={e:2,c:1,b:1}, size=3>2
 *   shrink: left=0, remove 'e', map={e:1,c:1,b:1}, size=3>2
 *   shrink: left=1, remove 'c', map={e:1,b:1}, size=2<=2
 *   maxLength=3
 * right=4: 'a', map={e:1,b:1,a:1}, size=3>2
 *   shrink: left=2, remove 'e', map={b:1,a:1}, size=2<=2
 *   maxLength=3
 * Result: 3 ✓
 * 
 * Time Complexity: O(n) - each character visited at most twice
 * Space Complexity: O(k) - HashMap stores at most k+1 distinct characters
 */
public class LongestKDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(longestKDistinctCharacters(s, k));
        System.out.println(longestKDistinctCharacters2(s, k));
    }

    /**
     * Approach 1: For loop with right pointer
     * 
     * Finds longest substring with at most k distinct characters
     * 
     * @param s Input string
     * @param k Maximum number of distinct characters
     * @return Length of longest substring
     */
    public static int longestKDistinctCharacters(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // Add current character to map
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            
            // Shrink window if too many distinct characters
            while(map.size() > k) {
                char leftChar = s.charAt(left);
                // Decrease frequency of left character
                map.put(leftChar, map.get(leftChar) - 1);
                // Remove if count reaches 0
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            
            // Update maxLength after ensuring valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    /**
     * Approach 2: While loop (alternative implementation)
     * 
     * Same algorithm, different loop structure
     * Note: Bug - should increment right after updating maxLength, not before
     * 
     * @param s Input string
     * @param k Maximum number of distinct characters
     * @return Length of longest substring
     */
    public static int longestKDistinctCharacters2(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(right < s.length()){
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            
            right++;
            // Update maxLength after incrementing right
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
