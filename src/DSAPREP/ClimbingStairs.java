package DSAPREP;

public class ClimbingStairs {
  public static void main(String[] args) {
    int n = 5;
    System.out.println(climbStairs(n));
  }

  private static int climbStairs(int n) {
    if(n <= 2) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  private static int climbStairsOptmised(int n) {
    if(n <= 2) {
      return n;
    }
    int prev2 = 1;
    int prev1 = 2;
    for(int i = 3; i <=n; i++) {
      int current = prev1 + prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return prev1;
  }
}
