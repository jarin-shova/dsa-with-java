package topic_12_graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
  static class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));

    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 6));

    graph[6].add(new Edge(6, 5));

  }

  // Time complexity = O(V + E)
  // Space complexity = O(V)
  public static void bfs(ArrayList<Edge> graph[], int V, boolean visited[], int start) {
    Queue<Integer> q = new LinkedList<>();

    q.add(start);

    while (!q.isEmpty()) {
      int curr = q.remove();
      if (visited[curr] == false) {
        System.out.print(curr + " ");
        visited[curr] = true;

        // add its neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
          // Edge e = graph[curr].get(i);
          // q.add(e.dest);
          q.add(graph[curr].get(i).dest);
        }
      }
    }
  }

  public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);

    // if all the nodes of the graph are not connected (if there is sub graph)
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        bfs(graph, V, visited, i); // 0 1 2 3 4 5 6
      }
    }
    System.out.println();
  }
}
