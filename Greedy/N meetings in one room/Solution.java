import java.util.*;

class Solution {
    static class Pair {
        int start;
        int end;
        int index;

        Pair(int s, int e, int i) {
            this.start = s;
            this.end = e;
            this.index = i;
        }
    }

    public static int maxMeetings(int start[], int end[]) {
        int n = start.length;
        Pair[] meetings = new Pair[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Pair(start[i], end[i], i);
        }
        Arrays.sort(meetings,(a,b)->a.end-b.end);
        int count = 1;
        int freeTime = meetings[0].end;
        for(int i=1;i<n;i++){
            if(meetings[i].start>freeTime){
                count++;
                freeTime = meetings[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(start, end));
    }
}