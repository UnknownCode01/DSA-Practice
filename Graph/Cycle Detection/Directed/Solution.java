import java.util.*;
class Solution{
    public static void createGraph(ArrayList<ArrayList<Integer>> graph, int V){
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(2).add(3);
        graph.get(3).add(0);
    }
    public static boolean dfs(int curr, boolean[] vis, boolean[] stack, ArrayList<ArrayList<Integer>> graph){
        vis[curr] = true;
        stack[curr] = true;
        for(int i:graph.get(curr)){
            //node not visited
            if(!vis[i] && dfs(i, vis, stack, graph)){
                return true;
            }
            //node visited on the same path
            if(stack[i]==true){
                return true;
            }
        }
        stack[curr]= false;
        return false;
    }
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int V){
        boolean[] vis = new boolean[V];
        boolean[] stack = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, vis, stack, graph)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 4;
        createGraph(graph, V);
        System.out.println(isCyclic(graph, V));
    }
}