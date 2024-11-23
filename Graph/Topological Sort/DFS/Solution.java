import java.util.*;
class Solution {
     public static void topoSortUtil(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s){
        vis[node] = true;
        for(int i:adj.get(node)){
            if(vis[i] == false){
                topoSortUtil(i,vis,adj,s);
            }
        }
        s.push(node);
    }

    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                topoSortUtil(i, vis, adj, s);
            }
        }
        while(!s.isEmpty()){
            ls.add(s.pop());
        }
       return ls; 
    }

    public static void createGraph(ArrayList<ArrayList<Integer>> adj){
        adj.add(new ArrayList<>());  
        adj.add(new ArrayList<>());        
        adj.add(new ArrayList<>(Arrays.asList(3)));     
        adj.add(new ArrayList<>(Arrays.asList(1)));        
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        System.out.println("Adj : "+adj);
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);
        ArrayList<Integer> res = topoSort(adj);
        System.out.println("Topologically Sorted : "+res);
    }
}