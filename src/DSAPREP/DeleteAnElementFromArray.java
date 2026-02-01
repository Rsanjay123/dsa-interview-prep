package DSAPREP;
import java.util.*;
public class DeleteAnElementFromArray {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4};
        int val = 3;
        System.out.println(Arrays.toString(removeElement(arr, val)));
    }

    public static int[] removeElement(int[] nums, int targetIndex) {
        int n = nums.length;
        for(int i = targetIndex; i < n - 1; i++){
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = 0;
        return nums;
    }
}
