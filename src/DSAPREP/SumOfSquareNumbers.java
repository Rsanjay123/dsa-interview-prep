package DSAPREP;

public class SumOfSquareNumbers {

  public static void main(String[] args) {
    double num = 5;
    System.out.println(sumSquareNumbers(num));
  }

  public static boolean sumSquareNumbers(double num) {
    long left = 0;
    long right = (long)Math.sqrt(num);
    while(left <= right) {
      long sum = left * left + right * right;
      if(sum == num) {
        return true;
      } else if(sum < num) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }
}
