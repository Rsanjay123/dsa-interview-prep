package DSAPREP;
import java.util.*;

/**
 * Problem: Add Two Numbers (using Linked Lists)
 * 
 * Problem Statement:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each node contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Example:
 * Input: l1 = [2,4,3] (represents 342), l2 = [5,6,4] (represents 465)
 * Output: [7,0,8] (represents 807, which is 342 + 465)
 * 
 * Explanation:
 * - 342 + 465 = 807
 * - Stored in reverse: [7,0,8]
 * 
 * Approach:
 * Simulate addition digit by digit, handling carry-over just like manual addition.
 * 
 * Algorithm:
 * 1. Create a dummy head node to simplify edge cases
 * 2. Initialize carry = 0
 * 3. While either list has nodes or carry is non-zero:
 *    - Sum = carry + l1.val (if l1 exists) + l2.val (if l2 exists)
 *    - Carry = sum / 10 (tens digit)
 *    - Create new node with value = sum % 10 (ones digit)
 *    - Move to next nodes in both lists
 * 4. Return dummyHead.next (skip dummy node)
 * 
 * Why dummy head?
 * - Simplifies code by avoiding special case for first node
 * - We can always do current.next = new ListNode(...)
 * - Return dummyHead.next to skip the dummy node
 * 
 * Example walkthrough:
 * l1 = [2,4,3], l2 = [5,6,4]
 * 
 * Step 1: sum = 0 + 2 + 5 = 7, carry = 0, node = 7
 * Step 2: sum = 0 + 4 + 6 = 10, carry = 1, node = 0
 * Step 3: sum = 1 + 3 + 4 = 8, carry = 0, node = 8
 * Result: [7,0,8]
 * 
 * Edge cases handled:
 * - Lists of different lengths (e.g., [9,9] + [1] = [0,0,1])
 * - Final carry (e.g., [5] + [5] = [0,1])
 * 
 * Time Complexity: O(max(m,n)) where m and n are lengths of the two lists
 * Space Complexity: O(max(m,n)) for the result list
 */
public class AddTwoNumbersUsingLinkedList {
    public static void main(String [] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        StringBuilder sb = new StringBuilder();
        while(result != null) {
            sb.append(result.val).append(" -> ");
            result = result.next;
        }
        System.out.println(sb);
    }

    /**
     * Adds two numbers represented as linked lists
     * 
     * @param l1 First number as linked list (digits in reverse order)
     * @param l2 Second number as linked list (digits in reverse order)
     * @return Sum as linked list (digits in reverse order)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head simplifies the code - we can always do current.next = new node
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        // Continue while either list has nodes OR there's a carry to process
        while(l1 != null || l2 != null || carry != 0) {
            // Start with carry from previous iteration
            int sum = carry;
            
            // Add digit from l1 if it exists
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            // Add digit from l2 if it exists
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Calculate carry for next iteration (tens digit)
            carry = sum/10;
            
            // Create new node with ones digit
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        // Return the actual head (skip dummy node)
        return dummyHead.next;
    }
}

