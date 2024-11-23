import java.util.*;
class Solution {
    public static void calIndegree(ArrayList<ArrayList<Integer>> adj, int[] indegree){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
    }

    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[adj.size()];
        calIndegree(adj, indegree);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            res.add(curr);
            for(int i=0;i<adj.get(curr).size();i++){
                indegree[adj.get(curr).get(i)]--;
                if(indegree[adj.get(curr).get(i)]==0){
                    q.add(adj.get(curr).get(i));
                }
            }
        }
        return res;
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