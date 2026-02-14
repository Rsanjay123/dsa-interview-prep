package DSAPREP;
import java.util.*;

/**
 * Problem: Roman to Integer
 * 
 * Problem Statement:
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
 * For example, 2 is written as II, 12 is written as XII, 27 is XXVII.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, 
 * when a smaller value precedes a larger value, it is subtracted (e.g., IV = 4, IX = 9).
 * 
 * Example:
 * Input: s = "IV"
 * Output: 4
 * 
 * Input: s = "LVIII"
 * Output: 58 (L=50, V=5, III=3)
 * 
 * Approach:
 * Process from left to right. If current value < next value, subtract current.
 * Otherwise, add current.
 * 
 * Algorithm:
 * 1. Create map of Roman symbols to values
 * 2. Iterate through string:
 *    - If current < next: subtract current (e.g., IV = -1 + 5 = 4)
 *    - Else: add current
 * 3. Return total
 * 
 * Key insight:
 * - When smaller value precedes larger, we subtract it
 * - We can process this by subtracting when current < next
 * - Otherwise, we add normally
 * 
 * Example walkthrough:
 * s = "IV"
 * i=0: current='I'=1, next='V'=5, 1<5, subtract: total=-1
 * i=1: current='V'=5, next=' ', add: total=-1+5=4 ✓
 * 
 * s = "LVIII"
 * i=0: L=50, next=V=5, add: total=50
 * i=1: V=5, next=I=1, add: total=55
 * i=2: I=1, next=I=1, add: total=56
 * i=3: I=1, next=I=1, add: total=57
 * i=4: I=1, next=' ', add: total=58 ✓
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(1) - map has constant size
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInt(s));
    }

    /**
     * Converts Roman numeral string to integer
     * 
     * @param s Roman numeral string
     * @return Integer value
     */
    public static int romanToInt(String s) {
        // Map Roman symbols to their values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            char currentValue = s.charAt(i);
            char nextValue = (i + 1 < n) ? s.charAt(i + 1) : ' ';
            
            // Check if current value should be subtracted
            // This happens when current < next (e.g., IV, IX, XL, XC, CD, CM)
            if(romanMap.containsKey(currentValue) && 
               romanMap.containsKey(nextValue) && 
               (romanMap.get(currentValue) < romanMap.get(nextValue))){
                // Subtract current value (will be compensated when we process next)
                total -= romanMap.get(currentValue);
            } else {
                // Add current value normally
                total += romanMap.get(currentValue);
            }
        }
        
        return total;
    }
}
