import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V]; // 0-> no color; 1-> black; 2-> red;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){   //unconnected graph traversal
            if(color[i]==0){    //BFS
                q.add(i);
                color[i]=1;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    int[] ar = graph[curr];
                    // System.out.println(curr);
                    for(int j=0; j<ar.length;j++){
                        if(color[ar[j]]==0){
                            color[ar[j]]=color[curr]==1?2:1;
                            q.add(ar[j]);
                        }else if(color[ar[j]]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        if(isBipartite(graph)==true){
            System.out.println("Barpartite");
        }else{
            System.out.println("Not Barpartite");
        }
    }
}