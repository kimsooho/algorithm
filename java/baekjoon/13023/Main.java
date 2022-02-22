
/**
 * @author suho kim
 * @no 13023
 * @title ABCDE
 * @url https://www.acmicpc.net/problem/13023
 * @date 2022.02.21
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static List<List<Integer>> graph;
  static boolean[] visited;

  static int N;
  static boolean isFriend;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new ArrayList<List<Integer>>();
    visited = new boolean[N];

    for (int i = 0; i < N; ++i) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    for (int i = 0; i < N; ++i) {
      dfs(0, i);
    }

    System.out.println(isFriend ? 1 : 0);
  }

  private static void dfs(int depth, int idx) {
    if (isFriend)
      return;
    if (depth == 5) {
      isFriend = true;
      return;
    }

    for (int nextIdx : graph.get(idx)) {
      if (!visited[nextIdx]) {
        visited[nextIdx] = true;
        dfs(depth + 1, nextIdx);
        visited[nextIdx] = false;
      }
    }
  }
}
