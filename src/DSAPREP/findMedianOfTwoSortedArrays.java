package DSAPREP;
import java.util.*;
public class findMedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        while(low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1)/2 - cut1;
            int leftA = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int leftB = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int rightA = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int rightB = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
            if(leftA <= rightB && leftB <= rightA){
                if((m + n) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    return Math.max(leftA, leftB);
                }
            }
            if(leftA > rightB) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
