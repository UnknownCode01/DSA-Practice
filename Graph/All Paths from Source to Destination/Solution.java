import java.util.*;
class Solution {
    public static void findPath(ArrayList<ArrayList<Integer>> adj, int src, int des, String ans) {
        if(src==des){
            System.out.println(ans+des);
        }
        for(int i:adj.get(src)){
            findPath(adj,i,des,ans+src);
        }
    }

   public static void createGraph(ArrayList<ArrayList<Integer>> adj){
        adj.add(new ArrayList<>(Arrays.asList(3)));  
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
        findPath(adj, 5, 1, "");
    }
}