package DSAPREP;
import java.util.*;
public class ValidNumber {
    public static void main(String[] args) {
        String s = "  -42.3e+7  ";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean seenDigitAfterExp = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                seenDigit = true;
                if(seenExp){
                    seenDigitAfterExp = true;
                }
            } else if(c == '+' || c == '-'){
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if(c == '.'){
                if(seenDot || seenExp){
                    return false;
                }
                seenDot = true;
            } else if(c == 'e' || c == 'E') {
                if(seenExp || !seenDigit){
                    return false;
                }
                seenExp = true;
                seenDigitAfterExp = false;
            } else {
                return false;
            }
        }
        return seenDigit && seenDigitAfterExp;
    }
}
