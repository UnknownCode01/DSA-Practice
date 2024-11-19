import java.util.*;
class Solution {
    public static void dfs(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> arr){
        vis[curr]=true;
        for(int x: arr.get(curr)){
            if(!vis[x]){
                dfs(x, vis, arr);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    arr.get(i).add(j);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,arr);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}