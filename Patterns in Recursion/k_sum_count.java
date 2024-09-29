import java.util.*;
class k_sum_count{
    public static int print(int[] arr, int n, int sum, int add, int index, Stack stack1){
        if(add>sum){
            return 0;
        }
        if(index==n){
            if(add==sum){
            return 1;
            }
            return 0;
        }
        
        stack1.push(arr[index]);
        int l=print(arr,n,sum,add+arr[index],index+1,stack1);  
        stack1.pop();      
        int r=print(arr,n,sum,add,index+1,stack1);   
        return l+r;     
    }
    public static void main(String[] args){
        int[] arr={1,2,0,3};
        int n=4;
        int sum=3;
        int add=0;
        Stack stack1 = new Stack();
        System.out.println(print(arr,n,sum,add,0,stack1));
    }
}