package DSAPREP;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};
        int target = 10;
        int [] result = twosum(arr, target);
        int [] result2 = twoSum2(arr, target);
        System.out.println(result[0] + " " + result[1]);
        System.out.println(result2[0] + " " + result2[1]);
    }

    public static int[] twosum(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left, right};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum2(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int compliment = target - arr[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}