//Space OPtimized
import java.util.*;
class Solution{
    public static int minimumEnergy(int arr[],int n){
        int prev1 = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int left = prev1 + Math.abs(arr[i]-arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1)
                right = prev2 + Math.abs(arr[i]-arr[i-2]);
            int curr = Math.min(left,right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args){
        int arr[] = {10,20,30,10};
        int n = 4;
        System.out.println(minimumEnergy(arr,n));
    }
}
