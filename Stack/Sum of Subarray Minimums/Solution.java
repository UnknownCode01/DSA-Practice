import java.util.*;
class Solution{
    public static int[] findPSEE(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> si = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!si.isEmpty() && arr[si.peek()]>arr[i]){
                si.pop();
            }
            ans[i] = si.isEmpty()?-1:si.peek();
            si.push(i);
        }
        return ans;
    }
    public static int[] findNSE(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> si = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!si.isEmpty() && arr[si.peek()]>=arr[i]){
                si.pop();
            }
            ans[i] = si.isEmpty()?n:si.peek();
            si.push(i);
        }
        return ans;
    }
    public static int sumSubarrayMins(int[] arr) {
        double ans = 0;
        int n = arr.length;
        int[] pse = findPSEE(arr,n);
        int[] nse = findNSE(arr,n);
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            double left = i-pse[i];
            double right = nse[i]-i;
            ans=(ans+(((left*right)%mod)*arr[i])%mod)%mod;
        }
        return (int)ans;
    }
    public static void main(String[] args){
        int[] arr = {3,1,2,4};   //ans->17
        int ans = sumSubarrayMins(arr);
        System.out.println(ans);
    }
}