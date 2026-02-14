package DSAPREP;
import java.util.*;

/**
 * Problem: Pascal's Triangle II
 * 
 * Problem Statement:
 * Given an integer rowIndex, return the rowIndex-th (0-indexed) row of Pascal's triangle.
 * 
 * Example:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * 
 * Approach:
 * Build row incrementally using the property that each element is the sum of 
 * two elements above it. Use in-place updates to save space.
 * 
 * Algorithm:
 * 1. Initialize list with all 1s
 * 2. For each row from 0 to rowIndex:
 *    - Add 1 at the end (rightmost element)
 *    - Update middle elements from right to left:
 *      * rows[j] = rows[j] + rows[j-1]
 *    - This builds the row incrementally
 * 
 * Key insight:
 * - We update from right to left to avoid overwriting values we need
 * - Each element is sum of current and previous element
 * - By going right to left, we preserve the values needed for calculation
 * 
 * Example walkthrough (rowIndex=3):
 * i=0: rows=[1]
 * i=1: add 1 -> [1,1], j loop doesn't run (j=0, j>0 false)
 * i=2: add 1 -> [1,1,1], j=1: rows[1]=1+1=2 -> [1,2,1]
 * i=3: add 1 -> [1,2,1,1], j=2: rows[2]=1+2=3 -> [1,2,3,1]
 *       j=1: rows[1]=2+1=3 -> [1,3,3,1] ✓
 * 
 * Time Complexity: O(rowIndex²) - we build rowIndex rows
 * Space Complexity: O(rowIndex) - only store one row
 */
public class pascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> result = getRow(rowIndex);
        System.out.println(result);
    }

    /**
     * Gets the rowIndex-th row of Pascal's triangle
     * 
     * @param rowIndex 0-indexed row number
     * @return List representing the rowIndex-th row
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> rows = new ArrayList<>();
        
        // Build each row incrementally
        for(int i = 0; i <= rowIndex; i++) {
            // Add 1 at the end (rightmost element is always 1)
            rows.add(1);
            
            // Update middle elements from right to left
            // We go right to left to avoid overwriting values we need
            for(int j = i - 1; j > 0; j--) {
                // Each element is sum of current and previous element
                rows.set(j, rows.get(j) + rows.get(j - 1));
            }
        }
        return rows;
    }
}
