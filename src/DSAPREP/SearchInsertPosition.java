package DSAPREP;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem: Search Insert Position
 * 
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the index if the 
 * target is found. If not, return the index where it would be if it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Explanation: 2 is not in array, but would be inserted at index 1.
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Explanation: 5 is found at index 2.
 * 
 * This file contains two approaches:
 * 1. Binary Search (O(log n)) - Optimal
 * 2. Linear Search with Streams (O(n)) - Not optimal but simpler
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert2(nums, target));
        System.out.println(searchInsert(nums, target));
    }

    /**
     * Approach 1: Binary Search (Optimal)
     * 
     * Algorithm:
     * 1. Use binary search to find target or insertion position
     * 2. If target found, return its index
     * 3. If not found, when loop ends, left will be the insertion position
     * 
     * Why does left point to insertion position?
     * - When target not found, binary search narrows down to one position
     * - left always points to the first position where nums[left] >= target
     * - This is exactly where we should insert the target
     * 
     * Example walkthrough:
     * nums = [1,3,5,6], target = 2
     * left=0, right=3, mid=1: nums[1]=3 > 2, right=0
     * left=0, right=0, mid=0: nums[0]=1 < 2, left=1
     * left=1, right=0: loop ends
     * Return left=1 ✓ (2 should be inserted at index 1)
     * 
     * nums = [1,3,5,6], target = 5
     * left=0, right=3, mid=1: nums[1]=3 < 5, left=2
     * left=2, right=3, mid=2: nums[2]=5 == 5, return 2 ✓
     * 
     * Time Complexity: O(log n) - binary search
     * Space Complexity: O(1) - only using constant extra space
     * 
     * @param nums Sorted array of distinct integers
     * @param target Target value to search or insert
     * @return Index where target is found or should be inserted
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // Calculate middle index (avoid overflow)
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target) {
                // Target found!
                return mid;
            } else if(nums[mid] < target){
                // Target is in right half
                left = mid + 1;
            } else {
                // Target is in left half
                right = mid - 1;
            }
        }
        
        // Target not found - left points to insertion position
        // left is the first index where nums[left] >= target
        return left;
    }

    /**
     * Approach 2: Linear Search with Streams
     * 
     * Algorithm:
     * 1. Sort array (though it should already be sorted)
     * 2. Find first index where nums[i] >= target
     * 3. If no such index, return nums.length (insert at end)
     * 
     * Note: This approach is O(n) and doesn't meet the O(log n) requirement,
     * but it's simpler to understand.
     * 
     * How it works:
     * - IntStream.range(0, nums.length) creates stream of indices [0,1,2,...]
     * - filter(i -> nums[i] >= target) keeps only indices where element >= target
     * - findFirst() returns first such index
     * - orElse(nums.length) returns array length if no match (insert at end)
     * 
     * Time Complexity: O(n) - linear search
     * Space Complexity: O(1) excluding stream overhead
     * 
     * @param nums Sorted array of distinct integers
     * @param target Target value to search or insert
     * @return Index where target is found or should be inserted
     */
    public static int searchInsert2(int[] nums, int target) {
        // Ensure array is sorted (though it should already be)
        Arrays.sort(nums);
        
        // Find first index where element >= target
        // If not found, return array length (insert at end)
        return IntStream.range(0, nums.length)
                .filter(i -> nums[i] >= target)
                .findFirst()
                .orElse(nums.length);
    }
}
