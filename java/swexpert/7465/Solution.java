 /**
 * @author suho kim
 * @no 7465
 * @title 창용 마을 무리의 개수
 * @date 2021.08.24
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
  static ArrayList<ArrayList<Integer>> graph;
  static Queue<Integer> q;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    for (int t = 1; t <= T; ++t) {
      st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      graph = new ArrayList<ArrayList<Integer>>();
      q = new LinkedList<Integer>();
      int groupCount = 0;

      visited = new boolean[N + 1];
      for (int i = 0; i < N + 1; ++i) {
        graph.add(new ArrayList<Integer>());
      }

      for (int i = 0; i < M; ++i) {
        st = new StringTokenizer(br.readLine());
        if (st.countTokens() > 1) {
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          graph.get(a).add(b);
          graph.get(b).add(a);
        }
      }

      for (int i = 1; i < N + 1; ++i) {
        if (!visited[i]) {
          ++groupCount;
          q.offer(i);
          bfs();
        }
      }

      System.out.println(String.format("#%d %d", t, groupCount));
    }
  }

  private static void bfs() {
    while (!q.isEmpty()) {
      int idx = q.poll();
      visited[idx] = true;

      for (int i : graph.get(idx)) {
        if (!visited[i])
          q.offer(i);
      }
    }
  }
}
