import java.util.*;
class Solution {
    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int res=1;
        int temp=k;
        int count=1;
        for(int i=arr.length-1;i>0;i--){
            temp=k;
            count=1;
            for(int j=i-1;j>=0;j--){
                if((arr[i]-arr[j])>temp){
                    break;
                }
                temp-=arr[i]-arr[j];
                count++;
                res=Math.max(res,count);
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={1,2,4};
        int k=5;
        System.out.println(maxFrequency(nums,k));
    }
}