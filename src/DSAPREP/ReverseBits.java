package DSAPREP;
import java.util.*;
public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        String binary = String.format("%32s",
                        Integer.toBinaryString(n))
                .replace(' ', '0');
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        return (int) Long.parseLong(String.valueOf(sb), 2);
    }
}
