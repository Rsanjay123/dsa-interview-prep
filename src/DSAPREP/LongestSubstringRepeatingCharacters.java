package DSAPREP;
import java.util.*;

/**
 * Problem: Longest Substring Without Repeating Characters
 * 
 * Problem Statement:
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The longest substring without repeating characters is "abc", with length 3.
 * 
 * This file contains three different approaches:
 * 1. Sliding window with Set (has a bug - removes wrong character)
 * 2. Sliding window with HashMap (optimal - stores last seen index)
 * 3. Sliding window with HashMap (alternative implementation)
 */
public class LongestSubstringRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstring(s));
        System.out.println(longestSubString2(s));
        System.out.println(longestSubString3(s));
    }
    
    /**
     * Approach 1: Sliding Window with Set
     * 
     * Note: This implementation has a bug - it removes chars.charAt(left) instead of 
     * the character that's causing the duplicate. Should remove the character at 'right' 
     * that's already in the set, not the one at 'left'.
     * 
     * Algorithm:
     * 1. Use two pointers (left, right) to represent sliding window
     * 2. Use Set to track characters in current window
     * 3. Expand right pointer: if char not in set, add it and update max
     * 4. Shrink left pointer: if char already in set, remove left char and move left
     * 
     * Time Complexity: O(n) - each character visited at most twice
     * Space Complexity: O(min(n,m)) where m is charset size
     */
    public static int longestSubstring(String chars) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        
        while(right < chars.length()){
            char currentChar = chars.charAt(right);
            
            if(!set.contains(currentChar)){
                // Character not seen, add to set and expand window
                set.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                // Character already in set, shrink window from left
                // Bug: Should remove the character causing duplicate, not left char
                set.remove(chars.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
    
    /**
     * Approach 2: Sliding Window with HashMap (Optimal)
     * 
     * Algorithm:
     * 1. Use HashMap to store (character, last_seen_index)
     * 2. Expand right pointer: for each character
     *    - If char seen before and its index >= left: move left to index+1
     *    - Update map with current char and its index
     *    - Update max length
     * 3. The key insight: when we see a duplicate, we can jump left pointer 
     *    directly to after the last occurrence, skipping unnecessary checks
     * 
     * Why it's better:
     * - Doesn't need to remove characters one by one
     * - Can jump left pointer directly to optimal position
     * - More efficient than Approach 1
     * 
     * Example walkthrough:
     * s = "abcabcbb"
     * right=0: 'a', map={a:0}, left=0, max=1
     * right=1: 'b', map={a:0,b:1}, left=0, max=2
     * right=2: 'c', map={a:0,b:1,c:2}, left=0, max=3
     * right=3: 'a' seen at 0, left=max(0,0+1)=1, map={a:3,b:1,c:2}, max=3
     * right=4: 'b' seen at 1, left=max(1,1+1)=2, map={a:3,b:4,c:2}, max=3
     * 
     * Time Complexity: O(n) - single pass
     * Space Complexity: O(min(n,m)) where m is charset size
     */
    public static int longestSubString2(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        // Map stores: (character, its last seen index)
        Map<Character, Integer> map = new HashMap<>();
        
        while(right < s.length()){
            char currentChar = s.charAt(right);
            
            // If character seen before and its last occurrence is within current window
            if(map.containsKey(currentChar)){
                // Move left pointer to after the last occurrence of this character
                // Math.max ensures left only moves forward, never backward
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Update/insert current character's index
            map.put(currentChar, right);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
    
    /**
     * Approach 3: Sliding Window with HashMap (Alternative Implementation)
     * 
     * Similar to Approach 2, but uses for loop instead of while loop.
     * The logic is identical - just a different style.
     * 
     * Key difference: checks if map.get(currentChar) >= left before updating left.
     * This ensures we only consider duplicates within the current window.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(min(n,m))
     */
    public static int longestSubString3(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character seen before AND its last occurrence is within current window
            if(map.containsKey(currentChar) && map.get(currentChar) >= left){
                // Move left pointer to after the last occurrence
                left = map.get(currentChar) + 1;
            }
            
            // Update character's last seen index
            map.put(currentChar, right);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
