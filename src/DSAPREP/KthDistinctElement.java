package DSAPREP;
import java.util.*;

/**
 * Problem: Kth Distinct Element
 * 
 * Problem Statement:
 * Given an array of integers arr and an integer k, return the k-th distinct element 
 * in the array. If there are fewer than k distinct elements, return -1.
 * 
 * Example:
 * Input: arr = [1,2,1,2,3,4], k = 2
 * Output: 3
 * Explanation: Distinct elements are [1,2,3,4]. The 2nd distinct element is 3.
 * 
 * Approach:
 * Use LinkedHashMap to preserve insertion order and count frequencies.
 * Find k-th element with frequency 1.
 * 
 * Algorithm:
 * 1. Count frequency of each element using LinkedHashMap (preserves order)
 * 2. Iterate through map entries:
 *    - If frequency == 1: increment distinct count
 *    - If distinct count == k: return element
 * 3. If k-th distinct not found, return -1
 * 
 * Why LinkedHashMap?
 * - Preserves insertion order (first occurrence order)
 * - Allows us to find k-th distinct element in original order
 * 
 * Example walkthrough:
 * arr = [1,2,1,2,3,4]
 * Map: {1:2, 2:2, 3:1, 4:1}
 * Entry 1: freq=2, skip
 * Entry 2: freq=2, skip
 * Entry 3: freq=1, count=1, not k
 * Entry 4: freq=1, count=2, count==k, return 3 ✓
 * 
 * Time Complexity: O(n) - two passes through array
 * Space Complexity: O(n) - LinkedHashMap stores all elements
 */
public class KthDistinctElement {
    public static void main(String [] args) {
        int [] arr = {1,2,1,2,3,4};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    /**
     * Finds the k-th distinct element in array
     * 
     * @param arr Array of integers
     * @param k Position of distinct element (1-indexed)
     * @return K-th distinct element, or -1 if not found
     */
    public static int kthDistinct(int[] arr, int k) {
        // Use LinkedHashMap to preserve insertion order
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        // Count frequency of each element
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Find k-th distinct element (frequency == 1)
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                // Found a distinct element
                count++;
                if(count == k) {
                    // Found k-th distinct element!
                    return entry.getKey();
                }
            }
        }
        
        // K-th distinct element not found
        return -1;
    }
}
