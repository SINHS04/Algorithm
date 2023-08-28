package Algorithm.Graph;

public class Edge implements Comparable<Edge> {

  private int v;
  private int w;

  public Edge(int v, int w) {
    this.v = v;
    this.w = w;
  }

  public int getV() {
    return v;
  }

  public int getW() {
    return w;
  }

  @Override
  public int compareTo(Edge o) {
    return this.w - o.w;
  }
}
