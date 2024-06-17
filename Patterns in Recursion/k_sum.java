import java.util.*;
class k_sum{
    public static void print(int[] arr, int n, int sum, int add, int index, Stack stack1){
        if(add>sum){
            return;
        }
        if(index==n){
            if(add==sum){
            System.out.println(stack1);
            }
            return;
        }
        
        stack1.push(arr[index]);
        print(arr,n,sum,add+arr[index],index+1,stack1);  
        stack1.pop();      
        print(arr,n,sum,add,index+1,stack1);        
    }
    public static void main(String[] args){
        int[] arr={1,2,0,3};
        int n=4;
        int sum=3;
        int add=0;
        Stack stack1 = new Stack();
        print(arr,n,sum,add,0,stack1);
    }
}