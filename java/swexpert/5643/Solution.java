
/**
* @author suho kim
* @no 5643
* @title 키 순서
* @date 2021.09.29
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine().trim());
    for (int t = 1; t <= T; ++t) {

      int N = Integer.parseInt(br.readLine().trim());
      int M = Integer.parseInt(br.readLine().trim());

      long[][] graph = new long[N + 1][N + 1];

      for (int i = 1; i < N + 1; ++i) {
        for (int j = 1; j < N + 1; ++j) {
          graph[i][j] = Integer.MAX_VALUE;
        }
      }

      for (int i = 0; i < M; ++i) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        graph[from][to] = 1;
      }

      System.out.println(String.format("#%d %d", t, floyd(graph, N)));
    }
  }

  private static int floyd(long[][] graph, int N) {
    int retVal = 0;

    for (int via = 1; via < N + 1; ++via) {
      for (int from = 1; from < N + 1; ++from) {
        for (int to = 1; to < N + 1; ++to) {
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }

    for (int i = 1; i < N + 1; ++i) {
      int count = 0;
      for (int j = 1; j < N + 1; ++j) {
        if (graph[i][j] != Integer.MAX_VALUE || graph[j][i] != Integer.MAX_VALUE)
          ++count;
      }

      retVal += count == N - 1 ? 1 : 0;
    }

    return retVal;
  }
}
