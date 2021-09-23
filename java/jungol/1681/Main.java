
/**
* @author suho kim
* @no 1681
* @title 해밀턴 순환회로
* @url http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=3030
* @date 2021.09.23
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int result;
  static boolean[] visited;
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    result = Integer.MAX_VALUE;
    int N = Integer.parseInt(br.readLine().trim());
    graph = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited[0] = true;
    dfs(0, 0, 1, N);
    System.out.println(result);
  }

  private static void dfs(int idx, int cost, int count, int size) {
    if (count == size) {
      if (graph[idx][0] == 0)
        return;
      cost += graph[idx][0];
      result = Math.min(result, cost);
      return;
    } else if (cost > result)
      return;

    for (int i = 0; i < size; ++i) {
      if (visited[i] || graph[idx][i] == 0)
        continue;

      visited[i] = true;
      dfs(i, cost + graph[idx][i], count + 1, size);
      visited[i] = false;
    }
  }
}
