import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class part1createGraph {

    public static class Edge {
        int src;
        int dst;
        int wit;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dst = d;
            this.wit = w;

        }
    }

    public static void BFS(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        Edge e1 = graph[0].get(0);
        q.add(e1.src);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + "  ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    // Edge e2 = graph[curr].get(i);
                    q.add(graph[curr].get(i).dst);
                }
            }
        }

    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        System.out.print(curr + "  ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dst]) {
                DFS(graph, e.dst, visited);
            }
        }

    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean visited[], int src, int des) {
        if (src == des) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dst] && hasPath(graph, visited, e.dst, des)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2 VERTEX
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // vertex -4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // vertex -5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // vertex -6
        graph[6].add(new Edge(6, 5, 1));

        // for (int i = 0; i < V; i++) {

        // for (int j = 0; j < graph[i].size(); j++) {
        // Edge e1 = graph[i].get(j);
        // System.out.println(e1.src + ", " + e1.dst + ", " + e1.wit + " ");
        // System.err.println();
        // }
        // System.out.println();
        // }

        // BFS(graph);
        boolean visited[] = new boolean[7];
        System.out.println();
        // DFS(graph, 0, visited);
        System.out.println(hasPath(graph, visited, 0, 7));
    }
}