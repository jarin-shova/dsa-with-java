package topic_12_graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class DFS {
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
  public static void dfs(ArrayList<Edge> graph[], int current, boolean visited[]) {
    System.out.print(current + " ");
    visited[current] = true;
    for (int i = 0; i < graph[current].size(); i++) {
      Edge e = graph[current].get(i);
      int neighbour = e.dest;
      if (visited[neighbour] == false) {
        dfs(graph, neighbour, visited);
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
        dfs(graph, i, visited); // 0 1 3 4 2 5 6
      }
    }

    System.out.println();
  }
}
