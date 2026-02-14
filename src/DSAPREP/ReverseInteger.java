package DSAPREP;
import java.util.*;

/**
 * Problem: Reverse Integer
 * 
 * Problem Statement:
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range 
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Examples:
 * Input: 123
 * Output: 321
 * 
 * Input: -123
 * Output: -321
 * 
 * Input: 120
 * Output: 21
 * 
 * Input: 1534236469
 * Output: 0 (reversed would be 9646324351, which exceeds 32-bit range)
 * 
 * Approach:
 * Extract digits from right to left and build the reversed number.
 * Must check for integer overflow before actually multiplying.
 * 
 * Algorithm:
 * 1. Initialize reversed = 0
 * 2. While x != 0:
 *    - Extract last digit: digit = x % 10
 *    - Remove last digit: x = x / 10
 *    - Check for overflow BEFORE multiplying:
 *      * If reversed > MAX_VALUE/10, overflow will occur
 *      * If reversed == MAX_VALUE/10 and digit > 7, overflow will occur
 *      * Similar checks for negative overflow
 *    - If no overflow, multiply reversed by 10 and add digit
 * 3. Return reversed
 * 
 * Overflow Prevention:
 * - Integer.MAX_VALUE = 2,147,483,647 (last digit is 7)
 * - Integer.MIN_VALUE = -2,147,483,648 (last digit is -8)
 * - Before doing reversed * 10 + digit, check:
 *   * reversed > MAX_VALUE/10 means overflow
 *   * reversed == MAX_VALUE/10 && digit > 7 means overflow
 *   * Similar for negative side
 * 
 * Example walkthrough (x = 123):
 * Iteration 1: digit=3, x=12, reversed=0*10+3=3
 * Iteration 2: digit=2, x=1, reversed=3*10+2=32
 * Iteration 3: digit=1, x=0, reversed=32*10+1=321
 * 
 * Time Complexity: O(log10(n)) - number of digits in the integer
 * Space Complexity: O(1) - only using constant extra space
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(reverse(num));
    }

    /**
     * Reverses the digits of an integer
     * 
     * @param x The integer to reverse
     * @return The reversed integer, or 0 if overflow occurs
     */
    public static int reverse(int x) {
        int reversed = 0;
        
        while(x != 0) {
            // Extract the last digit
            int digit = x % 10;
            // Remove the last digit from x
            x = x / 10;
            
            // Check for positive overflow BEFORE multiplying
            // If reversed > MAX_VALUE/10, then reversed * 10 will overflow
            // If reversed == MAX_VALUE/10 and digit > 7, then reversed * 10 + digit will overflow
            // (MAX_VALUE = 2,147,483,647, so last digit is 7)
            if(reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE/10 && digit > 7)) {
                return 0;
            }
            
            // Check for negative overflow BEFORE multiplying
            // If reversed < MIN_VALUE/10, then reversed * 10 will overflow
            // If reversed == MIN_VALUE/10 and digit < -8, then reversed * 10 + digit will overflow
            // (MIN_VALUE = -2,147,483,648, so last digit is -8)
            if(reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE/10 && digit < -8)) {
                return 0;
            }
            
            // Safe to multiply and add digit
            reversed = reversed * 10 + digit;
        }
        
        return reversed;
    }
}
