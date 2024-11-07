import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectDirectedGraph {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 0));

    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSUtils(graph, visited, i);
            }
        }
    }

    public static void DFSUtils(ArrayList<Edge> graph[], boolean visited[], int curr) {

        System.out.print(curr + "  ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dst]) {
                DFSUtils(graph, visited, e.dst);
            }
        }
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtils(graph, visited, stack, i))
                    return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtils(ArrayList<Edge> graph[], boolean visited[], boolean stack[], int curr) {
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dst])
                return true;
            else if (!visited[e.dst]) {
                if (isCycleUtils(graph, visited, stack, e.dst))
                    return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        DFS(graph);
        System.out.println();
        System.out.println(isCycle(graph));
    }
}
