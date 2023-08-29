package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kruskal {

  static int[][] graph; // 그래프(간선)
  static int N; // 총 정점 수
  static int M; // 간선 수
  static int[] parent; // 크루스칼 알고리즘을 위한 부모(서로소 집합)

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    graph = new int[M][3];
    parent = new int[N];

    // 각 정점과 연결된 정점을 저장해 그래프 생성
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      graph[i][0] = Integer.parseInt(str[0]) - 1;
      graph[i][1] = Integer.parseInt(str[1]) - 1;
      graph[i][2] = Integer.parseInt(str[2]);
    }
    Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

    for (int i = 0; i < N; ++i) {
      parent[i] = i;
    }

    kruskal();
  }

  public static void kruskal() {
    int cnt = 0;

    for (int i = 0; i < M; ++i) {
      if (find(graph[i][0]) != find(graph[i][1])) {
        union(graph[i][0], graph[i][1]);
        cnt += graph[i][2];
      }
    }

    System.out.println(cnt);
  }

  public static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a > b) {
      parent[a] = b;
    } else {
      parent[b] = a;
    }
  }

  public static int find(int i) {
    if (parent[i] == i) {
      return i;
    } else {
      return find(parent[i]);
    }
  }
}
