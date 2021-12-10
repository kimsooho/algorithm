
/**
 * @author suho kim
 * @no 2660
 * @title 회장뽑기
 * @url https://www.acmicpc.net/problem/2660
 * @date 2021.12.10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<Integer, TreeSet<Integer>>();

    int N = Integer.parseInt(st.nextToken());

    int[][] graph = new int[N + 1][N + 1];

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        graph[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    while (true) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      if (from == -1 && to == -1)
        break;

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

    for (int i = 1; i <= N; ++i) {
      int maxVal = 0;
      for (int j = 1; j <= N; ++j) {
        if (i == j)
          continue;

        maxVal = Math.max(maxVal, graph[i][j]);
      }

      if (!tm.containsKey(maxVal)) {
        tm.put(maxVal, new TreeSet<Integer>());
      }

      tm.get(maxVal).add(i);
    }

    System.out.println(tm.firstKey() + " " + tm.firstEntry().getValue().size());
    for (int n : tm.firstEntry().getValue()) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
}
