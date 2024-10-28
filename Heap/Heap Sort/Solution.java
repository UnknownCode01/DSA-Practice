import java.util.*;
class Solution{
    public static void maxHeapify(int i,int size,int[] arr){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxi = i;
        if(left<size && arr[left]>arr[maxi]){
            maxi=left;
        }
        if(right<size && arr[right]>arr[maxi]){
            maxi=right;
        }
        if(maxi!=i){
            int temp = arr[maxi];
            arr[maxi]=arr[i];
            arr[i]=temp;
            maxHeapify(maxi,size,arr);
        }
    }
    public static void heapSort(int[] arr){
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            maxHeapify(i,n,arr);
        }
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            maxHeapify(0,i,arr);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,3,2,5,4};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}