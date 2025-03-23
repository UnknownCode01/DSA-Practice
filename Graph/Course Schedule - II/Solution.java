import java.util.*;

class Solution {
    public static int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        // for(int i:indegree){
        //     System.out.print(i+" -> ");
        // }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                // System.out.println(i);
                q.add(i);
            }
        }
        // System.out.println("->"+q.size());
        // ArrayList<Integer> topo = new ArrayList<>();
        int[] topo = new int[V];
        int index = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            topo[index++]=curr;
            // topo.add(curr);
            for (int i : adj.get(curr)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        // System.out.println(topo.length);
        if (index == V) {
            return topo;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int V = 2;
        int[][] prerequisites = { { 0, 1 }, { 1, 0 } };
        int[] ans = findOrder(V, prerequisites);
        for(int i:ans){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}