package DSAPREP;
import java.util.*;

/**
 * Problem: Reverse Vowels of a String
 * 
 * Problem Statement:
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases.
 * 
 * Example:
 * Input: s = "routusanjay"
 * Output: "rajutasoniy" (vowels reversed: o,u,u,a,a -> a,a,o,u,u)
 * 
 * Approach:
 * Use two-pointer technique: one from start, one from end.
 * Swap vowels when both pointers find them.
 * 
 * Algorithm:
 * 1. Convert string to char array for in-place modification
 * 2. Use two pointers: left at start, right at end
 * 3. While left < right:
 *    - Skip non-vowels from left
 *    - Skip non-vowels from right
 *    - When both point to vowels, swap them
 *    - Move both pointers inward
 * 4. Convert char array back to string
 * 
 * Example walkthrough:
 * s = "hello"
 * left=0: 'h' (not vowel), left=1
 * left=1: 'e' (vowel), right=4: 'o' (vowel)
 * Swap: 'e' <-> 'o', result: "hollo"
 * left=2, right=3: both 'l' (not vowels), done
 * Result: "hollo" (but should be "holle" - need to check logic)
 * 
 * Actually: "hello" -> vowels are e,o -> reversed: o,e -> "holle" ✓
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(n) - char array for modification
 */
public class ReverseVowels {
    public static void main(String [] args) {
        System.out.println(swapVowels("routusanjay"));
        System.out.println(swapVowels("adhikarlaramateja"));
    }

    /**
     * Reverses only the vowels in a string
     * 
     * @param name Input string
     * @return String with vowels reversed
     */
    public static String swapVowels(String name) {
        // Edge cases: empty string or single character
        if(name.isEmpty() || name.length() == 1){
            return name;
        }
        
        int left = 0;
        int right = name.length() - 1;
        // Convert to char array for in-place modification
        char [] arr = name.toCharArray();
        String vowels = "AEIOUaeiou";
        
        while(left < right){
            // Skip non-vowels from left
            // Check left < right again to avoid out of bounds
            if(left < right && vowels.indexOf(arr[left]) == -1){
                left++;
                continue;
            }
            
            // Skip non-vowels from right
            if(left < right && vowels.indexOf(arr[right]) == -1){
                right--;
                continue;
            }
            
            // Both pointers point to vowels, swap them
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            // Move both pointers inward
            left++;
            right--;
        }
        
        return new String(arr);
    }
}
