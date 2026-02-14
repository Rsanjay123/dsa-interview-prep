package DSAPREP;
import java.util.*;

/**
 * Problem: Rotate Linked List Right by K Places
 * 
 * Problem Statement:
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Explanation: Rotate 1 step to the right: [5,1,2,3,4]
 *              Rotate 2 steps to the right: [4,5,1,2,3]
 * 
 * Approach:
 * 1. First, we need to find the length of the linked list
 * 2. Connect the tail to the head to make it circular
 * 3. Calculate effective rotations: k % length (since rotating by length brings us back to original)
 * 4. Find the new tail: it will be at position (length - k) from the start
 * 5. The new head will be the node after the new tail
 * 6. Break the circular connection at the new tail
 * 
 * Algorithm:
 * - Edge cases: if head is null, has only one node, or k is 0, return head
 * - Traverse to find length and reach the tail node
 * - Make the list circular by connecting tail.next = head
 * - Calculate effective k: k = k % length (handles k > length)
 * - Calculate steps to new tail: length - k
 * - Traverse from head to find the new tail node
 * - Set newHead = newTail.next
 * - Break circular connection: newTail.next = null
 * - Return newHead
 * 
 * Time Complexity: O(n) where n is the length of the list
 * Space Complexity: O(1) - only using constant extra space
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode result = rotateRight(head, k);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * Rotates the linked list to the right by k places
     * 
     * @param head The head of the linked list
     * @param k The number of places to rotate right
     * @return The new head of the rotated linked list
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation needed
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find the length of the list and reach the tail
        ListNode temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        // Now temp points to the tail node
        
        // Step 2: Make the list circular by connecting tail to head
        temp.next = head;
        
        // Step 3: Calculate effective rotations
        // If k >= length, rotating k times is same as rotating k % length times
        k = k % length;
        
        // Step 4: Calculate how many steps we need to move from head to find new tail
        // The new tail will be at position (length - k) from the start
        // Example: length=5, k=2, new tail is at position 3 (0-indexed: 0,1,2)
        int stepsToNewTail = length - k;
        
        // Step 5: Traverse to find the new tail node
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // Step 6: The new head is the node after the new tail
        ListNode newHead = newTail.next;
        
        // Step 7: Break the circular connection
        newTail.next = null;
        
        return newHead;
    }
}
