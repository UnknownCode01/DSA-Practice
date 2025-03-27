class Solution {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    static Node deleteAllOccurOfX(Node head, int x) {
        while (head != null && head.data == x) {
            head = head.next;
        }
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(10);
        head.next.prev = head;
        head.next.next = new Node(4);
        head.next.next.prev = head.next;

        Node newHead = deleteAllOccurOfX(head, 10);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}