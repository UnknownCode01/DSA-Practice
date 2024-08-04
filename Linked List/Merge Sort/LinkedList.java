import java.util.*;

class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        } 
    }
    public void addFirst(int data){
        size++;
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        size++;
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }
    public void add(int idx, int data){
        if(idx>size){
            System.out.println("Index exceeds nodes");
            return;
        }
        if(idx==0){
            addFirst(data);
            return;
        }
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        Node newNode=new Node(data);
        newNode.next=temp.next;
        temp.next=newNode;

    }

    public int removeFirst(){
        if(size==0){
            System.out.println("Empty Linked List");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("Empty Linked List");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }   
        Node temp = head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        int val = temp.next.data;
        tail=temp;
        temp.next=null;
        size--;
        return val;
    }

    public int remove(int x){
        Node temp = head;
        if(temp.data == x) {
            head=head.next;
            size--;
            return 0;
        }
        Node prev=head;
        while(temp!=null){
            if(temp.data == x) {
                prev.next=prev.next.next;
                size--;
                return 0;
            }
            prev=temp;
            temp=temp.next;
        }
        return -1;
    }
    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL; 
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null) return head;
        Node mid = getMid(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeftHead = mergeSort(leftHead);
        Node newRightHead = mergeSort(rightHead);
        return merge(newLeftHead,newRightHead);
    }

    public void print(){
        if(head==null){
            System.out.println("No data exists.");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(7);
        l1.addLast(5);
        l1.addLast(2);
        l1.print();
        System.out.println("Size is "+l1.size);
        l1.mergeSort(head);
        l1.print();

    }
}