import java.util.*;
class Solution {
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);
        for(int i:adj.get(node)){
            if(vis[i] == false){
                dfs(i,vis,adj,ls);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        int k=1;
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                ArrayList<Integer> ls = dfsUtil(adj, vis, i);
                System.out.println("graph "+k+++" : "+ls);
                res.addAll(ls);
                ls.clear();
            }
        }
       return res; 
    }
    public static ArrayList<Integer> dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i) {
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(i,vis,adj,ls);
        return ls;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(2);
        temp.add(3);
        temp.add(1);
        adj.add(new ArrayList(temp));
        temp.clear();
        temp.add(0);
        adj.add(new ArrayList(temp));
        temp.clear();
        temp.add(0);
        temp.add(4);
        adj.add(new ArrayList(temp));
        temp.clear();
        temp.add(0);
        adj.add(new ArrayList(temp));
        temp.clear();
        temp.add(2);
        adj.add(new ArrayList(temp));
        // temp.clear();
        // temp.add(6);
        // adj.add(new ArrayList(temp));
        // temp.clear();
        // temp.add(5);
        // adj.add(new ArrayList(temp));
        System.out.println("Adj : "+adj);
        ArrayList<Integer> ar = dfsOfGraph(adj);
        System.out.println("BFS : "+ar);
    }
}