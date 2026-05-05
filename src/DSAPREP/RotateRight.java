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
//        ListNode result2 = reverseList(head);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

//  private static ListNode reverseList(ListNode head) {
//      ListNode prev = null;
//      ListNode curr = head;
//      while(curr != null) {
//        ListNode next = curr.next;
//        curr.next = prev;
//        prev = curr;
//        curr = next;
//      }
//      return prev;
//  }

  /**
     * Rotates the linked list to the right by k places
     * 
     * @param head The head of the linked list
     * @param k The number of places to rotate right
     * @return The new head of the rotated linked list
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
          return head;
        }
        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
          temp = temp.next;
          length++;
        }
        temp.next = head;
        k = k % length;
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewTail; i++) {
          newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
