package DSAPREP;
import java.util.*;

/**
 * Problem: Two Sum
 * 
 * Problem Statement:
 * Given an array of integers and a target sum, find two numbers such that they add up to the target.
 * Return the indices of the two numbers.
 * 
 * Example:
 * Input: arr = [1, 2, 3, 4, 5, 6], target = 10
 * Output: [3, 5] (indices of 4 and 6)
 * 
 * This file contains two different approaches:
 * 1. Two-pointer approach (for sorted arrays)
 * 2. Hash map approach (for unsorted arrays)
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};
        int target = 10;
        int [] result = twosum(arr, target);
        int [] result2 = twoSum2(arr, target);
        System.out.println(result[0] + " " + result[1]);
        System.out.println(result2[0] + " " + result2[1]);
    }

    /**
     * Approach 1: Two-Pointer Technique (for sorted arrays)
     * 
     * Algorithm:
     * 1. Use two pointers: left at start (0) and right at end (n-1)
     * 2. Calculate sum of elements at both pointers
     * 3. If sum equals target, return indices
     * 4. If sum < target, move left pointer right (need larger sum)
     * 5. If sum > target, move right pointer left (need smaller sum)
     * 6. Continue until pointers meet
     * 
     * Why it works:
     * - Since array is sorted, moving left increases sum, moving right decreases sum
     * - This allows us to systematically search for the target sum
     * 
     * Time Complexity: O(n) - single pass through array
     * Space Complexity: O(1) - only using two pointers
     * 
     * Note: This approach assumes the array is sorted
     * 
     * @param arr Sorted array of integers
     * @param target Target sum to find
     * @return Array containing indices of two numbers that sum to target, or [-1, -1] if not found
     */
    public static int[] twosum(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(sum == target){
                // Found the pair!
                return new int[]{left, right};
            } else if(sum < target) {
                // Sum is too small, need larger numbers - move left pointer right
                left++;
            } else {
                // Sum is too large, need smaller numbers - move right pointer left
                right--;
            }
        }
        
        // No pair found
        return new int[]{-1, -1};
    }

    /**
     * Approach 2: Hash Map Technique (works for unsorted arrays)
     * 
     * Algorithm:
     * 1. Create a hash map to store (value, index) pairs
     * 2. For each element in array:
     *    - Calculate complement = target - current element
     *    - Check if complement exists in map
     *    - If yes, return [map.get(complement), current_index]
     *    - If no, add current (value, index) to map
     * 3. If no pair found, return [-1, -1]
     * 
     * Why it works:
     * - For each number, we check if its complement (target - number) was seen before
     * - If complement exists in map, we found our pair
     * - We store numbers as we iterate, so we can look back at previous elements
     * 
     * Example walkthrough:
     * arr = [2, 7, 11, 15], target = 9
     * i=0: num=2, complement=7, map={}, add (2,0) to map
     * i=1: num=7, complement=2, map contains 2! Return [0, 1]
     * 
     * Time Complexity: O(n) - single pass through array, hash map operations are O(1)
     * Space Complexity: O(n) - hash map can store up to n elements
     * 
     * Advantage: Works for unsorted arrays, only requires one pass
     * 
     * @param arr Array of integers (can be unsorted)
     * @param target Target sum to find
     * @return Array containing indices of two numbers that sum to target, or [-1, -1] if not found
     */
    public static int[] twoSum2(int[] arr, int target){
        // Map stores: (number value, its index)
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            // Calculate what number we need to pair with arr[i] to get target
            int compliment = target - arr[i];
            
            // Check if we've seen this complement before
            if(map.containsKey(compliment)){
                // Found it! Return indices: [previous index, current index]
                return new int[]{map.get(compliment), i};
            }
            
            // Store current number and its index for future lookups
            map.put(arr[i], i);
        }
        
        // No pair found
        return new int[]{-1, -1};
    }
}