import java.util.*;
class Solution{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src, int dest, boolean[] visited, Stack<Integer> s){
        if(src==dest){
            return true;
        }
        visited[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited, s)){
                s.push(e.dest);
                return true;
            }
        }
        return false;
    }
    public static void createGraph(ArrayList<Edge>[] graph, int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        graph[6].add(new Edge(6,5,1));

    }
    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        Stack<Integer> s = new Stack<>();
        if(hasPath(graph, 0, 5, new boolean[V], s)){
            System.out.println("True");
            System.out.print(0);
            while(!s.isEmpty()){
                System.out.print("->"+s.pop());
            }
        }else{
            System.out.println("False");
        }     
    }
}