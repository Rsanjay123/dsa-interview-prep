package DSAPREP;
import java.util.*;

/**
 * Problem: String to Integer (atoi)
 * 
 * Problem Statement:
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 1. Read in and ignore any leading whitespace
 * 2. Check if the next character is '-' or '+'
 * 3. Read in next the characters until the next non-digit character or end of input
 * 4. Convert these digits into an integer
 * 5. If integer is out of 32-bit range, clamp to range
 * 
 * Example:
 * Input: s = "   -042"
 * Output: -42
 * 
 * Approach:
 * Process string character by character, handling whitespace, sign, and digits.
 * Check for overflow before multiplying.
 * 
 * Algorithm:
 * 1. Skip leading whitespace
 * 2. Read sign if present
 * 3. Read digits and build number:
 *    - Check for overflow before multiplying
 *    - If overflow: return MAX_VALUE or MIN_VALUE based on sign
 * 4. Return result * sign
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(1) - only using constant extra space
 */
public class AtoI {
    public static void main(String[] args) {
        String str = "   -042";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        int result = 0;
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result*sign;
    }
}
