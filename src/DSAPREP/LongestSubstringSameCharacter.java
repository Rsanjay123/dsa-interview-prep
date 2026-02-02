package DSAPREP;
import java.util.*;
public class LongestSubstringSameCharacter {
    public static void main(String[] args) {
        String s = "aaabbccddeee";
        System.out.println(longestSubstring(s));
        System.out.println(longestSubstring2(s));
    }

    public static int longestSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                currentLength++;
            } else {
                maxLength = Math.max(currentLength, maxLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(currentLength, maxLength);
        return maxLength;
    }

    public static int longestSubstring2(String s) {
        int maxLength = 1;
        int currentLength = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}
