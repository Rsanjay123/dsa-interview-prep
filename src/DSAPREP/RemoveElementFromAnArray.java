package DSAPREP;
import java.util.*;

/**
 * Problem: Remove Element
 * 
 * Problem Statement:
 * Given an integer array nums and an integer val, remove all occurrences of val in-place. 
 * The order of the elements may be changed. Then return the number of elements in nums 
 * which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, 
 * you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain the elements 
 *   which are not equal to val.
 * - Return k.
 * 
 * Example:
 * Input: nums = [3,2,2,3,4], val = 3
 * Output: 3, nums = [2,2,4,_,_]
 * Explanation: Your function should return k = 3, with the first three elements of nums 
 *              being 2, 2, and 4. The elements beyond k don't matter.
 * 
 * Approach:
 * Two-pointer technique: use one pointer to iterate, another to track position 
 * for valid elements.
 * 
 * Algorithm:
 * 1. Use pointer x to track next position for valid element
 * 2. Iterate through array with pointer i:
 *    - If nums[i] != val: copy to nums[x], increment x
 *    - If nums[i] == val: skip (don't copy)
 * 3. First x elements contain all valid elements
 * 4. Return x (or set remaining to 0 if needed)
 * 
 * Key insight:
 * - We overwrite array from left to right
 * - x always points to next position for valid element
 * - Elements at positions >= x don't matter
 * 
 * Example walkthrough:
 * nums = [3,2,2,3,4], val = 3
 * i=0: nums[0]=3 == val, skip, x=0
 * i=1: nums[1]=2 != val, nums[0]=2, x=1
 * i=2: nums[2]=2 != val, nums[1]=2, x=2
 * i=3: nums[3]=3 == val, skip, x=2
 * i=4: nums[4]=4 != val, nums[2]=4, x=3
 * Result: [2,2,4,3,4], first 3 elements are valid
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - in-place modification
 */
public class RemoveElementFromAnArray {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4};
        int val = 3;
        System.out.println(Arrays.toString(removeElement(arr, val)));
    }

    /**
     * Removes all occurrences of val from array in-place
     * 
     * @param nums Array to modify
     * @param val Value to remove
     * @return Modified array (first k elements are valid)
     */
    public static int[] removeElement(int[] nums, int val) {
        int n = nums.length;
        int x = 0;  // Pointer for next valid element position
        
        // Copy valid elements to front of array
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                // Valid element: copy to position x
                nums[x] = nums[i];
                x++;
            }
            // If nums[i] == val, skip it (don't copy)
        }
        
        // Optional: set remaining elements to 0 (not required by problem)
        for(int i = x; i < n; i++){
            nums[i] = 0;
        }
        
        return nums;
    }
}
