package DSAPREP;
import java.util.*;

/**
 * Problem: Delete an Element from Array
 * 
 * Problem Statement:
 * Delete an element at a given index from an array by shifting all elements 
 * after it one position to the left.
 * 
 * Example:
 * Input: nums = [3,2,2,3,4], targetIndex = 0
 * Output: [2,2,3,4,0]
 * Explanation: Element at index 0 (value 3) is removed, all elements shifted left.
 * 
 * Approach:
 * Shift all elements after targetIndex one position to the left.
 * Set last element to 0 (or any sentinel value).
 * 
 * Algorithm:
 * 1. Starting from targetIndex, copy each element from next position
 * 2. Continue until second-to-last element
 * 3. Set last element to 0 (or sentinel value)
 * 
 * Example walkthrough:
 * nums = [3,2,2,3,4], targetIndex = 0
 * i=0: nums[0] = nums[1] = 2, array = [2,2,2,3,4]
 * i=1: nums[1] = nums[2] = 2, array = [2,2,2,3,4]
 * i=2: nums[2] = nums[3] = 3, array = [2,2,3,3,4]
 * i=3: nums[3] = nums[4] = 4, array = [2,2,3,4,4]
 * Set nums[4] = 0, array = [2,2,3,4,0] ✓
 * 
 * Time Complexity: O(n) - shift up to n elements
 * Space Complexity: O(1) - in-place modification
 */
public class DeleteAnElementFromArray {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4};
        int val = 3;
        System.out.println(Arrays.toString(removeElement(arr, val)));
    }

    /**
     * Removes element at targetIndex by shifting elements left
     * 
     * @param nums Array to modify
     * @param targetIndex Index of element to remove
     * @return Modified array
     */
    public static int[] removeElement(int[] nums, int targetIndex) {
        int n = nums.length;
        
        // Shift all elements after targetIndex one position to the left
        for(int i = targetIndex; i < n - 1; i++){
            nums[i] = nums[i + 1];
        }
        
        // Set last element to 0 (or sentinel value)
        nums[n - 1] = 0;
        
        return nums;
    }
}
