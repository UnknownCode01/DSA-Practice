import java.util.*;
class Solution{
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
        static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }
        static int pop(){
            if(q1.isEmpty() && q2.isEmpty()){
                return -1;
            }
            int temp=-1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    temp=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                q2.add(temp);
                }
            }
            else{
                while(!q2.isEmpty()){
                    temp=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                q1.add(temp);
                }
            }
            return temp;
        }
        static int peek(){
            if(q1.isEmpty() && q2.isEmpty()){
                return -1;
            }
            int temp=-1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    temp=q1.remove();
                    q2.add(temp);
                }
            }
            else{
                while(!q2.isEmpty()){
                    temp=q2.remove();
                    q1.add(temp);
                }
            }
            return temp;
        }
    
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}