
/**
 * @author suho kim
 * @no 1263
 * @title 사람 네트워크2
 * @date 2021.09.16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for (int t = 1; t <= T; ++t) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      int[][] graph = new int[N][N];

      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          graph[i][j] = Integer.parseInt(st.nextToken());
          if (graph[i][j] == 0) {
            graph[i][j] = Integer.MAX_VALUE / 2;
          }
        }
      }

      System.out.println(String.format("#%d %d", t, floyd(graph, N)));
    }
  }

  private static int floyd(int[][] graph, int N) {
    int retVal = Integer.MAX_VALUE;
    for (int via = 0; via < N; ++via) {
      for (int from = 0; from < N; ++from) {
        for (int to = 0; to < N; ++to) {
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }
    // for (int i = 0; i < N; ++i) {
    // for (int j = 0; j < N; ++j) {
    // System.out.print(graph[i][j] + " ");
    // }
    // System.out.println();
    // }

    for (int i = 0; i < N; ++i) {
      int count = 0;
      for (int j = 0; j < N; ++j) {
        if (i == j)
          continue;

        count += graph[i][j];
      }
      retVal = Math.min(retVal, count);
    }

    return retVal;
  }
}