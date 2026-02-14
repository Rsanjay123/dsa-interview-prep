package DSAPREP;
import java.util.*;

/**
 * Problem: Pascal's Triangle
 * 
 * Problem Statement:
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 * 
 * Approach:
 * Build triangle row by row using the property that each element is the sum of 
 * the two elements above it.
 * 
 * Algorithm:
 * 1. For each row i from 0 to numRows-1:
 *    - Create a new row with i+1 elements
 *    - First and last elements are always 1
 *    - Middle elements: row[i][j] = row[i-1][j-1] + row[i-1][j]
 * 2. Add each row to result
 * 
 * Key properties:
 * - Row i has i+1 elements
 * - First and last elements are always 1
 * - Each element (except first/last) = sum of two elements above it
 * 
 * Example walkthrough:
 * Row 0: [1]
 * Row 1: [1, 1]
 * Row 2: [1, 1+1=2, 1] = [1,2,1]
 * Row 3: [1, 1+2=3, 2+1=3, 1] = [1,3,3,1]
 * Row 4: [1, 1+3=4, 3+3=6, 3+1=4, 1] = [1,4,6,4,1]
 * 
 * Time Complexity: O(numRows²) - we create numRows rows with total O(numRows²) elements
 * Space Complexity: O(numRows²) - space for the result
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        System.out.println(result);
    }

    /**
     * Generates Pascal's triangle with numRows rows
     * 
     * @param numRows Number of rows to generate
     * @return List of lists representing Pascal's triangle
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Generate each row
        for(int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            
            // Row i has i+1 elements
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    // First and last elements are always 1
                    rows.add(1);
                } else {
                    // Middle elements: sum of two elements above
                    // result.get(i-1).get(j-1) is element above-left
                    // result.get(i-1).get(j) is element above-right
                    rows.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(rows);
        }
        return result;
    }
}
