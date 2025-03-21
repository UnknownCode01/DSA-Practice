class Solution{
    public static boolean dfs(int node, int col, int[][] graph, int[] color) {
        color[node] = col;
        for(int i:graph[node]){
            if(color[i]==0){
                if(!dfs(i,col==1?2:1,graph,color)){
                    return false;
                }
            }else if(color[i]==col){
                return false;
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V]; // 0-> no color; 1-> black; 2-> red;
        for(int i=0;i<V;i++){ 
            if(color[i]==0){
                if(!dfs(i,1,graph,color)){
                    return false;
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