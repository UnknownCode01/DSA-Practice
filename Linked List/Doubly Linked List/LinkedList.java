class LinkedList{
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
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
        head.prev=newNode;
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
        newNode.prev=tail;
        tail=newNode;
    }
    public void add(int idx, int data){
        if(idx>size){
            System.out.println("Index no "+idx+" exceeds node size "+size);
            return;
        }
        if(idx==0){
            addFirst(data);
            return;
        }
        if(idx==size){
            addLast(data);
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
        temp.next.prev=newNode;
        temp.next=newNode;
        newNode.prev=temp;

    }

    public int removeFirst(){
        if(size==0){
            System.out.println("Empty Linked List");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head=head.next;
        head.prev=null;
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
        if(temp==null){
            System.out.println("Empty Linked List");
            return Integer.MIN_VALUE;
        }
        if(temp.data == x) {
            removeFirst();
            return x;
        }
        Node temp2=tail;
        if(temp2.data == x) {
            removeLast();
            return x;
        }
        Node prev2=head;
        temp=temp.next;
        while(temp!=null){
            if(temp.data == x) {
                prev2.next=prev2.next.next;
                prev2.next.prev=prev2;
                size--;
                return 0;
            }
            prev2=temp;
            temp=temp.next;
        }
        System.out.println("Data doesn't exist");
        return -1;
    }

    public void print1(Node head){
        if(head==null){
            System.out.println("No data exists.");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void print2(Node head){
        if(head==null){
            System.out.println("No data exists.");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.prev;
        }
        System.out.println("null");
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addFirst(5);
        l1.addFirst(4);
        l1.addFirst(7);
        l1.addLast(1);
        l1.addLast(9);
        l1.add(6,99);
        l1.add(5,0);
        l1.add(0,2);
        l1.print1(head);
        l1.print2(tail);
        System.out.println("Size is "+l1.size);
        l1.removeFirst();
        l1.print1(head);
        l1.print2(tail);
        l1.removeLast();
        l1.print1(head);
        l1.print2(tail);
        l1.remove(9);
        l1.print1(head);
        l1.print2(tail);
        l1.remove(7);
        l1.print1(head);
        l1.print2(tail);
        l1.remove(5);
        l1.print1(head);
        l1.print2(tail);
        l1.remove(13);
        l1.print1(head);
        l1.print2(tail);

    }
}