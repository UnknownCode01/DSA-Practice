import java.util.*;
class Structure{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        static Node head = null;

        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head=head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

        public static void show(){
            while(!isEmpty()){
                System.out.print(pop()+" ");
            }
        }
        
    }
    public static void main(String[] args){
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
        st.show();
        
    }
}