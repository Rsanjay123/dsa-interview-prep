package DSAPREP.DynamicPrograming;
import java.util.*;

/**
 * Problem: Count Combinations (Coin Change - Count Ways)
 * 
 * Problem Statement:
 * Given an array of numbers and a target sum k, count the number of ways 
 * to achieve the sum k using elements from the array (each element can be used once).
 * 
 * Example:
 * Input: arr = [1,2,3,4,5], n = 5, k = 7
 * Output: Number of ways to make sum 7
 * 
 * Approach:
 * Dynamic Programming - similar to coin change problem.
 * dp[sum] = number of ways to make sum.
 * 
 * Algorithm:
 * 1. Initialize dp[0] = 1 (one way to make sum 0)
 * 2. For each number in array:
 *    - For each sum from k down to num:
 *      * dp[sum] += dp[sum - num]
 * 3. Return dp[k]
 * 
 * Why iterate backwards?
 * - Prevents using same element twice in one iteration
 * - When we process num, we only use dp values from previous numbers
 * 
 * Time Complexity: O(n * k) where n is array size, k is target sum
 * Space Complexity: O(k) for dp array
 */
public class CombinationCount {
    public static void main(String[] args) {
        int n = 5;
        int k = 7;
        int[] arr = {1,2,3,4,5};
        System.out.println(countCombinations(arr, n, k));
    }

    public static int countCombinations(int[] arr, int n, int k) {
        int Mod = 1000000007;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for(int num : arr) {
            for(int sum = k; sum >= num; sum--) {
                dp[sum] = (dp[sum] + dp[sum-num]) % Mod;
            }
        }
        return dp[k];
    }
}
