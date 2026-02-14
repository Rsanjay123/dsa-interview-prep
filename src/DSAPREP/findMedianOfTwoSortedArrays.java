package DSAPREP;
import java.util.*;

/**
 * Problem: Median of Two Sorted Arrays
 * 
 * Problem Statement:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Example:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.0
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.5
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * Approach:
 * Binary search on the smaller array to find the correct partition.
 * 
 * Algorithm:
 * 1. Ensure nums1 is the smaller array (swap if needed)
 * 2. Binary search on cut position in nums1:
 *    - cut1: elements before cut in nums1
 *    - cut2: elements before cut in nums2 (calculated to split total in half)
 * 3. Check if partition is valid:
 *    - leftA <= rightB and leftB <= rightA
 * 4. If valid: calculate median based on odd/even total length
 * 5. If not valid: adjust binary search bounds
 * 
 * Key insight:
 * - We want to partition both arrays such that:
 *   * Left half has (m+n+1)/2 elements
 *   * All elements in left half <= all elements in right half
 * - Binary search finds this partition efficiently
 * 
 * Partition validity:
 * - leftA: max of left half of nums1
 * - rightA: min of right half of nums1
 * - leftB: max of left half of nums2
 * - rightB: min of right half of nums2
 * - Valid if: leftA <= rightB AND leftB <= rightA
 * 
 * Example walkthrough:
 * nums1 = [1,3], nums2 = [2], m=2, n=1
 * low=0, high=2
 * cut1=1, cut2=(2+1+1)/2-1=1
 * leftA=nums1[0]=1, rightA=nums1[1]=3
 * leftB=nums2[0]=2, rightB=MAX
 * Check: 1<=MAX ✓, 2<=3 ✓
 * Total odd: median = max(1,2) = 2 ✓
 * 
 * Time Complexity: O(log(min(m,n))) - binary search on smaller array
 * Space Complexity: O(1) - only using constant extra space
 */
public class findMedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * Finds the median of two sorted arrays
     * 
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return Median of the two arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficiency
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        
        // Binary search on cut position in nums1
        while(low <= high) {
            // cut1: number of elements in left half from nums1
            int cut1 = (low + high) / 2;
            // cut2: number of elements in left half from nums2
            // Total left half should have (m+n+1)/2 elements
            int cut2 = (m + n + 1)/2 - cut1;
            
            // Get boundary values
            // leftA: max element in left half of nums1
            int leftA = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            // rightA: min element in right half of nums1
            int rightA = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            // leftB: max element in left half of nums2
            int leftB = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            // rightB: min element in right half of nums2
            int rightB = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
            
            // Check if partition is valid
            // All left elements should be <= all right elements
            if(leftA <= rightB && leftB <= rightA){
                // Valid partition found!
                if((m + n) % 2 == 0) {
                    // Even total length: median is average of two middle elements
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    // Odd total length: median is the middle element
                    return Math.max(leftA, leftB);
                }
            }
            
            // Adjust binary search bounds
            if(leftA > rightB) {
                // Too many elements from nums1 in left half, reduce cut1
                high = cut1 - 1;
            } else {
                // Too few elements from nums1 in left half, increase cut1
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
