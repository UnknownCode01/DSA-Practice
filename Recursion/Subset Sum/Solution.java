import java.util.*;
class Solution{
    public static void f(ArrayList<Integer> arr, int n, int index, int sum, ArrayList<Integer> ans){
        if(index==n){
            ans.add(sum);
            return;
        }
        f(arr,n,index+1,sum+arr.get(index),ans);
        f(arr,n,index+1,sum,ans);
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        int index = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        f(arr,n,index,sum,ans);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        int n = arr.size();
        ArrayList<Integer> ans = subsetSums(arr, n);
        System.out.println(ans);
    }
}