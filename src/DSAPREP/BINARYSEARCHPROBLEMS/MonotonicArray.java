package DSAPREP.BINARYSEARCHPROBLEMS;
import java.util.*;
public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        System.out.println(isMonotonic(nums));
    }
    public static boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;
        for(int i = 1; i <= nums.length - 1; i++) {
            if(nums[i] < nums[i - 1]){
                inc = false;
            } else if(nums[i] > nums[i - 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
