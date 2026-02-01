package DSAPREP;
import java.util.*;
public class ReverseVowels {
    public static void main(String [] args) {
        System.out.println(swapVowels("routusanjay"));
        System.out.println(swapVowels("adhikarlaramateja"));
    }

    public static String swapVowels(String name) {
        if(name.isEmpty()  || name.length() == 1){
            return name;
        }
        int left = 0;
        int right = name.length() - 1;
        char [] arr = name.toCharArray();
        String vowels = "AEIOUaeiou";
        while(left < right){
            if(left < right && vowels.indexOf(arr[left]) == -1){
                left++;
                continue;
            }
            if(left < right && vowels.indexOf(arr[right]) == -1){
                right--;
                continue;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }
        return new String(arr);
    }
}
