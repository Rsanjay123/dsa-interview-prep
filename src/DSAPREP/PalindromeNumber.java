package DSAPREP;
import java.util.*;

/**
 * Problem: Palindrome Number
 * 
 * Problem Statement:
 * Determine if an integer is a palindrome. An integer is a palindrome when it reads the same 
 * backward as forward.
 * 
 * Examples:
 * Input: 121
 * Output: true (121 reads as 121 from left to right and from right to left)
 * 
 * Input: -121
 * Output: false (From left to right, it reads -121. From right to left, it becomes 121-)
 * 
 * Input: 10
 * Output: false (Reads 01 from right to left)
 * 
 * Approach:
 * Instead of reversing the entire number (which could cause overflow), we reverse only half of it.
 * 
 * Algorithm:
 * 1. Handle edge cases:
 *    - Negative numbers are never palindromes
 *    - Numbers ending in 0 (except 0 itself) are never palindromes
 * 2. Reverse only the right half of the number
 * 3. Compare the left half with the reversed right half
 * 4. For even-length numbers: x == reversed
 * 5. For odd-length numbers: x == reversed/10 (middle digit doesn't matter)
 * 
 * How it works:
 * - We extract digits from right to left and build reversed number
 * - We stop when reversed >= x (meaning we've processed at least half the digits)
 * - For 121: x=121, reversed=0 -> x=12, reversed=1 -> x=1, reversed=12 -> stop
 *   Compare: x=1, reversed=12 -> x == reversed/10 = 1 ✓
 * 
 * Time Complexity: O(log10(n)) - we process roughly half the digits
 * Space Complexity: O(1) - only using constant extra space
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }

    /**
     * Checks if a number is a palindrome
     * 
     * @param x The integer to check
     * @return true if x is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int x) {
        // Edge case 1: Negative numbers are not palindromes
        // Edge case 2: Numbers ending in 0 (except 0 itself) are not palindromes
        // Example: 10, 20, 100 cannot be palindromes because reversed would start with 0
        if(x < 0 || (x %10 == 0 && x != 0)) {
            return false;
        }
        
        // We'll reverse only the right half of the number
        int reversed = 0;
        
        // Continue until we've reversed at least half the number
        // When reversed >= x, we've processed at least half the digits
        while(x > reversed){
            // Extract the last digit
            int digit = x % 10;
            // Add it to reversed (multiply by 10 to shift left, then add digit)
            reversed = reversed * 10 + digit;
            // Remove the last digit from x
            x = x / 10;
        }
        
        // For even number of digits: x == reversed
        // Example: 1221 -> x=12, reversed=12 -> x == reversed ✓
        // For odd number of digits: x == reversed/10 (ignore middle digit)
        // Example: 121 -> x=1, reversed=12 -> x == reversed/10 = 1 ✓
        return x == reversed || x == reversed/10;
    }
}
