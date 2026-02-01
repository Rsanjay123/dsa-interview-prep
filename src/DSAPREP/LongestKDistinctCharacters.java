package DSAPREP;
import java.util.*;
public class LongestKDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(longestKDistinctCharacters(s, k));
        System.out.println(longestKDistinctCharacters2(s, k));
    }

    public static int longestKDistinctCharacters(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            while(map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int longestKDistinctCharacters2(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                    left++;
                }
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
