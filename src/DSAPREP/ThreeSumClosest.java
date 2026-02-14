package DSAPREP;
import java.util.*;

/**
 * Problem: 3Sum Closest
 * 
 * Problem Statement:
 * Given an integer array nums of length n and an integer target, find three integers 
 * in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Approach:
 * Sort array, then use two-pointer technique similar to 3Sum.
 * Track the closest sum found so far.
 * 
 * Algorithm:
 * 1. Sort the array
 * 2. Initialize closestSum with first three elements
 * 3. For each index i:
 *    - Use two pointers: left = i+1, right = n-1
 *    - While left < right:
 *      * Calculate currentSum = nums[i] + nums[left] + nums[right]
 *      * Update closestSum if currentSum is closer to target
 *      * If currentSum < target: move left right
 *      * If currentSum > target: move right left
 *      * If currentSum == target: return target (exact match)
 * 4. Return closestSum
 * 
 * Key difference from 3Sum:
 * - We track closest sum instead of exact matches
 * - We don't skip duplicates (though we could for optimization)
 * 
 * Example walkthrough:
 * nums = [-1,2,1,-4], target = 1, sorted = [-4,-1,1,2]
 * closestSum = -4 + -1 + 1 = -4
 * i=0: nums[i]=-4, left=1, right=3
 *   sum = -4 + -1 + 2 = -3, abs(-3-1)=4 < abs(-4-1)=5, closestSum=-3
 *   sum < target, left=2
 *   sum = -4 + 1 + 2 = -1, abs(-1-1)=2 < abs(-3-1)=4, closestSum=-1
 *   sum < target, left=3, done
 * i=1: nums[i]=-1, left=2, right=3
 *   sum = -1 + 1 + 2 = 2, abs(2-1)=1 < abs(-1-1)=2, closestSum=2 ✓
 * 
 * Time Complexity: O(n²) - outer loop O(n), two-pointer O(n)
 * Space Complexity: O(1) excluding sort space
 */
public class ThreeSumClosest {
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * Finds three integers whose sum is closest to target
     * 
     * @param nums Array of integers
     * @param target Target sum
     * @return Sum closest to target
     */
    public static int threeSumClosest(int[] nums, int target) {
        // Sort array to enable two-pointer technique
        Arrays.sort(nums);
        
        // Initialize with first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Fix first number, use two pointers for remaining two
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update closestSum if currentSum is closer to target
                if(Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Adjust pointers based on comparison with target
                if(currentSum < target) {
                    // Sum too small, need larger numbers
                    left++;
                } else if(currentSum > target) {
                    // Sum too large, need smaller numbers
                    right--;
                } else {
                    // Exact match found!
                    return target;
                }
            }
        }
        return closestSum;
    }
}
