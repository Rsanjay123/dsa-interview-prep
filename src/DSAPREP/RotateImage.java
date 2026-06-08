package DSAPREP;

public class RotateImage {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] target = {{7,4,1},{8,5,2},{9,6,3}};
    boolean result = validRotate(matrix, target);
    System.out.println(result);
    rotate(matrix, target);
  }

  public static void rotate(int[][] matrix, int[][] target) {
    int n = matrix.length;
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for(int i = 0; i < n; i++){
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

  public static boolean validRotate(int[][] matrix, int[][] target) {
    for(int i = 0 ; i < 4; i++) {
      if(areEqual(matrix, target)) {
        return true;
      }
      rotate(matrix, target);
    }
    return false;
  }

  private static boolean areEqual(int[][] matrix, int[][] target) {
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix.length; j++) {
        if(matrix[i][j] != target[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
