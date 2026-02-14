package DSAPREP;
import java.util.*;

/**
 * Problem: Fizz Buzz
 * 
 * Problem Statement:
 * Given an integer n, return a string array answer (1-indexed) where:
 * - answer[i] == "FizzBuzz" if i is divisible by both 3 and 5
 * - answer[i] == "Fizz" if i is divisible by 3
 * - answer[i] == "Buzz" if i is divisible by 5
 * - answer[i] == i (as a string) if none of the above conditions are true
 * 
 * Example:
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * 
 * Approach:
 * Check divisibility conditions in order: both 3 and 5, then 3, then 5, else number.
 * 
 * Algorithm:
 * 1. For each number from 1 to n:
 *    - If divisible by both 3 and 5: "FizzBuzz"
 *    - Else if divisible by 3: "Fizz"
 *    - Else if divisible by 5: "Buzz"
 *    - Else: number as string
 * 2. Add to result list
 * 
 * Key point:
 * - Check "FizzBuzz" first (divisible by both) before individual checks
 * - Order matters: if we check 3 first, we'd miss "FizzBuzz"
 * 
 * Example walkthrough:
 * i=1: 1%3!=0, 1%5!=0 -> "1"
 * i=3: 3%3==0, 3%5!=0 -> "Fizz"
 * i=5: 5%3!=0, 5%5==0 -> "Buzz"
 * i=15: 15%3==0 && 15%5==0 -> "FizzBuzz"
 * 
 * Time Complexity: O(n) - iterate through n numbers
 * Space Complexity: O(n) - result list stores n strings
 */
public class FizzBizzTest {
    public static void main(String[] args) {
        int n = 15;
        List<String> result = fizzBuzz(n);
        System.out.println(result);
    }
    
    /**
     * Generates FizzBuzz sequence from 1 to n
     * 
     * @param n Upper bound
     * @return List of FizzBuzz strings
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            // Check divisibility conditions in order
            if(i % 3 == 0 && i % 5 == 0){
                // Divisible by both 3 and 5
                result.add("FizzBuzz");
            } else if(i % 3 == 0){
                // Divisible by 3 only
                result.add("Fizz");
            } else if(i % 5 == 0){
                // Divisible by 5 only
                result.add("Buzz");
            } else {
                // Not divisible by 3 or 5
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
