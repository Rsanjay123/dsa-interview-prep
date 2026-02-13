package DSAPREP;
import java.util.*;
public class RepeatedDNASequence {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 10) {
            return result;
        }
        Set<String> seen = new HashSet<>();
        Set<String> added = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);

            if(!seen.add(sub) && added.add(sub)) {
                result.add(sub);
            }
        }
        return result;
    }
}
