import java.util.*;

class Solution1 {
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[N];

        for (int i : arr) {
            hm.put(i, -1);
            pq.offer(i);
        }
        int temp = -1;
        int k = 1;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (x == temp) {
                hm.put(x, hm.get(x));
            } else {
                hm.put(x, k);
                k++;
            }
            temp = x;
        }
        for(int i=0;i<N;i++){
            ans[i]=hm.get(arr[i]);
        }

        return ans;
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