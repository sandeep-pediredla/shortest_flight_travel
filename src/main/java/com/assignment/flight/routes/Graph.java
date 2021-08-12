package com.assignment.flight.routes;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private final int vCount;
  private final double[][] adj;

  public Graph(final int vCount) {
    this.vCount = vCount;
    adj = new double[vCount][vCount];
    for (int i = 0; i < vCount; i++) {
      for (int j = 0; j < vCount; j++) {
        if (i != j) {
          adj[i][j] = Double.MAX_VALUE;
        }
      }
    }
  }

  public int getvCount() {
    return vCount;
  }

  public double[][] getAdj() {
    return adj;
  }

  public void addEdge(final int i, final int j, final double weight) {
    adj[i][j] = weight;
  }

  public void removeEdge(final int i, final int j) {
    adj[i][j] = Double.MAX_VALUE;
  }

  public boolean hasEdge(final int i, final int j) {
    return adj[i][j] != Double.MAX_VALUE && adj[i][j] != 0;
  }

  public List<Integer> neighbours(final int vertex) {
    List<Integer> edges = new ArrayList<Integer>();
    for (int i = 0; i < vCount; i++) if (hasEdge(vertex, i)) edges.add(i);
    return edges;
  }
}
