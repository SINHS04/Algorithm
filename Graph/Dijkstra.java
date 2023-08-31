package Algorithm.Graph;

import java.io.*;
import java.util.*;

public class Dijkstra {

  static ArrayList<Edge>[] graph; // 연결 리스트
  static int N; // 총 정점 수
  static int M; // 간선 수
  static ArrayList<Integer> S;
  static int[] weight;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    S = new ArrayList<>();
    graph = new ArrayList[N];
    weight = new int[N];

    // 정점만큼 리스트 생성 및 각 노드에 최대값 대입
    for (int i = 0; i < N; ++i) {
      graph[i] = new ArrayList<Edge>();
      weight[i] = Integer.MAX_VALUE;
    }

    // 각 정점과 연결된 정점을 저장해 그래프 생성
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      int a = Integer.parseInt(str[0]) - 1;
      int b = Integer.parseInt(str[1]) - 1;
      int c = Integer.parseInt(str[2]);
      graph[a].add(new Edge(b, c));
    }

    dijkstra(0);
  }

  public static void dijkstra(int start) {
    boolean[] visited = new boolean[N];
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    queue.offer(new Edge(start, 0));
    weight[start] = 0;

    while (!queue.isEmpty()) {
      Edge edge = queue.poll();
      int v = edge.getV();

      if (!visited[v]) {
        visited[v] = true;

        for (Edge e : graph[v]) {
          if (!visited[e.getV()] && weight[v] + e.getW() < weight[e.getV()]) {
            weight[e.getV()] = weight[v] + e.getW();
          }

          queue.add(e);
        }
      }
    }

    for (int i = 0; i < N; ++i) {
      System.out.println(
        String.format("%d to %d: %d", start + 1, i + 1, weight[i])
      );
    }
  }
}
