package DSAPREP;

public class DeleteLastNode {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    ListNode result = delAddLastNode(head);
    StringBuilder sb = new StringBuilder();
    while(result != null) {
      sb.append(result.val).append("->");
      result = result.next;
    }
    System.out.println(sb);
  }

  private static ListNode delAddLastNode(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode temp = head;
    ListNode prev = null;

    while(temp.next != null) {
      prev = temp;
      temp = temp.next;
    }
    prev.next = null;
    temp.next = head;
    head = temp;
    return head;
  }
}
