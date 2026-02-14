package DSAPREP;
import java.util.*;

/**
 * Problem: Plus One
 * 
 * Problem Statement:
 * You are given a large integer represented as an integer array digits, where each 
 * digits[i] is the ith digit of the integer. The digits are ordered from most significant 
 * to least significant in left-to-right order. The large integer does not contain any 
 * leading zeros.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Example:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124.
 * 
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9. Incrementing by one gives 9 + 1 = 10.
 * 
 * This file contains two approaches:
 * 1. Optimal approach (process from right, handle carry)
 * 2. Alternative approach (has a bug - doesn't handle all cases)
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
        int [] digits2 = {9};
        System.out.println(Arrays.toString(plusOne2(digits2)));
    }

    /**
     * Approach 1: Optimal Solution
     * 
     * Algorithm:
     * 1. Process digits from right to left
     * 2. If digit < 9: increment and return (no carry)
     * 3. If digit == 9: set to 0 and continue (carry propagates)
     * 4. If all digits were 9: create new array with leading 1
     * 
     * Key insight:
     * - Only need to check if digit < 9
     * - If digit is 9, it becomes 0 and carry propagates
     * - If we process all digits, all were 9s, need new array
     * 
     * Example walkthrough:
     * digits = [1,2,3]
     * i=2: digits[2]=3 < 9, digits[2]=4, return [1,2,4] ✓
     * 
     * digits = [1,9,9]
     * i=2: digits[2]=9, set to 0, continue
     * i=1: digits[1]=9, set to 0, continue
     * i=0: digits[0]=1 < 9, digits[0]=2, return [2,0,0] ✓
     * 
     * digits = [9,9]
     * i=1: digits[1]=9, set to 0
     * i=0: digits[0]=9, set to 0
     * All processed, create [1,0,0] ✓
     * 
     * Time Complexity: O(n) worst case, O(1) best case
     * Space Complexity: O(1) if no carry, O(n) if all 9s
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Process from right to left
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9) {
                // No carry needed, increment and return
                digits[i]++;
                return digits;
            }
            // Digit is 9, set to 0 and carry propagates
            digits[i] = 0;
        }
        
        // All digits were 9, need new array with leading 1
        // Example: [9,9] -> [1,0,0]
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    /**
     * Approach 2: Alternative (Has Bug)
     * 
     * Note: This approach has a bug - it only handles the case where the last digit 
     * is 9, but doesn't handle multiple 9s correctly (e.g., [9,9]).
     * 
     * It should use a loop similar to Approach 1 to handle all cases.
     * 
     * @param digits Array of digits
     * @return Array after adding one
     */
    public static int[] plusOne2(int[] digits) {
        int last = digits.length - 1;
        
        // If last digit < 9, simple increment
        if (digits[last] < 9) {
            digits[last] += 1;
            return digits;
        }
        
        // Last digit is 9, need to handle carry
        // Bug: This only handles last digit, doesn't propagate carry
        int[] newDigits = new int[digits.length + 1];
        int sum = digits[last] + 1;
        newDigits[0] = sum / 10;  // Should be 1
        newDigits[1] = sum % 10;  // Should be 0
        
        // Bug: Doesn't copy remaining digits correctly
        // For [9,9], this would give [1,0] instead of [1,0,0]
        return newDigits;
    }
}
