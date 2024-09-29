import java.util.*;
class Solution{
    public static void pushAtBottom(Stack<Integer> st, int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int top = st.pop();
        pushAtBottom(st,x);
        st.push(top);
    }
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverse(st);
        pushAtBottom(st,top);
    }
    public static void printStack(Stack<Integer> st){
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Stack<Integer> st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        // printStack(st);
        reverse(st);
        printStack(st);
    }
}