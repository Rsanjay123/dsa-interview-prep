package DSAPREP.STACKPROBLEMS;
import java.util.*;

/**
 * Problem: Largest Rectangle in Histogram
 * 
 * Problem Statement:
 * Given an array of integers heights representing the histogram's bar height where 
 * the width of each bar is 1, return the area of the largest rectangle in the histogram.
 * 
 * Example:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The largest rectangle is formed by bars at indices 2 and 3 (heights 5 and 6).
 *              Area = 2 * 5 = 10
 * 
 * Approach:
 * Use stack to track bars in increasing order. When we see a bar shorter than stack top,
 * calculate area of rectangle ending at that bar.
 * 
 * Algorithm:
 * 1. Use stack to store indices of bars in increasing height order
 * 2. For each bar (including sentinel 0 at end):
 *    - While stack not empty and current height < height at stack top:
 *      * Pop bar from stack
 *      * Calculate area: height * width
 *      * Width = current index - stack top index - 1 (or current index if stack empty)
 *      * Update maxArea
 *    - Push current index to stack
 * 3. Return maxArea
 * 
 * Key insight:
 * - When we pop a bar, we know all bars between stack top and current are >= popped bar
 * - Width extends from stack top + 1 to current - 1
 * - Sentinel 0 at end ensures all bars are processed
 * 
 * Example walkthrough:
 * heights = [2,1,5,6,2,3]
 * i=0: h=2, stack=[], push 0, stack=[0]
 * i=1: h=1 < h[0]=2, pop 0, area=2*1=2, maxArea=2, push 1, stack=[1]
 * i=2: h=5 > h[1]=1, push 2, stack=[1,2]
 * i=3: h=6 > h[2]=5, push 3, stack=[1,2,3]
 * i=4: h=2 < h[3]=6, pop 3, area=6*1=6, maxArea=6
 *       h=2 < h[2]=5, pop 2, area=5*2=10, maxArea=10
 *       h=2 > h[1]=1, push 4, stack=[1,4]
 * i=5: h=3 > h[4]=2, push 5, stack=[1,4,5]
 * i=6: h=0 (sentinel), pop all:
 *       pop 5: area=3*1=3
 *       pop 4: area=2*4=8
 *       pop 1: area=1*6=6
 * Result: maxArea=10 ✓
 * 
 * Time Complexity: O(n) - each bar pushed and popped once
 * Space Complexity: O(n) for the stack
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int [] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * Finds the area of largest rectangle in histogram
     * 
     * @param heights Array of bar heights
     * @return Area of largest rectangle
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        // Process each bar, including sentinel 0 at the end
        for(int i = 0; i <= heights.length; i++) {
            // Use 0 as sentinel at the end to process all remaining bars
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            
            // While current bar is shorter than bar at stack top
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // Pop bar and calculate area of rectangle ending at this bar
                int height = heights[stack.pop()];
                
                // Calculate width
                // If stack empty: width extends from start to current index
                // Otherwise: width extends from (stack top + 1) to (current - 1)
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                // Update maximum area
                maxArea = Math.max(maxArea, height * width);
            }
            
            // Push current index to stack
            stack.push(i);
        }
        return maxArea;
    }
}
