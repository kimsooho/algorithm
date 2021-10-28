
/**
 * @author suho kim
 * @no 14003
 * @title 가장 긴 증가하는 부분 수열 5
 * @url https://www.acmicpc.net/problem/14003
 * @date 2021.09.02
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    long[][] map = new long[N + 1][N + 1];

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        if (i != j)
          map[i][j] = Integer.MAX_VALUE;
      }
    }

    ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<HashMap<Integer, Integer>>();
    for (int i = 0; i < N + 1; ++i) {
      graph.add(new HashMap<Integer, Integer>());
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      map[from][to] = Math.min(map[from][to], cost);

    }

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        for (int k = 1; k < N + 1; ++k) {
          map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
          // from to from to from via via to
        }
      }
    }

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        if (map[i][j] == Integer.MAX_VALUE)
          map[i][j] = 0;
        sb.append(map[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
