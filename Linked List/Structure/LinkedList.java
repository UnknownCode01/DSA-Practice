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
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;

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
    public static Node head;
    public static Node tail;
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addFirst(5);
        l1.addFirst(4);
        l1.addFirst(7);
        l1.print(head);
    }
}