package DSAPREP;
import java.util.*;

/**
 * Problem: Generate Parentheses
 * 
 * Problem Statement:
 * Given n pairs of parentheses, write a function to generate all combinations of 
 * well-formed parentheses.
 * 
 * Example:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Approach:
 * Use backtracking (recursive DFS) to generate all valid combinations.
 * 
 * Algorithm:
 * 1. Use backtracking with two constraints:
 *    - Can add '(' if open < n
 *    - Can add ')' if close < open (ensures validity)
 * 2. When string length == 2*n, add to result
 * 3. Try adding '(' or ')', recurse, then backtrack (remove)
 * 
 * Why backtracking?
 * - We need to explore all valid combinations
 * - Backtracking allows us to build strings incrementally
 * - We can prune invalid paths early
 * 
 * Key constraints:
 * - open < n: Can't have more than n open parentheses
 * - close < open: Can't close more than we've opened (ensures validity)
 * 
 * Example walkthrough (n=2):
 * Start: open=0, close=0, sb=""
 * Add '(' -> open=1, sb="("
 *   Add '(' -> open=2, sb="(("
 *     Add ')' -> close=1, sb="(()"
 *       Add ')' -> close=2, sb="(())" ✓ (length=4, add to result)
 *   Add ')' -> close=1, sb="()"
 *     Add '(' -> open=2, sb="()("
 *       Add ')' -> close=2, sb="()()" ✓
 * Add ')' -> invalid (close=0, open=0, violates close < open)
 * 
 * Time Complexity: O(4^n / sqrt(n)) - Catalan number C(n) = (2n)!/((n+1)!n!)
 * Space Complexity: O(n) for recursion stack and StringBuilder
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    /**
     * Generates all valid combinations of n pairs of parentheses
     * 
     * @param n Number of pairs of parentheses
     * @return List of all valid combinations
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start backtracking with 0 open and 0 close parentheses
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }
    
    /**
     * Backtracking helper function
     * 
     * @param n Total number of pairs needed
     * @param open Number of open parentheses used so far
     * @param close Number of close parentheses used so far
     * @param sb Current string being built
     * @param result List to store valid combinations
     */
    public static void backtrack(int n, int open, int close, StringBuilder sb, List<String> result) {
        // Base case: we've used all 2*n characters
        if(sb.length() == 2 * n) {
            result.add(sb.toString());
            return; // Important: return after adding
        }
        
        // Try adding '(' if we haven't used all open parentheses
        if(open < n) {
            sb.append('(');
            backtrack(n, open + 1, close, sb, result);
            // Backtrack: remove the '(' we just added
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // Try adding ')' if we have more open than close
        // This ensures we never have invalid combinations like "))"
        if(close < open) {
            sb.append(')');
            backtrack(n, open, close + 1, sb, result);
            // Backtrack: remove the ')' we just added
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
