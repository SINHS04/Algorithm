package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<ArrayList<Integer>> vertex = new ArrayList<>(); // 연결 리스트
    int N = Integer.parseInt(br.readLine()); // 총 정점 수
    int M = Integer.parseInt(br.readLine()); // 간선 수
    boolean[] visited = new boolean[N]; // 방문확인

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

    // BFS
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
/**
 * 입력 예시
8
22
1 2
1 6
1 8
2 1
2 3
2 5
2 6
3 2
3 4
3 5
4 3
4 5
5 2
5 3
5 4
6 1
6 2
6 7
6 8
7 6
8 1
8 6
 */
