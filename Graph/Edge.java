package Algorithm.Graph;

public class Edge {

  private int v;
  private int w;

  public Edge(int v, int w) {
    this.v = v;
    this.w = w;
  }

  public Edge() {}

  public int getV() {
    return v;
  }

  public int getW() {
    return w;
  }

  public void setV(int v) {
    this.v = v;
  }

  public void setW(int w) {
    this.w = w;
  }
}
