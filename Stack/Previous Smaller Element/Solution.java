import java.util.*;
class Solution{
    public static int[] prevSmallerElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
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
        int[] arr = {3,4,1,2,5,3};
        int[] ans = prevSmallerElement(arr);
        for(int i:ans){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}