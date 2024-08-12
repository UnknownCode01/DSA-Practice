import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] arr = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]>=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<nextGreater.length;i++){
        System.out.print(nextGreater[i]+" ");
        }
    }
}