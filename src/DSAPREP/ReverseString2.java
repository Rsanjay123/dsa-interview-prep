package DSAPREP;

public class ReverseString2 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseString(s, k));
    }

  private static String reverseString(String s, int k) {
      if(s.isEmpty() || s.length() == 1) {
        return s;
      }
      char[] arr = s.toCharArray();
      for(int i = 0; i < arr.length; i += 2 * k) {
        int left = i;
        int right = Math.min(i + (k - 1), arr.length - 1);
        while(left < right) {
          char temp = arr[left];
          arr[left] = arr[right];
          arr[right] = temp;
          left++;
          right--;
        }
      }
      return new String(arr);
  }
}
