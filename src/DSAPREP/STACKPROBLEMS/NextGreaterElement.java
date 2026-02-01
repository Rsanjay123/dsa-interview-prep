package DSAPREP.STACKPROBLEMS;
import java.util.*;
public class NextGreaterElement {
    public static void main(String[] args) {
        int [] arr = {4,5,2,25};
        int [] result = nextGreaterElement(arr);
        int [] result2 = nextGreaterElement2(arr);
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result));
    }
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return result;
    }

    public static int[] nextGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i= n-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
