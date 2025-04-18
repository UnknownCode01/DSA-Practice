import java.util.*;

class Solution {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> li = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<K;i++){
            for(int j=0;j<arr[0].length;j++){
                pq.add(arr[i][j]);
            }
        }
        while(!pq.isEmpty()){
            li.add(pq.poll());
        }
        return li;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int K = 3;
        System.out.println(mergeKArrays(arr, K));
    }
}