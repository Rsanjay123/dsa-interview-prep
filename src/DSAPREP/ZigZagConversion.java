package DSAPREP;
import java.util.*;
public class ZigZagConversion {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
        System.out.println(convert2(s, numRows));
    }

    public static String convert(String s, int numRows){
        if(numRows <= 1 || s.length() <= numRows){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean goingDown = false;
        for(char c: s.toCharArray()){
            rows[currentRow].append(c);
            if(currentRow == 0 || currentRow == numRows - 1){
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1: -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder row: rows){
            result.append(row);
        }
        return result.toString();
    }

    public static String convert2(String s, int numRows) {
        if(numRows <= 1 || s.length() <= numRows){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        Arrays.setAll(rows, i -> new StringBuilder());
        int currentRow = 0;
        boolean goingDown = false;
        for(char c: s.toCharArray()){
            rows[currentRow].append(c);
            if(currentRow == 0 || currentRow == numRows - 1){
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        return Arrays.stream(rows).collect(StringBuilder :: new, StringBuilder :: append, StringBuilder :: append).toString();
    }
}
