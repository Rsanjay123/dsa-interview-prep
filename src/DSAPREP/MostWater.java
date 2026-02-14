package DSAPREP;
import java.util.*;

/**
 * Problem: Container With Most Water
 * 
 * Problem Statement:
 * You are given an integer array height of length n. There are n vertical lines drawn 
 * such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the container 
 * contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The max area is between indices 1 and 8: 
 *              width = 8-1 = 7, height = min(8,7) = 7, area = 7*7 = 49
 * 
 * Approach:
 * Use two-pointer technique starting from both ends.
 * The key insight: always move the pointer with the smaller height.
 * 
 * Algorithm:
 * 1. Initialize left = 0, right = n-1
 * 2. While left < right:
 *    - Calculate area: width * min(height[left], height[right])
 *    - Update maxArea
 *    - Move the pointer with smaller height inward
 *      * If height[left] < height[right]: left++
 *      * Else: right--
 * 
 * Why move the smaller height pointer?
 * - Area = width * min(height[left], height[right])
 * - If we move the larger height pointer, width decreases but height stays same (limited by smaller)
 * - If we move the smaller height pointer, width decreases but height might increase
 * - We want to maximize area, so we move the smaller one hoping to find a taller line
 * 
 * Proof of correctness:
 * - At each step, we're eliminating configurations that can't be optimal
 * - If height[left] < height[right], all containers with left and any j < right 
 *   have area <= current area (same or smaller height, smaller width)
 * - So we can safely eliminate left and move it forward
 * 
 * Example walkthrough:
 * height = [1,8,6,2,5,4,8,3,7]
 * left=0, right=8: area = 8*min(1,7) = 8, maxArea=8, move left (1<7)
 * left=1, right=8: area = 7*min(8,7) = 49, maxArea=49, move right (8>7)
 * left=1, right=7: area = 6*min(8,3) = 18, maxArea=49, move right
 * ... continue until left >= right
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - only using constant extra space
 */
public class MostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(mostWater(arr));
    }

    /**
     * Finds the maximum area of water that can be contained
     * 
     * @param arr Array representing heights of vertical lines
     * @return Maximum area of water that can be contained
     */
    public static int mostWater(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        
        while(left < right){
            // Calculate width between two lines
            int width = right - left;
            
            // Height is limited by the shorter line (water would overflow)
            int height = Math.min(arr[left], arr[right]);
            
            // Calculate area
            int area = width * height;
            
            // Update maximum area seen so far
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer with smaller height
            // This is the key insight: we want to potentially find a taller line
            if(arr[left] < arr[right]){
                // Left line is shorter, move left pointer right
                left++;
            } else {
                // Right line is shorter or equal, move right pointer left
                right--;
            }
        }
        return maxArea;
    }
}
