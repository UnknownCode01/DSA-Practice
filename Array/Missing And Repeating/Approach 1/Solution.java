import java.util.*;

class Solution {
    static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int rep = 0;
        int miss = 0;
        int[] hash = new int[n + 1];
        for (int i : arr) {
            hash[i]++;
        }
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                miss = i;
            } else if (hash[i] > 1) {
                rep = i;
            }
        }
        ans.add(rep);
        ans.add(miss);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 1, 1 };
        System.out.println(findTwoElement(arr));
    }
}