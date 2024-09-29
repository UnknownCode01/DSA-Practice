import java.util.*;
class Solution{
    public static int maxArea(int[] arr){
        int max = 0;
        int n = arr.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        //Next Smaller Right
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //Next Smaller Left
        s = new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=n;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //Area
        for(int i=0;i<n;i++){
            int temp=(nsr[i]-nsl[i]-1)*arr[i];
            max=Math.max(temp,max);
        }
        return max;
    }
    public static void main(String[] args){
        int []arr={2,1,5,6,2,3};
        System.out.println(maxArea(arr));
    }
}