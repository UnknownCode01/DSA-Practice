import java.util.*;
class Solution{
    public static int[] prevGreaterElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return ans;
    }
    public static void main(String[] args){
        int[] arr = {3,4,2,1,5,3};
        int[] ans = prevGreaterElement(arr);
        for(int i:ans){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}