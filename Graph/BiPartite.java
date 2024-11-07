import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartite {
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
        // graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static void BFS(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + "   ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }

    public static boolean BiPartiteGraph(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!BiPartiteUtils(graph, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean BiPartiteUtils(ArrayList<Edge> graph[], int color[], int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;// yello
        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (color[e.dst] == -1) {// case 3
                    color[e.dst] = color[curr] == 0 ? 1 : 0;
                    q.add(e.dst);
                } else if (color[e.dst] == color[curr]) {// case 1
                    return false;
                }
            }

        }
        return true;

    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        BFS(graph);
        System.out.println(BiPartiteGraph(graph));
    }
}
