import java.util.*;
class Solution {
    static boolean isSafe(int node, List<Integer>[] G, int color[], int currColor) {
        for(int i=0;i<G[node].size();i++){
            if(color[G[node].get(i)]==currColor){
                return false;
            }
        }
        return true;
    }
    static boolean solve(int node, List<Integer>[] G, int m, int color[]) {
        if(node==G.length){
            return true;
        }

        for(int i=1;i<=m;i++){
            if(isSafe(node,G,color,i)){
                color[node]=i;
                if(solve(node+1,G,m,color)){
                    return true;
                } 
                color[node]=0;
            }
        }
        return false;
    }
    static boolean graphColoring(int v, List<int[]> edges, int m) {
        int n = edges.size();
        int[] color = new int[v];
        List<Integer>[] G = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            G[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            G[edge[0]].add(edge[1]);
            G[edge[1]].add(edge[0]);
        }
        return solve(0,G,m,color);
    }
    public static void main(String[] args){
        int v=4;
        int m=3;
        List<int[]> edges = new ArrayList<>();
        int[] arr = new int[2];
        arr[0]=0;
        arr[1]=1;
        edges.add(arr);
        arr[0]=1;
        arr[1]=2;
        edges.add(arr);
        arr[0]=2;
        arr[1]=3;
        edges.add(arr);
        arr[0]=3;
        arr[1]=0;
        edges.add(arr);
        arr[0]=0;
        arr[1]=2;
        edges.add(arr);
        System.out.println(graphColoring(v,edges,m));
    }
}
