package DSAPREP;
import java.util.*;

/**
 * Problem: 4Sum
 * 
 * Problem Statement:
 * Given an array nums of n integers, return an array of all the unique quadruplets 
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * - 0 <= a, b, c, d < n
 * - a, b, c, and d are distinct
 * - nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * Example:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * Approach:
 * Extend 3Sum approach: fix two numbers, use two pointers for remaining two.
 * 
 * Algorithm:
 * 1. Sort the array
 * 2. Fix first number at index i:
 *    - Skip duplicates for i
 * 3. Fix second number at index j (j > i):
 *    - Skip duplicates for j
 * 4. Use two pointers (left, right) for remaining two numbers:
 *    - Calculate sum of four numbers
 *    - If sum == target: add to result, skip duplicates, move pointers
 *    - If sum < target: move left right
 *    - If sum > target: move right left
 * 
 * Duplicate handling:
 * - For i: skip if nums[i] == nums[i-1]
 * - For j: skip if nums[j] == nums[j-1] (only if j > i+1)
 * - For left: skip if nums[left] == nums[left-1] (after incrementing)
 * - For right: skip if nums[right] == nums[right+1] (after decrementing)
 * 
 * Example walkthrough:
 * nums = [1,0,-1,0,-2,2], target = 0, sorted = [-2,-1,0,0,1,2]
 * i=0: nums[i]=-2, j=1: nums[j]=-1, left=2, right=5
 *   sum = -2 + -1 + 0 + 2 = -1 < 0, left=3
 *   sum = -2 + -1 + 0 + 2 = -1 < 0, left=4
 *   sum = -2 + -1 + 1 + 2 = 0 ✓, add [-2,-1,1,2]
 * ... continue
 * 
 * Time Complexity: O(n³) - two nested loops + two-pointer O(n)
 * Space Complexity: O(1) excluding output array
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    /**
     * Finds all unique quadruplets that sum to target
     * 
     * @param nums Array of integers
     * @param target Target sum
     * @return List of all unique quadruplets summing to target
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        // Need at least 4 elements
        if(n < 4){
            return result;
        }
        
        // Fix first number
        for(int i = 0; i < n - 3; i++){
            // Skip duplicates for first number
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            
            // Fix second number
            for(int j = i + 1; j < n - 2; j++){
                // Skip duplicates for second number
                // Note: j > i+1 ensures we don't skip the first j for this i
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                
                // Two pointers for remaining two numbers
                int left = j + 1;
                int right = n - 1;
                
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if(sum == target){
                        // Found a valid quadruplet!
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Move pointers and skip duplicates
                        left++;
                        right--;
                        
                        // Skip duplicate values for left pointer
                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        // Skip duplicate values for right pointer
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    } else if(sum < target) {
                        // Sum too small, need larger numbers
                        left++;
                    } else {
                        // Sum too large, need smaller numbers
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
