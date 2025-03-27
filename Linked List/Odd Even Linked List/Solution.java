class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode OddHead = head;
        ListNode EvenHead = head.next;
        ListNode odd = OddHead;
        ListNode even = EvenHead;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = EvenHead;

        return OddHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = oddEvenList(head);
        ListNode temp = newHead;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}