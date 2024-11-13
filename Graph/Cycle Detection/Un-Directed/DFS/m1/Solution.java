import java.util.*;
class Solution {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean cycle(ArrayList<ArrayList<Edge>> adj) {
        boolean[] vis = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                if(cycleUtil(adj, vis, i, -1)){
                    return true;
                }
            }
        }
       return false; 
    }
    public static boolean cycleUtil(ArrayList<ArrayList<Edge>> adj, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for(int i=0;i<adj.get(curr).size();i++){
            Edge e = adj.get(curr).get(i);
            if(!vis[e.dest]){
                if(cycleUtil(adj, vis, e.dest, curr)){
                    return true;
                }
            }else if(e.dest!=par){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<Edge>());
        }
        adj.get(0).add(new Edge(0, 1));
        adj.get(0).add(new Edge(0, 2));
        adj.get(0).add(new Edge(0, 3));
        adj.get(1).add(new Edge(1, 0));
        adj.get(1).add(new Edge(1, 2));
        adj.get(2).add(new Edge(2, 0));
        adj.get(2).add(new Edge(2, 1));
        adj.get(3).add(new Edge(3, 0));
        adj.get(3).add(new Edge(3, 4));
        adj.get(4).add(new Edge(4, 3));
        System.out.println(cycle(adj));
    }
}