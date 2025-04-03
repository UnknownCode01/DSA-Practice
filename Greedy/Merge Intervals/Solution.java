import java.util.*;

class Solution {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                ans.add(current);
                current = intervals[i];
            }
        }
        ans.add(current);

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 0, 4 }};
        int[][] ans = merge(intervals);
        int n = ans.length;
        for (int i = 0; i < n; i++) {
            System.out.print("{" + ans[i][0] + "," + ans[i][1] + "} ");
        }
    }
}