import java.util.*;

class Solution {
    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.offer(new iPair(src, 0));

        while (!pq.isEmpty()) {
            // Get the node with the smallest distance
            iPair current = pq.poll();
            int u = current.first;
            int d = current.second;

            // If the distance is already greater than the shortest found so far, skip it
            if (d > dist[u]) continue;

            // Explore the neighbors of the current node
            for (iPair neighbor : adj.get(u)) {
                int v = neighbor.first;    // Neighbor node
                int weight = neighbor.second; // Edge weight

                // If a shorter path to v is found, update the distance and add it to the queue
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new iPair(v, dist[v]));
                }
            }
        }

        // Convert the distance array to an ArrayList and return
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ans.add(dist[i]);
        }
        System.out.println(ans);
        return ans;
    }
    public static void createGraph(ArrayList<ArrayList<iPair>> adj){
        int V = 3;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new iPair(1, 5)); 
        adj.get(0).add(new iPair(2, 2)); 
        adj.get(1).add(new iPair(2, -8)); 


        System.out.println(adj);
    }
    public static void createGraph2(ArrayList<ArrayList<iPair>> adj){
        int V = 4;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new iPair(1, 1)); 
        adj.get(0).add(new iPair(2, 2)); 
        adj.get(1).add(new iPair(3, 1)); 
        adj.get(2).add(new iPair(3, -3)); 


        System.out.println(adj);
    }
    public static void main(String[] args){
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        createGraph(adj);
        dijkstra(adj,0);
        System.out.println();
        ArrayList<ArrayList<iPair>> adj2 = new ArrayList<>();
        createGraph2(adj2);
        dijkstra(adj2,0);
    }
}