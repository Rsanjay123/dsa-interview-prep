package DSAPREP.DynamicPrograming;
import java.util.*;
public class CombinationCount {
    public static void main(String[] args) {
        int n = 5;
        int k = 7;
        int[] arr = {1,2,3,4,5};
        System.out.println(countCombinations(arr, n, k));
    }

    public static int countCombinations(int[] arr, int n, int k) {
        int Mod = 1000000007;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for(int num : arr) {
            for(int sum = k; sum >= num; sum--) {
                dp[sum] = (dp[sum] + dp[sum-num]) % Mod;
            }
        }
        return dp[k];
    }
}
