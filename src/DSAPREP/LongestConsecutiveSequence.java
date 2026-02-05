package DSAPREP;
import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String[] args)  {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int consecutiveCount = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) {
                continue;
            } else if (diff == 1) {
                consecutiveCount++;
            } else {
                maxCount = Math.max(maxCount, consecutiveCount);
                consecutiveCount = 1;
            }
        }
        return Math.max(maxCount, consecutiveCount);
    }
}
