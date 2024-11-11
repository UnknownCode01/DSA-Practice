import java.util.*;
class Solution {
    public static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        int k=1;
        for(int i=0; i<adj.size(); i++){
            if(vis[i]==0){
                ArrayList<Integer> ar = bfsUtil(adj, vis, i);
                System.out.println("graph "+k+++" : "+ar);
                res.addAll(ar);
                ar.clear();
            }
        }
        return res;
    }
    public static ArrayList<Integer> bfsUtil(ArrayList<ArrayList<Integer>> adj, int[] vis, int i) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        q.add(i);
        vis[i]=1;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ar.add(node);
            for(int x:adj.get(node)){
                if(vis[x]==0){
                    q.add(x);
                    vis[x]=1;
                }
            }
        }
        return ar;
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
        ArrayList<Integer> res = bfsOfGraph(adj);
        System.out.println("BFS : "+res);
    }
}