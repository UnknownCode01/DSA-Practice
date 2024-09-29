import java.util.*;
class Solution{
    static class Stack{
        static Deque<Integer> dq = new LinkedList<>();
        void push(int data){
            dq.addLast(data);
        }
        int pop(){
            return dq.removeLast();
        }
        int peek(){
            return dq.getLast();
        }

    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek->"+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}