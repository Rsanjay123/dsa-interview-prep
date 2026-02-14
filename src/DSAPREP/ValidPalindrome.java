package DSAPREP;
import java.util.*;

/**
 * Problem: Valid Palindrome
 * 
 * Problem Statement:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * 
 * Examples:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Approach:
 * Use two pointers from both ends, skip non-alphanumeric characters, 
 * compare characters case-insensitively.
 * 
 * Algorithm:
 * 1. Initialize left = 0, right = s.length() - 1
 * 2. While left < right:
 *    - Skip non-alphanumeric characters from left
 *    - Skip non-alphanumeric characters from right
 *    - Compare characters (case-insensitive)
 *    - If not equal, return false
 *    - Move both pointers inward
 * 3. If all comparisons passed, return true
 * 
 * Key points:
 * - Only consider alphanumeric characters (letters and digits)
 * - Case-insensitive comparison (convert to lowercase)
 * - Skip punctuation and spaces
 * 
 * Example walkthrough:
 * s = "A man, a plan, a canal: Panama"
 * left=0: 'A' (alphanumeric), right=29: 'a' (alphanumeric)
 *   'a' == 'a' ✓, left=1, right=28
 * left=1: ' ' (skip), left=2
 * left=2: 'm', right=28: 'm' ✓
 * ... continue until left >= right
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - only using two pointers
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    
    /**
     * Checks if a string is a palindrome after removing non-alphanumeric characters
     * 
     * @param s The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            // Skip non-alphanumeric characters from left
            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            
            // Skip non-alphanumeric characters from right
            if(!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            
            // Compare characters case-insensitively
            // Convert both to lowercase before comparison
            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            
            // Characters match, move both pointers inward
            left++;
            right--;
        }
        
        // All character pairs matched
        return true;
    }
}
