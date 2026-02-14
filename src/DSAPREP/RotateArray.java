package DSAPREP;
import java.util.*;

/**
 * Problem: Rotate Array
 * 
 * Problem Statement:
 * Given an integer array nums, rotate the array to the right by k steps, 
 * where k is non-negative.
 * 
 * Example:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * Rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * Rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * Rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Approach:
 * Reverse the entire array, then reverse the first k elements, 
 * then reverse the remaining elements.
 * 
 * Algorithm:
 * 1. Handle k > n: k = k % n (rotating by n brings us back to original)
 * 2. Reverse entire array: [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
 * 3. Reverse first k elements: [7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
 * 4. Reverse remaining elements: [5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
 * 
 * Why this works:
 * - Original: [1,2,3,4,5,6,7], k=3
 * - After full reverse: [7,6,5,4,3,2,1]
 * - After reverse first k: [5,6,7,4,3,2,1]
 * - After reverse rest: [5,6,7,1,2,3,4] ✓
 * 
 * Example walkthrough:
 * nums = [1,2,3,4,5,6,7], k = 3
 * Step 1: Reverse all -> [7,6,5,4,3,2,1]
 * Step 2: Reverse first 3 -> [5,6,7,4,3,2,1]
 * Step 3: Reverse last 4 -> [5,6,7,1,2,3,4] ✓
 * 
 * Time Complexity: O(n) - three passes through array
 * Space Complexity: O(1) - only using constant extra space
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Rotates array to the right by k positions
     * 
     * @param nums Array to rotate
     * @param k Number of positions to rotate right
     */
    public static void rotate(int [] nums, int k){
        int n = nums.length;
        
        // Handle case where k >= n
        // Rotating by n brings us back to original, so k % n is effective rotation
        k = k % n;
        
        // Step 1: Reverse entire array
        finalrotate(nums, 0, n-1);
        
        // Step 2: Reverse first k elements
        finalrotate(nums, 0, k - 1);
        
        // Step 3: Reverse remaining elements
        finalrotate(nums, k, n - 1);
    }
    
    /**
     * Helper method to reverse array between left and right indices (inclusive)
     * 
     * @param nums Array to reverse
     * @param left Start index
     * @param right End index
     */
    private static void finalrotate(int[] nums, int left, int right){
        while(left < right){
            // Swap elements at left and right
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
