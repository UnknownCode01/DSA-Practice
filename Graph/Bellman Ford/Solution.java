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
        graph[1].add(new Edge(1,2,-4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int V = graph.length;
        int[] dis = new int[V];
        for(int i=0;i<V;i++){
            if(i!=0){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<V-1;i++){     // V-1 times loop
            for(int j=0;j<V;j++){   // this and next line in total E times run
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //Relaxation
                    if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                        dis[v] = dis[u]+wt; 
                    }
                }
            }
        }
        //Print
        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }

    }

    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        int src = 0;
        bellmanFord(graph, src);
        //Another Approach
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph2(graph2);
        src = 0;
        bellmanFord2(graph2, src, V);    
    }
    //2nd Approach
    public static void createGraph2(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V){
        int[] dis = new int[V];
        for(int i=0;i<V;i++){
            if(i!=0){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<V-1;i++){     // V-1 times loop
            for(int j=0;j<graph.size();j++){    //E times loop
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                //Relaxation
                if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                    dis[v] = dis[u]+wt; 
                }
            }
        }
        //Print
        System.out.println("\nAnother");
        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }

    }
}