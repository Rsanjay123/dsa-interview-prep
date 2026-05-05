package DSAPREP;

public class RemoveDuplicatesFromListNode {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next.next.next.next = new ListNode(5);
    ListNode result = deleteDuplicates(head);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode temp = head;
    while(temp != null && temp.next != null) {
      if(temp.val == temp.next.val) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return head;
  }
}
