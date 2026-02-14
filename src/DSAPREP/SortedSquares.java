package DSAPREP;
import java.util.*;

/**
 * Problem: Squares of a Sorted Array
 * 
 * Problem Statement:
 * Given an integer array nums sorted in non-decreasing order, return an array of 
 * the squares of each number sorted in non-decreasing order.
 * 
 * Example:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 *              After sorting, it becomes [0,1,9,16,100].
 * 
 * Approach:
 * Use two-pointer technique starting from both ends.
 * Since array is sorted, largest squares will be at the ends.
 * Fill result array from right to left (largest to smallest).
 * 
 * Algorithm:
 * 1. Create result array
 * 2. Use two pointers: left at start, right at end
 * 3. Fill result from right to left (largest squares first):
 *    - Compare absolute values: abs(nums[left]) vs abs(nums[right])
 *    - Square the larger absolute value and place at end of result
 *    - Move the pointer with larger absolute value
 * 4. Return result
 * 
 * Why fill from right to left?
 * - We know largest squares are at the ends
 * - By comparing absolute values, we find the largest square
 * - Fill result array backwards to get sorted order
 * 
 * Example walkthrough:
 * nums = [-4,-1,0,3,10]
 * i=4: abs(-4)=4 < abs(10)=10, result[4]=100, right=3
 * i=3: abs(-4)=4 > abs(3)=3, result[3]=16, left=1
 * i=2: abs(-1)=1 < abs(3)=3, result[2]=9, right=2
 * i=1: abs(-1)=1 < abs(0)=0, result[1]=1, left=2
 * i=0: abs(0)=0, result[0]=0
 * Result: [0,1,9,16,100] ✓
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - result array
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    /**
     * Returns squares of array elements in sorted order
     * 
     * @param nums Sorted array of integers
     * @return Array of squares in sorted order
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        
        // Fill result from right to left (largest squares first)
        for(int i = n - 1; i >= 0; i--){
            // Compare absolute values to find larger square
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                // Right element has larger absolute value
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                // Left element has larger or equal absolute value
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        
        // Alternative approach: square all then sort (O(n log n))
        // Arrays.sort(result);
        return result;
    }
}
