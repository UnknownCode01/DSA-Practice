class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode s = pre;
        ListNode f = pre;
        while (n > 0) {
            f = f.next;
            n--;
        }
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = removeNthFromEnd(head, 2);
        ListNode temp = newHead;
        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}