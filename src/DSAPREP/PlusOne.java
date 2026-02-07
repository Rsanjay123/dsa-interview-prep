package DSAPREP;
import java.util.*;
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
        int [] digits2 = {9};
        System.out.println(Arrays.toString(plusOne2(digits2)));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i>=0; i--){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static int[] plusOne2(int[] digits) {
        int last = digits.length - 1;
        if (digits[last] < 9) {
            digits[last] += 1;
            return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        int sum = digits[last] + 1;
        newDigits[0] = sum / 10;
        newDigits[1] = sum % 10;
        return newDigits;
    }
}
