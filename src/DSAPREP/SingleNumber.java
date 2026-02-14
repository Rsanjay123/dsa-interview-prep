package DSAPREP;
import java.util.*;

/**
 * Problem: Single Number
 * 
 * Problem Statement:
 * Given a non-empty array of integers nums, every element appears twice except for one. 
 * Find that single one.
 * 
 * You must implement a solution with O(n) time complexity and O(1) space complexity.
 * 
 * Example:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Explanation: 1 appears twice, 2 appears twice, but 4 appears only once.
 * 
 * This file contains two approaches:
 * 1. HashMap approach (O(n) time, O(n) space)
 * 2. XOR approach (O(n) time, O(1) space) - Optimal
 */
public class SingleNumber {
    public static void main(String[] args){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberXoR(nums));
    }

    /**
     * Approach 1: HashMap (Frequency Counting)
     * 
     * Algorithm:
     * 1. Count frequency of each number using HashMap
     * 2. Iterate through map to find number with frequency 1
     * 
     * Time Complexity: O(n) - two passes through array
     * Space Complexity: O(n) - HashMap stores up to n/2 + 1 entries
     * 
     * Note: This doesn't meet O(1) space requirement, but is intuitive
     * 
     * @param nums Array of integers where all appear twice except one
     * @return The single number that appears only once
     */
    public static int singleNumber(int[] nums) {
        // Map stores: (number, its frequency)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count frequency of each number
        for(int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.replace(num, map.get(num) + 1);
            }
        }
        
        // Find the number with frequency 1
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * Approach 2: XOR (Bit Manipulation) - Optimal Solution
     * 
     * Key Insight:
     * XOR has these properties:
     * - a ^ 0 = a (XOR with 0 returns the number)
     * - a ^ a = 0 (XOR with itself returns 0)
     * - XOR is commutative and associative: a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     * 
     * Algorithm:
     * 1. Initialize result = 0
     * 2. XOR all numbers together
     * 3. Pairs will cancel out (a ^ a = 0)
     * 4. Only the single number remains
     * 
     * How it works:
     * nums = [4,1,2,1,2]
     * result = 0
     * result = 0 ^ 4 = 4
     * result = 4 ^ 1 = 5
     * result = 5 ^ 2 = 7
     * result = 7 ^ 1 = 6
     * result = 6 ^ 2 = 4 ✓
     * 
     * In binary:
     * 4 = 100
     * 1 = 001, 1 = 001 (cancel out)
     * 2 = 010, 2 = 010 (cancel out)
     * Only 4 remains!
     * 
     * Time Complexity: O(n) - single pass through array
     * Space Complexity: O(1) - only using one variable
     * 
     * This is the optimal solution meeting all requirements!
     * 
     * @param nums Array of integers where all appear twice except one
     * @return The single number that appears only once
     */
    public static int singleNumberXoR(int[] nums) {
        int result = 0;
        
        // XOR all numbers together
        // Pairs will cancel out, leaving only the single number
        for(int num: nums) {
            result ^= num;
        }
        
        return result;
    }
}
