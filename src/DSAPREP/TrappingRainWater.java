package DSAPREP;
import java.util.*;

/**
 * Problem: Trapping Rain Water
 * 
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the width of each bar 
 * is 1, compute how much water it can trap after raining.
 * 
 * Example:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 *              In this case, 6 units of rain water are being trapped.
 * 
 * Approach:
 * Two-pointer technique with tracking of maximum heights from both sides.
 * 
 * Algorithm:
 * 1. Use two pointers: left at start, right at end
 * 2. Track leftMax (max height seen from left) and rightMax (max height seen from right)
 * 3. Process the side with smaller height:
 *    - If current height >= max: update max (no water trapped)
 *    - Else: water trapped = max - current height
 * 4. Move pointer inward
 * 
 * Key Insight:
 * - Water trapped at position i = min(leftMax, rightMax) - height[i]
 * - We process the smaller side because we know the water level is limited by that side
 * - If height[left] < height[right], water at left is limited by leftMax (not rightMax)
 * 
 * Why process smaller side?
 * - If height[left] < height[right], we know rightMax >= height[right] >= height[left]
 * - So water at left is limited by leftMax, not rightMax
 * - We can safely calculate water at left and move left pointer
 * 
 * Example walkthrough:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * left=0, right=11: height[0]=0 < height[11]=1
 *   leftMax=0, height[0]=0 >= leftMax, update leftMax=0, left=1
 * left=1, right=11: height[1]=1 > height[11]=1
 *   rightMax=0, height[11]=1 >= rightMax, update rightMax=1, right=10
 * left=1, right=10: height[1]=1 < height[10]=2
 *   leftMax=0, height[1]=1 > leftMax, update leftMax=1, left=2
 * left=2, right=10: height[2]=0 < height[10]=2
 *   leftMax=1, height[2]=0 < leftMax, water += 1-0 = 1, left=3
 * ... continue
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - only using constant extra space
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    
    /**
     * Calculates the amount of water that can be trapped
     * 
     * @param height Array representing elevation map
     * @return Total units of water trapped
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;   // Maximum height seen from left side
        int rightMax = 0;   // Maximum height seen from right side
        int water = 0;
        
        while(left < right) {
            // Process the side with smaller height
            if(height[left] < height[right]) {
                // Process left side
                if(height[left] >= leftMax){
                    // Current height is new maximum, no water trapped here
                    leftMax = height[left];
                } else {
                    // Water trapped = difference between max and current height
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Process right side
                if(height[right] >= rightMax) {
                    // Current height is new maximum, no water trapped here
                    rightMax = height[right];
                } else {
                    // Water trapped = difference between max and current height
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
