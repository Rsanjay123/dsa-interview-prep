package DSAPREP;
import java.util.*;
import java.util.stream.Stream;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(strs));
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
       return Arrays.stream(strs).reduce((s1, s2) -> {
           int min = Math.min(s1.length(), s2.length());
           int i = 0;
           while(i < min && s1.charAt(i) == s2.charAt(i)) {
               i++;
           }
           return s1.substring(0, i);
       }).orElse(" ");
    }

    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
