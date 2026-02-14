package DSAPREP;
import java.util.*;

/**
 * Problem: Remove Nth Node From End of List
 * 
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list 
 * and return its head.
 * 
 * Example:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Explanation: The 2nd node from the end is node 4, which is removed.
 * 
 * Approach:
 * Use two-pointer technique (fast and slow pointers) with a gap of n+1 nodes.
 * When fast reaches the end, slow will be at the node before the one to remove.
 * 
 * Algorithm:
 * 1. Create a dummy node pointing to head (handles edge case of removing head)
 * 2. Initialize both fast and slow pointers at dummy
 * 3. Move fast pointer n+1 steps ahead (creates gap of n+1)
 * 4. Move both pointers together until fast reaches null
 * 5. Now slow is at the node before the one to remove
 * 6. Remove the node: slow.next = slow.next.next
 * 7. Return dummy.next (skip dummy node)
 * 
 * Why n+1 gap?
 * - We need slow to point to the node BEFORE the one to remove
 * - If we want to remove nth from end, we need slow at (n+1)th from end
 * - Gap of n+1 ensures this positioning
 * 
 * Why dummy node?
 * - If we need to remove the head node, we need a node before it
 * - Dummy node provides this, simplifying the code
 * 
 * Example walkthrough:
 * List: [1,2,3,4,5], n = 2 (remove 4)
 * After moving fast n+1=3 steps: fast at 4, slow at dummy
 * Move both: fast at 5, slow at 1
 * Move both: fast at null, slow at 3
 * Now slow.next (4) is the node to remove
 * slow.next = slow.next.next (connect 3 to 5)
 * 
 * Time Complexity: O(L) where L is the length of the list
 * Space Complexity: O(1) - only using constant extra space
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * Removes the nth node from the end of the linked list
     * 
     * @param head The head of the linked list
     * @param n The position from the end (1-indexed)
     * @return The head of the modified linked list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node helps handle edge case of removing head node
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer n+1 steps ahead
        // This creates a gap of n+1 nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers together until fast reaches the end
        // When fast is null, slow will be at the node before the one to remove
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from end by skipping it
        slow.next = slow.next.next;
        
        // Return the actual head (skip dummy node)
        return dummy.next;
    }
}
