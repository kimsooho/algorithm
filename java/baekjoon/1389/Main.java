
/**
 * @author suho kim
 * @no 1389
 * @title 케빈 베이컨의 6단계 법칙
 * @url https://www.acmicpc.net/problem/1389
 * @date 2022.01.05
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][N + 1];

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        graph[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph[from][to] = 1;
      graph[to][from] = 1;
    }

    for (int via = 1; via < N + 1; ++via) {
      for (int from = 1; from < N + 1; ++from) {
        for (int to = 1; to < N + 1; ++to) {
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }

    int result = 0;
    int minValue = Integer.MAX_VALUE;

    for (int i = 1; i < N + 1; ++i) {
      int sum = 0;
      for (int j = 1; j < N + 1; ++j) {
        if (i != j && graph[i][j] != Integer.MAX_VALUE / 2)
          sum += graph[i][j];
      }

      if (sum < minValue) {
        result = i;
        minValue = sum;
      }
    }

    System.out.println(result);
  }
}
