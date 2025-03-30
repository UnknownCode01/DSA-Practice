import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxi = -1;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= maxi) {
                ans.add(arr[i]);
                maxi = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        System.out.println(leaders(arr));
    }
}