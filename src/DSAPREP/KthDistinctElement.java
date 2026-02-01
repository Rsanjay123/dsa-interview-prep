package DSAPREP;
import java.util.*;
public class KthDistinctElement {
    public static void main(String [] args) {
        int [] arr = {1,2,1,2,3,4};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static int kthDistinct(int[] arr, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                count++;
                if(count == k) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}
