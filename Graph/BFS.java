package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  static ArrayList<ArrayList<Integer>> vertex; // 연결 리스트
  static int N; // 총 정점 수
  static int M; // 간선 수
  static boolean[] visited; // 방문확인

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    vertex = new ArrayList<>();
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    visited = new boolean[N];

    // 정점만큼 리스트 생성
    for (int i = 0; i < N; ++i) {
      vertex.add(new ArrayList<Integer>());
    }

    // 각 정점과 연결된 정점을 저장해 그래프 생성
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      vertex
        .get(Integer.parseInt(str[0]) - 1)
        .add(Integer.parseInt(str[1]) - 1);
    }

    // 너비 우선 탐색
    Queue<Integer> list = new LinkedList<Integer>(); // 앞으로 탐색할 정점
    list.add(0); // 탐색 시작 위치
    visited[0] = true;
    System.out.println("Start");
    while (!list.isEmpty()) {
      int v = list.poll();
      System.out.println(v + 1);
      for (int i : vertex.get(v)) {
        if (!visited[i]) {
          visited[i] = true;
          list.add(i);
        }
      }
    }
  }
}
