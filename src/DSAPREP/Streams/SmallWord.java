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
}
