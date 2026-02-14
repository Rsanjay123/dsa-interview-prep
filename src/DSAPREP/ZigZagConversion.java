package DSAPREP;
import java.util.*;

/**
 * Problem: ZigZag Conversion
 * 
 * Problem Statement:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
 * like this:
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows.
 * 
 * Example:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Explanation:
 * P     A     H     N
 * A  P  L  S  I  I  G
 * Y     I     R
 * 
 * Read row by row: "PAHNAPLSIIGYIR"
 * 
 * Approach:
 * Simulate the zigzag pattern by tracking current row and direction.
 * 
 * Algorithm:
 * 1. Create array of StringBuilders, one for each row
 * 2. Track currentRow and direction (goingDown)
 * 3. For each character:
 *    - Append to current row's StringBuilder
 *    - If at top (row 0) or bottom (row numRows-1), reverse direction
 *    - Move to next row based on direction
 * 4. Concatenate all rows
 * 
 * How direction works:
 * - Start goingDown = false (we'll set it to true at first)
 * - At row 0 or numRows-1, flip direction
 * - If goingDown: move to row+1, else move to row-1
 * 
 * Example walkthrough (numRows=3):
 * s = "PAYPALISHIRING"
 * Row 0: P -> A -> H -> N
 * Row 1: A -> P -> L -> S -> I -> I -> G
 * Row 2: Y -> I -> R
 * 
 * Step-by-step:
 * c='P': currentRow=0, append to row[0], at top, goingDown=true, currentRow=1
 * c='A': currentRow=1, append to row[1], goingDown=true, currentRow=2
 * c='Y': currentRow=2, append to row[2], at bottom, goingDown=false, currentRow=1
 * c='P': currentRow=1, append to row[1], goingDown=false, currentRow=0
 * ... continue
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(n) for the StringBuilders
 */
public class ZigZagConversion {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
        System.out.println(convert2(s, numRows));
    }

    /**
     * Approach 1: Manual Concatenation
     * 
     * Converts string to zigzag pattern and reads row by row
     * 
     * @param s Input string
     * @param numRows Number of rows in zigzag pattern
     * @return String read row by row from zigzag pattern
     */
    public static String convert(String s, int numRows){
        // Edge cases: 1 row or string shorter than rows
        if(numRows <= 1 || s.length() <= numRows){
            return s;
        }
        
        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;  // Direction: true = down, false = up
        
        // Distribute characters to rows
        for(char c: s.toCharArray()){
            // Append character to current row
            rows[currentRow].append(c);
            
            // Change direction at top or bottom
            if(currentRow == 0 || currentRow == numRows - 1){
                goingDown = !goingDown;
            }
            
            // Move to next row based on direction
            currentRow += goingDown ? 1: -1;
        }
        
        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for(StringBuilder row: rows){
            result.append(row);
        }
        return result.toString();
    }

    /**
     * Approach 2: Using Streams and Arrays.setAll
     * 
     * Same algorithm but uses more functional programming style
     * 
     * @param s Input string
     * @param numRows Number of rows in zigzag pattern
     * @return String read row by row from zigzag pattern
     */
    public static String convert2(String s, int numRows) {
        // Edge cases
        if(numRows <= 1 || s.length() <= numRows){
            return s;
        }
        
        // Initialize StringBuilders using Arrays.setAll
        StringBuilder[] rows = new StringBuilder[numRows];
        Arrays.setAll(rows, i -> new StringBuilder());
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Distribute characters (same logic as convert)
        for(char c: s.toCharArray()){
            rows[currentRow].append(c);
            if(currentRow == 0 || currentRow == numRows - 1){
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        
        // Concatenate using stream collect
        return Arrays.stream(rows)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
