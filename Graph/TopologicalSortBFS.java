import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
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

    public static void creteInDeg(ArrayList<Edge> graph[], int inDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int V = i;
            for (int j = 0; j < graph[V].size(); j++) {
                Edge e = graph[V].get(j);
                inDeg[e.dst]++;
            }
        }
    }

    public static void TopoLogySortBFS(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        creteInDeg(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + "  ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dst]--;
                if (inDeg[e.dst] == 0) {
                    q.add(e.dst);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        TopoLogySortBFS(graph);
    }
}
