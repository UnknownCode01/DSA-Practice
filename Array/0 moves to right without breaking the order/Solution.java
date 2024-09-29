import java.util.*;
class Solution{
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static void main(String[] args){
        int[] arr = {1,3,0,5,0,0,4,3,0};
        int x=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[x++]=arr[i];
            }
        }
        for(int i=x;i<arr.length;i++){
            arr[i]=0;
        }
        
        for(int i:arr){
            System.out.print(i+" ");

        }
    }
}