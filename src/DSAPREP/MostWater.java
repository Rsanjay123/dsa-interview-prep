package DSAPREP;
import java.util.*;
public class MostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(mostWater(arr));
    }

    public static int mostWater(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);
            if(arr[left] < arr[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
