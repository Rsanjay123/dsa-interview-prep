package DSAPREP;

public class WordSearch {
  public static void main(String[] args) {
    char[][] board = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
    };
    String word = "ABCCED";
    System.out.println(exist(board, word));
  }

  private static boolean exist(char[][] board, String word) {
    int count = 1;
    int n = board.length;
    for(int i = 0; i < n; i++) {
      int left = 0;
      int right = n - 1;
      char currentChar = word.charAt(i);
      while(left < right) {
        if(currentChar == board[i][left] || currentChar == board[i][right]) {
          count++;
        }
        left++;
        right--;
      }
    }

    if(count == word.length()) {
      return true;
    }
    return false;
  }
}
