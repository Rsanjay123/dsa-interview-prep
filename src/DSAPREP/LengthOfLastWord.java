package DSAPREP;
import java.util.*;
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        int n = words.length - 1;
        return words[n].length();
    }
}
