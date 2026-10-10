package topic_12_graph;

import java.util.ArrayList;
// Time Complexity:
// Creating the adjacency list: O(V)
// Adding all edges: O(E)
// Printing neighbours of a vertex: O(degree(V))
// Overall Time Complexity: O(V + E)

// Space Complexity:
// O(V + E) for storing the adjacency list
public class CreateAGraphAndPrintNeighbours {
  static class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    // create empty ArrayList at each index
    // it is the adjacency-list structure
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    // add edges to the adjacency-list structure
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 2));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 2));
  }

  public static void main(String[] args) {

    int V = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];

    createGraph(graph);

    // print 2's neighbours
    for (int i = 0; i < graph[2].size(); i++) {
      Edge e = graph[2].get(i);
      System.out.println(e.dest);
      // System.out.println(graph[2].get(i).dest);
    }
  }
}
