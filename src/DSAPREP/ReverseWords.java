package DSAPREP;
import java.util.*;
public class ReverseWords {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
