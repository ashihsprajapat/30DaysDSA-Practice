import java.util.ArrayList;
import java.util.Stack;

public class TopologySort {
    public static class Edge {
        int src;
        int dst;

        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[4].add(new Edge(5, 0));
        graph[4].add(new Edge(5, 2));
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSUtils(graph, visited, i);
            }
        }
    }

    public static void DFSUtils(ArrayList<Edge> graph[], boolean vistied[], int curr) {
        vistied[curr] = true;
        System.out.print(curr + "  ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vistied[e.dst]) {
                DFSUtils(graph, vistied, e.dst);
            }
        }
    }

    public static void TopologicSor(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                TopologiUtils(graph, visited, i, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + "   ");
        }
    }

    public static void TopologiUtils(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> s) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dst]) {
                TopologiUtils(graph, visited, e.dst, s);
            }

        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        // DFS(graph);
        TopologicSor(graph);
    }
}
