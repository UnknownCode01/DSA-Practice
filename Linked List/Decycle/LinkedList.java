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

    public boolean isCyclic(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        Node prev=fast;
        boolean exists=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            prev=fast.next;
            fast=fast.next.next;
            if(slow==fast){
                exists = true;
                break;
            }
        }
        if(exists == false) return;

        slow=head;
        
        while(slow!=fast){
            slow=slow.next;
            prev=fast;
            fast=fast.next;
        }
        prev.next=null;

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
        l1.addFirst(5);
        head.next=new Node(4);
        head.next.next=new Node(3); 
        head.next.next.next=new Node(2); 
        head.next.next.next.next=head.next; //5->4->3->2->4
        if(l1.isCyclic()){
            System.out.println("Cyclic");
            l1.removeCycle();
            System.out.println("After Cycle removal");
            l1.print();
        }
        else 
        {
            System.out.println("Not Cyclic");
            l1.print();
        }
    }
}