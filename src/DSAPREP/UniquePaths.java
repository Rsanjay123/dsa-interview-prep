package DSAPREP;
import java.util.*;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] NOW = new int[m][n];
        for(int i = 0; i < m; i++) {
          for(int j = 0; j < n; j++) {
            if(i == 0 || j == 0) {
              NOW[i][j] = 1;
            } else {
              NOW[i][j] = NOW[i - 1][j] + NOW[i][j - 1];
            }
          }
        }
        return NOW[m - 1][n - 1];
    }
}
