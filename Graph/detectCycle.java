import java.util.ArrayList;

public class detectCycle {
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
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
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

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtils(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtils(ArrayList<Edge> graph[], boolean visited[], int curr, int parent) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case3
            if (!visited[e.dst]) {
                if (detectCycleUtils(graph, visited, e.dst, curr))
                    return true;

            } else if (visited[e.dst] && e.dst != parent) { // case 1
                return true;

            }
            // case 2
            /// do npthind
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        DFS(graph);
        System.out.println(detectCycle(graph));
    }
}
