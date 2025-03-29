import java.util.*;

class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        int mini = newInterval[0];
        int maxi = newInterval[1];
        while (i < n && newInterval[1] >= intervals[i][0]) {
            mini = Math.min(mini, intervals[i][0]);
            maxi = Math.max(maxi, intervals[i][1]);
            i++;
        }
        ans.add(new int[] { mini, maxi });
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] ans = insert(intervals, newInterval);
        for (int i = 0; i < ans.length; i++) {
            System.out.print("{" + ans[i][0] + " " + ans[i][1] + "} ");
        }
        System.out.println();
    }
}