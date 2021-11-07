
/**
 * @author suho kim
 * @no 10159
 * @title 저울
 * @url https://www.acmicpc.net/problem/10159
 * @date 2021.11.07
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());

    int[][] graph = new int[N + 1][N + 1];

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
    }

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
        if (i != j && graph[i][j] == Integer.MAX_VALUE / 2 && graph[j][i] == Integer.MAX_VALUE / 2)
          ++count;
      }
      System.out.println(count);
    }
  }
}
