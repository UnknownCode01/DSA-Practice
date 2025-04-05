import java.util.*;

class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int count = 1;
        int last = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if(intervals[i][0]>=last){
                count++;
                last = intervals[i][1];
            }
        }

        return n-count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}