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

    public static void createGraph(ArrayList<Edge>[] graph, int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int[] dis = new int[graph.length];  // dis[i] -> distance of i from src.
        for(int i=0;i<dis.length;i++){
            if(i!=src){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[dis.length];
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){   // BFS
            Pair curr = pq.remove();
            // Neighbors
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for(Edge x: graph[curr.n]){
                    int u = curr.n;
                    int v = x.dest;
                    int wt = x.wt;
                    if(dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        int src = 0;
        dijkstra(graph, src);
    }
}