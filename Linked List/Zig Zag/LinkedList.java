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

    public Node reverse(Node head){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }

    public void print(Node head){
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

    public Node zigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid = slow;
        Node h1 = head;
        Node h2 = mid.next;
        slow.next=null;
        //reverse
        h2=reverse(h2);
        //alt merge
        Node nLL=new Node(-1);
        Node temp=nLL;
        while(h1!=null && h2!=null){
            temp.next=h1;
            temp=h1;
            h1=h1.next;
            temp.next=h2;
            temp=h2;
            h2=h2.next;
        }
        if(h1!=null){
            temp.next=h1;  
        }
        return nLL.next;

    }
    
    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addFirst(1);
        l1.addFirst(0);
        l1.addLast(2);
        l1.addLast(3);
        l1.print(head);
        System.out.println("Size is "+l1.size);
        head=l1.zigZag();
        l1.print(head);

    }
}