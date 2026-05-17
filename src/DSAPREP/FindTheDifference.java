package DSAPREP;

public class FindTheDifference {
  public static void main(String[] args) {
    String s = "abcd";
    String t = "abcde";
    System.out.println(findTheDifference(s, t));
  }

  private static String findTheDifference(String s, String t) {
    String result  = s.concat(t);
    String ans = "";
    for(char ch : result.toCharArray()) {
      int count = 0;
      for(char c : result.toCharArray()) {
        if(ch == c) {
          count++;
        }
      }
      if(count % 2 != 0) {
        ans = String.valueOf(ch);
        break;
      }
    }
    return ans;
  }

  private static char findTheDifferenceOptimised(String s, String t) {
    String result  = s.concat(t);
    int ans = 0;
    for(char ch : result.toCharArray()) {
      ans ^= ch;
    }
    return (char)ans;
  }
}
