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
        Node slow = head;
        Node fast = head;
        boolean flag=false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                flag=true;
                break;
            }
        }
        if(flag==false){
            return 0;
        }
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        int count = 1;
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            if(slow==fast){
                return count;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        Node head=new Node(25);
        head.next=new Node(14);
        head.next.next=new Node(19);
        head.next.next.next=new Node(33);
        head.next.next.next.next=new Node(10);
        head.next.next.next.next.next=new Node(21);
        head.next.next.next.next.next.next=new Node(39);
        head.next.next.next.next.next.next.next=new Node(90);
        head.next.next.next.next.next.next.next.next=new Node(58);
        head.next.next.next.next.next.next.next.next.next=new Node(45);
        head.next.next.next.next.next.next.next.next.next.next=head.next.next.next;

        System.out.println(countNodesinLoop(head));
    }
}