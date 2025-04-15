import java.util.ArrayList;
import java.util.PriorityQueue;

public class DilkstrasAlgo {
    public static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dst = s;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print((i));
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print("  -> " + e.dst);
            }
            System.out.println();
        }
    }

    public static class pair implements Comparable<pair> {
        int n;
        int path;

        public pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path;// path base sorting for my pair
        }
    }

    public static void dilkstra(ArrayList<Edge> graph[], int src) {
        int dst[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dst[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));
        // bfs
        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dst;
                    int w = e.wt;
                    if ((dst[u] + w) < dst[v]) {// update dustance of src to v;
                        dst[v] = dst[u] + w;
                        pq.add(new pair(v, dst[v]));
                    }
                }
            }

        }
        for (int i = 0; i < dst.length; i++) {
            System.out.println(dst[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // printGraph(graph);
        dilkstra(graph, 0);
    }
}
