package DSAPREP;
import java.util.*;

/**
 * Problem: Valid Number
 * 
 * Problem Statement:
 * A valid number can be split up into these components (in order):
 * 1. A decimal number or an integer
 * 2. (Optional) An 'e' or 'E', followed by an integer
 * 
 * A decimal number can be split up into these components (in order):
 * 1. (Optional) A sign character ('+' or '-')
 * 2. One of the following formats:
 *    - One or more digits, followed by a dot '.'
 *    - One or more digits followed by a dot '.', followed by one or more digits
 *    - A dot '.', followed by one or more digits
 * 
 * An integer can be split up into these components (in order):
 * 1. (Optional) A sign character ('+' or '-')
 * 2. One or more digits
 * 
 * Example:
 * Input: s = "  -42.3e+7  "
 * Output: true
 * 
 * Approach:
 * Use state machine with flags to track what we've seen.
 * 
 * Algorithm:
 * 1. Trim whitespace
 * 2. Track flags: seenDigit, seenDot, seenExp, seenDigitAfterExp
 * 3. For each character:
 *    - Digit: mark seenDigit, if after exp mark seenDigitAfterExp
 *    - Sign: must be at start or after 'e'/'E'
 *    - Dot: can't appear after dot or exponent
 *    - Exponent: must have seen digit, can't appear twice
 * 4. Return true if seen digit and (no exp or digit after exp)
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(1) - only using flags
 */
public class ValidNumber {
    public static void main(String[] args) {
        String s = "  -42.3e+7  ";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean seenDigitAfterExp = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                seenDigit = true;
                if(seenExp){
                    seenDigitAfterExp = true;
                }
            } else if(c == '+' || c == '-'){
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if(c == '.'){
                if(seenDot || seenExp){
                    return false;
                }
                seenDot = true;
            } else if(c == 'e' || c == 'E') {
                if(seenExp || !seenDigit){
                    return false;
                }
                seenExp = true;
                seenDigitAfterExp = false;
            } else {
                return false;
            }
        }
        return seenDigit && seenDigitAfterExp;
    }
}
