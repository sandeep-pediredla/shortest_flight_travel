package com.assignment.flight.routes;

public class Edge implements Comparable<Edge> {

  protected String src, dest;
  protected double weight;

  public Edge(String src, String dest, double weight) {
    super();
    this.src = src;
    this.dest = dest;
    this.weight = weight;
  }

  // Comparator function used for sorting edges based on their travel time
  @Override
  public int compareTo(Edge compareEdge) {
    return (int) (this.weight - compareEdge.weight);
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getDest() {
    return dest;
  }

  public void setDest(String dest) {
    this.dest = dest;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "(" + src + ", " + dest + ") weight: " + weight;
  }
}
