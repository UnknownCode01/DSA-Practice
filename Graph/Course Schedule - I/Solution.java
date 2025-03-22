import java.util.*;

class Solution {
    public static boolean canFinish(int V, int[][] prerequisites) {
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
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.remove();
            topo.add(curr);
            for(int i:adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(topo.size()==V){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 2;
        int[][] prerequisites = {{0,1},{1,0}};
        System.out.println(canFinish(V,prerequisites));
    }
}