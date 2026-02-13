package DSAPREP;
import java.util.*;
public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String words, char ch) {
        int index = words.indexOf(ch);
        if(index == -1) {
            return words;
        }
        String prefix = words.substring(0, index + 1);
        String suffix = words.substring(index + 1);
        StringBuilder sb = new StringBuilder(prefix);
        sb.reverse();
        sb.append(suffix);
        return sb.toString();
    }
}
