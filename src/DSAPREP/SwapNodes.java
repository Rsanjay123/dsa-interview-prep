package DSAPREP;

public class SwapNodes {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    ListNode result = swapNodesInPair(head);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public static ListNode swapNodesInPair(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode temp = dummy;
    while(temp != null && temp.next != null && temp.next.next != null) {
      ListNode first = temp.next;
      ListNode second = temp.next.next;

      first.next = second.next;
      second.next = first;
      temp.next = second;

      temp = first;
    }
    return dummy.next;
  }
}
