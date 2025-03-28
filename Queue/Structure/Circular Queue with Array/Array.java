import java.util.*;
class Array{
    static class Queue{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        Queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }
        public static boolean isEmpty(){
            return front==-1 && rear==-1;
        }
        public static void add(int data){
            if((rear+1)%size==front){
                System.out.println("Queue is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int temp=arr[front];
            if(front==rear){
                front=rear=-1;
            }else{
            front=(front+1)%size;
            }
            return temp;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    } 
    public static void main(String[] args){
        Queue q=new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while(!q.isEmpty()){
        System.out.println(q.remove());
        }
        System.out.println("front->"+q.front);
        System.out.println("rear->"+q.rear);
        q.add(1);
        System.out.println("front->"+q.front);
        System.out.println("rear->"+q.rear);
    }
}