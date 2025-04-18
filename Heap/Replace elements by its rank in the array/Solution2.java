import java.util.*;

class Solution2 {
    static class Pair implements Comparable<Pair> {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }

    static int[] replaceWithRank(int arr[], int N) {
        int[] res = new int[N];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Pair(arr[i], i));
        }

        int rank = 1;

        while (!pq.isEmpty()) {
            int first = pq.peek().first;
            int idx = pq.peek().second;
            pq.poll();
            res[idx] = rank;

            if (!pq.isEmpty() && pq.peek().first != first)
                rank++;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 6 };
        int N = 4;
        int[] ans = replaceWithRank(arr, N);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}