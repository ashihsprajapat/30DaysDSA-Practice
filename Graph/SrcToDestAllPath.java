import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.SourceDataLine;

public class SrcToDestAllPath {
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
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[4].add(new Edge(5, 0));
        graph[4].add(new Edge(5, 2));
    }

    public static void SourceDestination(ArrayList<Edge> graph[], int src, int dst, String path) {
        if (src == dst) {
            System.out.println("hi in");
            System.out.print(path + dst + "   ");

            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            SourceDestination(graph, e.dst, dst, path + src);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        SourceDestination(graph, 5, 2, "");
    }
}
