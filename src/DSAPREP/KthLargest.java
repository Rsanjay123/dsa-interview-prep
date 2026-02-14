package DSAPREP;
import java.util.*;

/**
 * Problem: Kth Largest Element in an Array
 * 
 * Problem Statement:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * 
 * Example:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Explanation: Sorted array: [1,2,3,4,5,6]. The 2nd largest is 5.
 * 
 * Approach:
 * Use a min-heap of size k. Keep only the k largest elements.
 * Top of heap is the k-th largest.
 * 
 * Algorithm:
 * 1. Create min-heap (PriorityQueue)
 * 2. For each number:
 *    - Add to heap
 *    - If heap size > k: remove smallest (top of min-heap)
 * 3. Top of heap is k-th largest
 * 
 * Key insight:
 * - Min-heap of size k keeps k largest elements
 * - Smallest of these k is the k-th largest overall
 * - When we add a larger element, smallest gets removed
 * 
 * Example walkthrough:
 * nums = [3,2,1,5,6,4], k = 2
 * num=3: heap=[3], size=1<=2
 * num=2: heap=[2,3], size=2<=2
 * num=1: heap=[1,2,3], size=3>2, poll -> heap=[2,3]
 * num=5: heap=[2,3,5], size=3>2, poll -> heap=[3,5]
 * num=6: heap=[3,5,6], size=3>2, poll -> heap=[5,6]
 * num=4: heap=[4,5,6], size=3>2, poll -> heap=[5,6]
 * Result: peek() = 5 ✓
 * 
 * Time Complexity: O(n log k) - n insertions, each O(log k)
 * Space Complexity: O(k) - heap stores k elements
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }

    /**
     * Finds the k-th largest element using min-heap
     * 
     * @param nums Array of integers
     * @param k Position (1-indexed)
     * @return K-th largest element
     */
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap to keep k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num: nums) {
            // Add current number to heap
            minHeap.add(num);
            
            // Keep only k largest elements
            if(minHeap.size() > k){
                // Remove smallest element (top of min-heap)
                minHeap.poll();
            }
        }
        
        // Top of min-heap is the k-th largest element
        return minHeap.peek();
    }
}
