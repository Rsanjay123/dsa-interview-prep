package DSAPREP;
import java.util.*;

/**
 * Problem: Longest Consecutive Sequence
 * 
 * Problem Statement:
 * Given an unsorted array of integers nums, return the length of the longest consecutive 
 * elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * Example:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
 *              Therefore its length is 4.
 * 
 * Approach:
 * Sort the array and count consecutive sequences.
 * 
 * Algorithm:
 * 1. Sort the array
 * 2. Initialize consecutiveCount = 1, maxCount = 1
 * 3. Iterate through sorted array:
 *    - If current == previous: skip (duplicate)
 *    - If current == previous + 1: increment consecutiveCount
 *    - Else: update maxCount and reset consecutiveCount
 * 4. Return max of maxCount and consecutiveCount
 * 
 * Note: This solution is O(n log n) due to sorting, not O(n).
 * For true O(n) solution, use HashSet to find sequence starts.
 * 
 * Example walkthrough:
 * nums = [100,4,200,1,3,2]
 * After sort: [1,2,3,4,100,200]
 * i=1: diff=1, consecutiveCount=2
 * i=2: diff=1, consecutiveCount=3
 * i=3: diff=1, consecutiveCount=4
 * i=4: diff=96, maxCount=4, consecutiveCount=1
 * i=5: diff=100, maxCount=4, consecutiveCount=1
 * Return: 4
 * 
 * Time Complexity: O(n log n) - sorting dominates
 * Space Complexity: O(1) excluding the sort space (O(log n) for quicksort)
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args)  {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * Finds the length of the longest consecutive sequence
     * 
     * @param nums Unsorted array of integers
     * @return Length of longest consecutive sequence
     */
    public static int longestConsecutive(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Sort array to enable consecutive checking
        Arrays.sort(nums);
        
        int consecutiveCount = 1;  // Current consecutive sequence length
        int maxCount = 1;          // Maximum consecutive sequence length seen
        
        // Check each element against previous
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            
            if (diff == 0) {
                // Duplicate number, skip (don't break sequence)
                continue;
            } else if (diff == 1) {
                // Consecutive! Increment count
                consecutiveCount++;
            } else {
                // Gap found, sequence broken
                // Update maxCount and reset consecutiveCount
                maxCount = Math.max(maxCount, consecutiveCount);
                consecutiveCount = 1;
            }
        }
        
        // Return max of maxCount and consecutiveCount
        // (in case longest sequence ends at last element)
        return Math.max(maxCount, consecutiveCount);
    }
}
