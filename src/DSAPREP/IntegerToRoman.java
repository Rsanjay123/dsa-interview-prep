package DSAPREP;
import java.util.*;

/**
 * Problem: Integer to Roman
 * 
 * Problem Statement:
 * Convert an integer to a Roman numeral string.
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * Special cases (subtraction notation):
 * IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900
 * 
 * Example:
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90, IV = 4
 * 
 * Approach:
 * Greedy algorithm - use largest possible values first.
 * 
 * Algorithm:
 * 1. Create arrays of values and corresponding symbols (including subtraction cases)
 * 2. For each value from largest to smallest:
 *    - While num >= value, append symbol and subtract value
 * 3. Return the Roman numeral string
 * 
 * Why include subtraction cases?
 * - We need to handle 4, 9, 40, 90, 400, 900 specially
 * - Including them in the values array makes the algorithm simpler
 * - We process them in descending order (greedy)
 * 
 * Example walkthrough:
 * num = 1994
 * values[0]=1000: 1994 >= 1000, append "M", num=994
 * values[0]=1000: 994 < 1000, move to next
 * values[1]=900: 994 >= 900, append "CM", num=94
 * values[1]=900: 94 < 900, move to next
 * ... continue
 * values[5]=90: 94 >= 90, append "XC", num=4
 * values[11]=4: 4 >= 4, append "IV", num=0
 * Result: "MCMXCIV" ✓
 * 
 * Time Complexity: O(1) - at most 13 iterations (constant)
 * Space Complexity: O(1) - output string length is bounded
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    /**
     * Converts integer to Roman numeral string
     * 
     * @param num Integer to convert (1 <= num <= 3999)
     * @return Roman numeral string
     */
    public static String intToRoman(int num) {
        // Values in descending order (greedy approach)
        // Includes subtraction cases: 900, 400, 90, 40, 9, 4
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        
        // Process each value from largest to smallest
        for(int i = 0; i < values.length; i++) {
            // Use as many of this value as possible
            while(num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return sb.toString();
    }
}
