package DSAPREP;
import java.util.*;
public class RemoveElementFromAnArray {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3,4};
        int val = 3;
        System.out.println(Arrays.toString(removeElement(arr, val)));
    }

    public static int[] removeElement(int[] nums, int val) {
        int n = nums.length;
        int x = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                nums[x] = nums[i];
                x++;
            }
        }
        for(int i = x; i < n; i++){
            nums[i] = 0;
        }
        return nums;
    }
}
