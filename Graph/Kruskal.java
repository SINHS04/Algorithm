package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskal {

  static ArrayList<Edge>[] graph; // 연결 리스트
  static int N; // 총 정점 수
  static int M; // 간선 수
  static ArrayList<Integer> S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    S = new ArrayList<>();
    graph = new ArrayList[N];

    // 정점만큼 리스트 생성 및 각 노드에 최대값 대입
    for (int i = 0; i < N; ++i) {
      graph[i] = new ArrayList<Edge>();
    }

    // 각 정점과 연결된 정점을 저장해 그래프 생성
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      int a = Integer.parseInt(str[0]) - 1;
      int b = Integer.parseInt(str[1]) - 1;
      int c = Integer.parseInt(str[2]);
      graph[a].add(new Edge(b, c));
      graph[b].add(new Edge(a, c));
    }

    kruskal();
  }

  public static void kruskal() {
    int cnt = 0;

    System.out.println(cnt);
  }
}
