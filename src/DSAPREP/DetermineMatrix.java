package DSAPREP;

public class DetermineMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] target = {
        {7, 4, 1},
        {8, 5, 2},
        {9, 6, 3}
    };
    boolean result = determineMatrix(matrix, target);
    System.out.println(result);
  }

  private static boolean determineMatrix(int[][] mat, int[][] target) {
    for(int i = 1; i <= 4; i++) {
      if(areEqual(mat, target)) {
        return true;
      }
      rotate(mat);
    }
    return false;
  }

  private static void rotate(int[][] matrix) {
    int n = matrix.length;
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for(int i = 0; i < n; i++) {
      int left = 0;
      int right = n - 1;
      while(left < right) {
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;
        left++;
        right--;
      }
    }
  }

  private static boolean areEqual(int[][] mat, int[][] target) {
    for(int i = 0; i < mat.length; i++) {
      for(int j = 0; j < target.length; j++) {
        if(mat[i][j] != target[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
