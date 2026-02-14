package DSAPREP.STACKPROBLEMS;
import java.util.*;

/**
 * Problem: Valid Parentheses
 * 
 * Problem Statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example:
 * Input: s = "({[]})"
 * Output: true
 * 
 * Input: s = "([)]"
 * Output: false
 * 
 * Approach:
 * Use a stack to track opening brackets. When we see a closing bracket, 
 * check if it matches the most recent opening bracket.
 * 
 * Algorithm:
 * 1. Create a stack
 * 2. For each character:
 *    - If opening bracket: push to stack
 *    - If closing bracket:
 *      * If stack empty: invalid
 *      * If matches top: pop from stack
 *      * If doesn't match: invalid
 * 3. String is valid if stack is empty at the end
 * 
 * Why stack?
 * - Last opened bracket must be closed first (LIFO)
 * - Stack naturally handles this ordering
 * 
 * Example walkthrough:
 * s = "({[]})"
 * '(' -> push, stack: ['(']
 * '{' -> push, stack: ['(', '{']
 * '[' -> push, stack: ['(', '{', '[']
 * ']' -> matches '[', pop, stack: ['(', '{']
 * '}' -> matches '{', pop, stack: ['(']
 * ')' -> matches '(', pop, stack: []
 * Stack empty -> valid ✓
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(n) for the stack
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));
    }

    /**
     * Checks if parentheses string is valid
     * 
     * @param s String containing parentheses
     * @return true if valid, false otherwise
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                // Opening bracket: push to stack
                stack.push(c);
            } else {
                // Closing bracket: check if it matches
                if(stack.isEmpty()) {
                    // No opening bracket to match
                    return false;
                }
                
                char top = stack.peek();
                // Check if closing bracket matches opening bracket
                if ((c == ')' && top == '(') || 
                    (c == '}' && top == '{') || 
                    (c == ']' && top == '[')) {
                    // Matches! Remove the opening bracket
                    stack.pop();
                } else {
                    // Doesn't match
                    return false;
                }
            }
        }
        
        // Valid if all brackets were matched (stack is empty)
        return stack.isEmpty();
    }
}
