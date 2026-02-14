package DSAPREP.STACKPROBLEMS;
import java.util.*;

/**
 * Problem: Next Greater Element
 * 
 * Problem Statement:
 * Given an array, find the next greater element for each element.
 * The next greater element of an element is the first greater element to its right.
 * If no greater element exists, return -1.
 * 
 * Example:
 * Input: nums = [4,5,2,25]
 * Output: [5,25,25,-1]
 * Explanation:
 * - Next greater of 4 is 5
 * - Next greater of 5 is 25
 * - Next greater of 2 is 25
 * - Next greater of 25 is -1 (none)
 * 
 * Approach:
 * Use stack to track elements in decreasing order. Process from right to left.
 * 
 * Algorithm:
 * 1. Process array from right to left
 * 2. For each element:
 *    - Pop all elements from stack that are <= current element
 *    - Top of stack (if exists) is the next greater element
 *    - Push current element to stack
 * 
 * Why process right to left?
 * - We need to find greater elements to the right
 * - By going right to left, we've already processed right elements
 * - Stack maintains elements in decreasing order
 * 
 * How stack works:
 * - Stack contains elements we've seen to the right
 * - We remove smaller/equal elements (they won't be next greater for any left element)
 * - Remaining elements are potential next greater elements
 * 
 * Example walkthrough:
 * nums = [4,5,2,25]
 * i=3: nums[3]=25, stack=[], result[3]=-1, push 25, stack=[25]
 * i=2: nums[2]=2, stack=[25], 25>2, result[2]=25, push 2, stack=[25,2]
 * i=1: nums[1]=5, stack=[25,2], pop 2 (2<=5), 25>5, result[1]=25, push 5, stack=[25,5]
 * i=0: nums[0]=4, stack=[25,5], 5>4, result[0]=5, push 4, stack=[25,5,4]
 * Result: [5,25,25,-1] ✓
 * 
 * Time Complexity: O(n) - each element pushed and popped at most once
 * Space Complexity: O(n) for the stack
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int [] arr = {4,5,2,25};
        int [] result = nextGreaterElement(arr);
        int [] result2 = nextGreaterElement2(arr);
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result));
    }
    /**
     * Approach 1: Explicit if-else
     * 
     * Finds next greater element for each position
     * 
     * @param nums Input array
     * @return Array of next greater elements
     */
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Process from right to left
        for(int i = n - 1; i >= 0; i--){
            // Remove all elements <= current (they won't be next greater)
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            
            // Top of stack is next greater element (if exists)
            if(stack.isEmpty()){
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            
            // Push current element to stack
            stack.push(nums[i]);
        }
        return result;
    }

    /**
     * Approach 2: Ternary operator (more concise)
     * 
     * Same algorithm, more compact code
     * 
     * @param nums Input array
     * @return Array of next greater elements
     */
    public static int[] nextGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Process from right to left
        for(int i = n - 1; i >= 0; i--){
            // Remove all elements <= current
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            
            // Use ternary operator for cleaner code
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
