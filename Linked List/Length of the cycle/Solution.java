import java.util.*;
class Solution{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static int countNodesinLoop(Node head) {
        Node p=head;
        for(int i=0;i<6;i++){
            System.out.print(p.data+" ");
            p=p.next;
        }
        return -1;
    }
    public static void main(String[] args){
        Node head=new Node(0);
        head.next=new Node(1);
        head.next.next=new Node(2);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(4);
        head.next.next.next.next.next=head.next;

        System.out.println(countNodesinLoop(head));
    }
}