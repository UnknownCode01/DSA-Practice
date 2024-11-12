import java.util.*;
class Solution{
    public static void createGraph(ArrayList<ArrayList<Integer>> graph, int V){
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(2);
        graph.get(4).add(3);
    }
    public static boolean barpartite(ArrayList<ArrayList<Integer>> graph, int V){
        int[] color = new int[V]; // 0-> no color; 1-> black; 2-> red;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){   //unconnected graph traversal
            if(color[i]==0){    //BFS
                q.add(i);
                color[i]=1;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    ArrayList<Integer> ar = graph.get(curr);
                    // System.out.println(curr);
                    for(int j=0; j<ar.size();j++){
                        if(color[ar.get(j)]==0){
                            color[ar.get(j)]=color[curr]==1?2:1;
                            q.add(ar.get(j));
                        }else if(color[ar.get(j)]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 5;
        createGraph(graph, V);
        if(barpartite(graph, V)==true){
            System.out.println("Barpartite");
        }else{
            System.out.println("Not Barpartite");
        }
    }
}