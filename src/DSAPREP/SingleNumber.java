package DSAPREP;
import java.util.*;
public class SingleNumber {
    public static void main(String[] args){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberXoR(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.replace(num, map.get(num) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int singleNumberXoR(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result ^= num;
        }
        return result;
    }
}
