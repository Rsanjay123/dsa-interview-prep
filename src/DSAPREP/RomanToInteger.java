package DSAPREP;
import java.util.*;
public class RomanToInteger {
    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total  = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char currentValue = s.charAt(i);
            char nextValue = (i + 1 < n) ? s.charAt(i + 1) : ' ';
            if(romanMap.containsKey(currentValue) && romanMap.containsKey(nextValue) && (romanMap.get(currentValue) < romanMap.get(nextValue))){
                total += romanMap.get(currentValue);
            } else {
                total -= romanMap.get(currentValue);
            }
        }
        if (total < 0) {
            total = total * -1;
        }
        return total;

    }
}
