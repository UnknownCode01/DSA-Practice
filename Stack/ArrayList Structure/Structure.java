import java.util.*;
class Structure{
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>(); 
        public static boolean isEmpty(){
            if(list.size()==0) return true;
            return false;
        }
        public static void push(int data){
            list.addLast(data);
            return;
        }
        public static int peek(){
            return list.get(list.size() - 1);
        }
        public static int pop(){
            int top=list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }
        public static void show(){
            while(!list.isEmpty()){
                System.out.print(peek()+" ");
                pop();
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