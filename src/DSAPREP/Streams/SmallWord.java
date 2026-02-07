package DSAPREP.Streams;
import java.util.*;
import java.util.stream.Stream;

public class SmallWord {
    public static void main(String[] args) {
        String s = "Google Opensource";
        String s1 = "I love programming in Java";
        System.out.println(smallestWord4(s));
        System.out.println(smallestWord4(s1));
        System.out.println(smallestWord3(s));
        System.out.println(smallestWord3(s1));
        System.out.println(smallestWord2(s1));
        System.out.println(smallestWord1(s));
        System.out.println(reverseString2(s));
        System.out.println(reverseString(s1));
    }

    public static String smallestWord1(String s) {
        Optional<String> min = Stream.of(s.split(" ")).min(Comparator.comparingInt(String :: length));
        return min.orElse("");
    }

    public static String smallestWord2(String s) {
        Stream.of(s.split(" ")).min(Comparator.comparingInt(String :: length)).ifPresent(System.out :: println);
        return " ";
    }

    public static String smallestWord3(String s) {
        String[] words = s.split(" ");
        String smallest = words[0];
        for(String word : words){
            if(word.length() <= smallest.length()){
                smallest = word;
            }
        }
        return smallest;
    }

    public static String smallestWord4(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, Comparator.comparingInt(String :: length));
        return words[0];
    }

    public static String reverseString(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            if(i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseString2(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
