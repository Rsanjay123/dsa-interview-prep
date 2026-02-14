package DSAPREP;
import java.util.*;

/**
 * Problem: 3Sum
 * 
 * Problem Statement:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Approach:
 * Use sorting + two-pointer technique. Fix one number, then use two pointers 
 * to find pairs that sum to the negative of that number.
 * 
 * Algorithm:
 * 1. Sort the array (enables two-pointer technique and duplicate skipping)
 * 2. For each index i from 0 to n-3:
 *    - Skip duplicates: if nums[i] == nums[i-1], continue
 *    - Use two pointers: left = i+1, right = n-1
 *    - While left < right:
 *      * Calculate sum = nums[i] + nums[left] + nums[right]
 *      * If sum == 0: add triplet, skip duplicates, move both pointers
 *      * If sum < 0: move left pointer right (need larger sum)
 *      * If sum > 0: move right pointer left (need smaller sum)
 * 3. Return all unique triplets
 * 
 * Why sorting?
 * - Enables two-pointer technique
 * - Makes duplicate detection easy (check adjacent elements)
 * - Allows us to skip duplicates efficiently
 * 
 * Duplicate handling:
 * - For fixed number: skip if same as previous
 * - For left pointer: skip all duplicates after finding a match
 * - For right pointer: skip all duplicates after finding a match
 * 
 * Example walkthrough:
 * nums = [-1,0,1,2,-1,-4], sorted = [-4,-1,-1,0,1,2]
 * i=0: nums[i]=-4, need sum=4, left=1, right=5
 *   sum = -4 + -1 + 2 = -3 < 0, left++
 *   sum = -4 + -1 + 2 = -3 < 0, left++
 *   ... no solution
 * i=1: nums[i]=-1, need sum=1, left=2, right=5
 *   sum = -1 + -1 + 2 = 0 ✓, add [-1,-1,2]
 *   sum = -1 + 0 + 1 = 0 ✓, add [-1,0,1]
 * 
 * Time Complexity: O(n²) - outer loop O(n), two-pointer O(n)
 * Space Complexity: O(1) excluding output array (O(k) where k is number of triplets)
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    /**
     * Finds all unique triplets that sum to zero
     * 
     * @param nums Array of integers
     * @return List of all unique triplets that sum to zero
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort array to enable two-pointer technique and duplicate skipping
        Arrays.sort(nums);
        
        // Fix first number, then use two pointers for remaining two
        for(int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for fixed number
            // If current number is same as previous, we've already considered all triplets with it
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            
            // Two pointers: left starts after i, right starts at end
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0){
                    // Found a valid triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip all duplicates of left pointer
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    // Skip all duplicates of right pointer
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    // Move both pointers after processing duplicates
                    left++;
                    right--;
                } else if(sum < 0){
                    // Sum is too small, need larger numbers - move left pointer right
                    left++;
                } else {
                    // Sum is too large, need smaller numbers - move right pointer left
                    right--;
                }
            }
        }
        return result;
    }
}
