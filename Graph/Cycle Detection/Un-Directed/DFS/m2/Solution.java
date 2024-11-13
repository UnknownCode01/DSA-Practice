import java.util.*;

class Solution {
    public static boolean cycle(ArrayList<ArrayList<Integer>> adj) {
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
    public static boolean cycleUtil(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for(int i=0;i<adj.get(curr).size();i++){
            int e = adj.get(curr).get(i);
            if(!vis[e]){
                if(cycleUtil(adj, vis, e, curr)){
                    return true;
                }
            }else if(e!=par){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(3);
        System.out.println(cycle(adj));
    }
}