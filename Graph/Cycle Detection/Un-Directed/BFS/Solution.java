import java.util.*;

class Solution {
    static class Pair {
        Integer f;
        Integer s;

        Pair(Integer first, Integer second) {
            this.f = first;
            this.s = second;
        }
    }
    public static boolean cycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
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
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curr,par));
        vis[curr] = true;
        while(!q.isEmpty()){
            int i1 = q.peek().f;
            int i2 = q.peek().s;
            q.remove();
            for(int x:adj.get(i1)){
                if(!vis[x]){
                    q.add(new Pair(x,i1));
                    vis[x]=true;
                }else if(x!=i2){
                    return true;
                }
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