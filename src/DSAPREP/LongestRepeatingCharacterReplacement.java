package DSAPREP;
import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(longestRepeatingCharacterReplacement(s, k));
        System.out.println(longestRepeatingCharacterReplacement2(s, k));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLength = 0;
        for(right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);
            while ((right - left + 1) > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int longestRepeatingCharacterReplacement2(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLength = 0;
        while(right < s.length()) {
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);
            while((right - left + 1) > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
