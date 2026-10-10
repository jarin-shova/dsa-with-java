package topic_12_graph;

import java.util.ArrayList;

// Time Complexity:
// Creating the adjacency list: O(V)
// Adding all edges: O(E)
// Printing neighbours of a vertex: O(degree(V))
// Overall Time Complexity: O(V + E)

// Space Complexity:
// O(V + E) for storing the adjacency list

public class CreateAWeightedGraphAndPrintNeighbour {

  static class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    Edge zeroto2 = new Edge(0, 2, 2);
    graph[0].add(zeroto2);

    graph[1].add(new Edge(1, 2, 10));
    graph[1].add(new Edge(1, 3, 0));

    graph[2].add(new Edge(2, 0, 2));
    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, -1));

    graph[3].add(new Edge(3, 1, 0));
    graph[3].add(new Edge(3, 2, -1));
  }

  public static void main(String[] args) {
    // graph
    int V = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];

    createGraph(graph);

    // print neighbours of 3 and weight
    for (int i = 0; i < graph[3].size(); i++) {
      Edge e = graph[3].get(i);
      System.out.println(e.dest + ", " + e.weight);
      // System.out.println(graph[2].get(i).dest + ", " + graph[2].get(i).weight);
    }
  }
}
