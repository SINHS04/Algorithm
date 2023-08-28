package Algorithm.Graph;

import Algorithm.Graph.Edge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prim {

  static ArrayList<ArrayList<Edge>> vertex; // 연결 리스트
  static int N; // 총 정점 수
  static int M; // 간선 수
  static int[] weight; // 노드까지 가중치

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    vertex = new ArrayList<>();
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    weight = new int[N];

    // 정점만큼 리스트 생성 및 각 노드에 최대값 대입
    for (int i = 0; i < N; ++i) {
      vertex.add(new ArrayList<Edge>());
      weight[i] = Integer.MAX_VALUE;
    }

    // 각 정점과 연결된 정점을 저장해 그래프 생성
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      int a = Integer.parseInt(str[0]) - 1;
      int b = Integer.parseInt(str[1]) - 1;
      int c = Integer.parseInt(str[2]);
      vertex.get(a).add(new Edge(b, c));
      vertex.get(b).add(new Edge(a, c));
    }

    prim(0);

    for (int i = 0; i < N; ++i) {
      System.out.println(weight[i]);
    }
  }

  public static void prim(int start) {
    weight[0] = 0;
  }

  public static Edge getMin(ArrayList<Edge> list) {
    Edge ret = new Edge();
    int min = Integer.MAX_VALUE;
    for (Edge e : list) {
      if (min > e.getW()) {
        min = e.getW();
        ret = e;
      }
    }

    return ret;
  }
}
