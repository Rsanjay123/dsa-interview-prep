package DSAPREP.BINARYSEARCHPROBLEMS;
import java.util.*;

/**
 * Problem: Monotonic Array
 * 
 * Problem Statement:
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * 
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
 * An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 * 
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 * 
 * Example:
 * Input: nums = [1,3,2,4]
 * Output: false
 * Explanation: Array is neither increasing nor decreasing.
 * 
 * Input: nums = [1,2,2,3]
 * Output: true
 * Explanation: Array is monotone increasing.
 * 
 * Approach:
 * Track both increasing and decreasing flags. If we see a decrease, mark inc=false.
 * If we see an increase, mark dec=false. Array is monotonic if either flag remains true.
 * 
 * Algorithm:
 * 1. Initialize inc=true (assume increasing), dec=true (assume decreasing)
 * 2. For each adjacent pair:
 *    - If nums[i] < nums[i-1]: not increasing, set inc=false
 *    - If nums[i] > nums[i-1]: not decreasing, set dec=false
 * 3. Return true if either inc or dec is true
 * 
 * Key insight:
 * - We check both possibilities simultaneously
 * - If array has both increases and decreases, both flags become false
 * - If array is constant, both flags remain true (valid)
 * 
 * Example walkthrough:
 * nums = [1,3,2,4]
 * i=1: nums[1]=3 > nums[0]=1, dec=false, inc=true
 * i=2: nums[2]=2 < nums[1]=3, inc=false, dec=false
 * Result: inc=false, dec=false -> false ✓
 * 
 * nums = [1,2,2,3]
 * i=1: nums[1]=2 > nums[0]=1, dec=false, inc=true
 * i=2: nums[2]=2 == nums[1]=2, no change
 * i=3: nums[3]=3 > nums[2]=2, dec=false, inc=true
 * Result: inc=true -> true ✓
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - only using constant extra space
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        System.out.println(isMonotonic(nums));
    }
    
    /**
     * Checks if array is monotonic (either increasing or decreasing)
     * 
     * @param nums Array to check
     * @return true if monotonic, false otherwise
     */
    public static boolean isMonotonic(int[] nums) {
        // Track if array could be increasing or decreasing
        boolean inc = true;  // Assume increasing
        boolean dec = true;  // Assume decreasing
        
        // Check each adjacent pair
        for(int i = 1; i <= nums.length - 1; i++) {
            if(nums[i] < nums[i - 1]){
                // Found a decrease, not monotone increasing
                inc = false;
            } else if(nums[i] > nums[i - 1]) {
                // Found an increase, not monotone decreasing
                dec = false;
            }
            // If nums[i] == nums[i-1], both flags remain unchanged
        }
        
        // Array is monotonic if either increasing or decreasing
        return inc || dec;
    }
}
