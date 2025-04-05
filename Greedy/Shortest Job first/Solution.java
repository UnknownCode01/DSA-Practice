import java.util.*;

class Solution {
    static int solve(int bt[]) {
        int n = bt.length;
        Arrays.sort(bt);
        int curr = 0;
        int wt = 0;
        for (int i = 0; i < n; i++) {
            wt += curr;
            curr += bt[i];
        }
        return wt / n;
    }

    public static void main(String[] args) {
        int[] bt = { 4, 3, 7, 1, 2 };
        System.out.println(solve(bt));
    }
}