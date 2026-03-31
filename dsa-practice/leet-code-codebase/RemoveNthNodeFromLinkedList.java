class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        ListNode temp = head;
        if (n == 1) {
            head = head.next;
        } else {
            for (int i = 1; i < n - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        head = reverse(head);
        return head;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}