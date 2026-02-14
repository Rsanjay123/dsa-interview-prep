package DSAPREP;
import java.util.*;

/**
 * Problem: Assign Cookies (Cookie Distribution)
 * 
 * Problem Statement:
 * Assume you are an awesome parent and want to give your children some cookies. 
 * But, you should give each child at most one cookie.
 * 
 * Each child i has a greed factor g[i], which is the minimum size of a cookie 
 * that the child will be content with. Each cookie j has a size s[j]. 
 * 
 * If s[j] >= g[i], we can assign the cookie j to the child i, and the child i 
 * will be content. Your goal is to maximize the number of your content children 
 * and output the maximum number.
 * 
 * Example:
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors are 1, 2, 3.
 *              You can only make 1 child content (assign cookie 1 to child 1).
 * 
 * Approach:
 * Greedy algorithm: sort both arrays, assign smallest cookie that satisfies each child.
 * 
 * Algorithm:
 * 1. Sort greed factors (g) and cookie sizes (s)
 * 2. Use two pointers: i for children, j for cookies
 * 3. For each cookie:
 *    - If cookie size >= child's greed: assign cookie, move both pointers
 *    - Else: try next cookie (move j)
 * 4. Return count of satisfied children
 * 
 * Why greedy works:
 * - We want to maximize satisfied children
 * - Assign smallest cookie that satisfies a child (saves larger cookies for larger greed)
 * - Sorting ensures we process in order
 * 
 * Example walkthrough:
 * g = [1,2,3], s = [1,1] (sorted)
 * i=0, j=0: g[0]=1, s[0]=1, 1>=1, assign, count=1, i=1, j=1
 * i=1, j=1: g[1]=2, s[1]=1, 1<2, skip cookie, j=2 (out of bounds)
 * Result: count=1 ✓
 * 
 * Time Complexity: O(n log n + m log m) - sorting dominates
 * Space Complexity: O(1) excluding sort space
 */
public class CookieDistribution {
    public static void main(String[] args) {
        int[] n = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(n, s));
    }
    
    /**
     * Finds maximum number of content children
     * 
     * @param g Array of greed factors
     * @param s Array of cookie sizes
     * @return Maximum number of satisfied children
     */
    public static int findContentChildren(int[] g, int[] s) {
        // Sort both arrays to enable greedy matching
        Arrays.sort(g);
        Arrays.sort(s);
        
        int count = 0;
        int i = 0;  // Pointer for children (greed factors)
        int j = 0;  // Pointer for cookies
        
        // Try to assign cookies to children
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                // Cookie satisfies child's greed
                count++;
                i++;  // Move to next child
            }
            // Move to next cookie (whether assigned or not)
            j++;
        }
        
        return count;
    }
}
