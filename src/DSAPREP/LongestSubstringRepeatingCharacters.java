package DSAPREP;
import java.util.*;
public class LongestSubstringRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstring(s));
        System.out.println(longestSubString2(s));
        System.out.println(longestSubString3(s));
    }
    public static int longestSubstring(String chars) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while(right < chars.length()){
            char currentChar = chars.charAt(right);
            if(!set.contains(currentChar)){
                set.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(currentChar);
                left++;
            }
        }
        return maxLength;
    }
    public static int longestSubString2(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar)){
                left = Math.max(left, map.get(currentChar) + 1);
            }
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
    public static int longestSubString3(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar) && map.get(currentChar) >= left){
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
