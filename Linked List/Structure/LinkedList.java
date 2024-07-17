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
        nodes++;
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
        nodes++;
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
        if(idx>nodes){
            System.out.println("Index exceeds nodes");
            return;
        }
        if(idx==0){
            addFirst(data);
            return;
        }
        size++;
        nodes++;
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

    // public int remove(){

    // }

    public boolean itrSearch(int x){
        Node ptr=head;
        while(ptr!=null){
            if(ptr.data==x) return true;
            else ptr=ptr.next;
        }
        return false;
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
    public static int nodes;
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
        l1.print();
        System.out.println("Size is "+l1.size);
        l1.removeFirst();
        l1.print();
        System.out.println("Size is "+l1.size);
        l1.removeLast();
        l1.print();
        System.out.println("Size is "+l1.size);
        System.out.println(l1.itrSearch(1));
        System.out.println(l1.itrSearch(10));

    }
}